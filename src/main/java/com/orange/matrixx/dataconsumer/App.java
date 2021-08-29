package com.orange.matrixx.dataconsumer;

import java.util.Properties;

import org.apache.flink.api.common.eventtime.WatermarkStrategy;
import org.apache.flink.connector.kafka.source.KafkaSource;
import org.apache.flink.connector.kafka.source.enumerator.initializer.OffsetsInitializer;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaProducer;

import com.orange.matrixx.aggregationclasses.DataAggregation;
import com.orange.matrixx.constants.ConfigurationConstants;
import com.orange.matrixx.objects.OEGEvent;
import com.orange.matrixx.utils.ConstantUtilities;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		String group = "testgroup";
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
			System.out.println("###################### JOB STARTED ########################");
			KafkaSource<OEGEvent> source = KafkaSource.<OEGEvent>builder()
					.setBootstrapServers(ConfigurationConstants.bootStrapServer)
					.setTopics(ConfigurationConstants.consumerTopicName).setGroupId("grp-1")
					.setStartingOffsets(OffsetsInitializer.earliest()).setValueOnlyDeserializer(new OEGEvent()).build();
			System.out.println("###################### ADD SOURCE ########################");
			env.fromSource(source, WatermarkStrategy.noWatermarks(), "dataconsumer").keyBy(value -> value.aggregationId)
					.reduce(new DataAggregation())
					.addSink(new FlinkKafkaProducer<>(ConfigurationConstants.producerTopicName, new OEGEvent(),
							properties))
					.name("ERDModeling");
			env.execute("dataconsumer");
			System.out.println("###################### EXECUTION ########################");
		} catch (Exception ex) {
			System.out.println("###################### THIS IS ERROR ########################");
			ex.printStackTrace();
		}
	}
}
