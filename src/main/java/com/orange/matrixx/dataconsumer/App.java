package com.orange.matrixx.dataconsumer;

import java.util.Properties;

import org.apache.flink.api.common.eventtime.WatermarkStrategy;
import org.apache.flink.connector.kafka.source.KafkaSource;
import org.apache.flink.connector.kafka.source.enumerator.initializer.OffsetsInitializer;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaProducer;

import com.orange.matrixx.aggregationclasses.DataAggregation;
import com.orange.matrixx.constants.ConfigurationConstants;
import com.orange.matrixx.modeling.EDRModeling;
import com.orange.matrixx.modelingobjects.EDRModel;
import com.orange.matrixx.objects.OEGEvent;
import com.orange.matrixx.utils.ConstantUtilities;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		String consumer_topic_name = args[0];
		String producer_topic_name = args[1];
		String group = args[2];
		final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
		ConstantUtilities.loadConstants();
		Properties properties = new Properties();
		properties.setProperty("bootstrap.servers", ConfigurationConstants.bootStrapServer);
		properties.setProperty("group.id", group);
		properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		properties.put("value.serializer", "org.apache.kafka.common.serialization.ByteArraySerializer");

		try {
			KafkaSource<OEGEvent> source = KafkaSource.<OEGEvent>builder()
					.setBootstrapServers(ConfigurationConstants.bootStrapServer).setTopics(consumer_topic_name)
					.setGroupId(group).setStartingOffsets(OffsetsInitializer.earliest())
					.setValueOnlyDeserializer(new OEGEvent()).build();
			env.fromSource(source, WatermarkStrategy.noWatermarks(), "dataconsumer").map(new EDRModeling())
					.addSink(new FlinkKafkaProducer<>(producer_topic_name, new EDRModel(), properties))
					.name("ERDModeling");
			env.execute("dataconsumer");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
