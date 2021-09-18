package com.orange.matrixx.dataconsumer;

import java.sql.Date;
import java.util.Properties;

import org.apache.flink.api.common.eventtime.WatermarkStrategy;
import org.apache.flink.connector.jdbc.JdbcConnectionOptions;
import org.apache.flink.connector.jdbc.JdbcExecutionOptions;
import org.apache.flink.connector.jdbc.JdbcSink;
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
//		String consumer_topic_name = args[0];
//		String producer_topic_name = args[1];
//		String group = args[2];
		String consumer_topic_name = "MtxMike";
		String group = "event_group";
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
					.addSink(JdbcSink.sink(
							"INSERT INTO MTX_USAGE_T (EVENTID,ASSOCIATEDEVENTID,EVENTTIME,EVENTTYPE,APARTY,BPARTY,APN,CELLID,LAC,"
							+ "CALLTYPE,CALLUSAGETYPE,IMSI,SIM,MSCADDRESS,NETWORKCALLID,ONNET,SESSIONID,WALLETID,WALLETOWNER,"
							+ "USAGEUTCOFFSET,SUBSCRIBERTYPE,ROAMINGFLAG,CHARGEDPARTYMCCMNC,ORIGINATIONCARRIER,ROAMINGCARRIER,"
							+ "RATINGGROUP,APPLICATIONNAME,APPLICATIONCATEGORY,SERVICEID,SGSNIP,AGGREGATIONID,USAGEQUANTITYAMOUNT,"
							+ "USAGEQUANTITYRATINGAMOUNT,USAGEQUANTITYQUANTITYUNIT,METERUPDATE,APPLIEDOFFERBALANCEUPDATECHARGEGLINFO,"
							+ "OFFERINFO,BUNDLEINFO,CYCLECATALOG,USAGEVOLUME,ROUNDEDUSAGEVOLUME,CHARGEDAMOUNT,DELETECODE) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
							(statement, edrModel) -> {
								statement.setString(1, edrModel.getEventId());
								statement.setString(2, edrModel.getAssociatedEventId());
								statement.setDate(3, new Date(edrModel.getEventTime().getTime()));
								statement.setInt(4, edrModel.getEventType());
								statement.setString(5, edrModel.getAParty());
								statement.setString(6, edrModel.getBParty());
								statement.setString(7, edrModel.getApn());
								statement.setString(8, edrModel.getCellId());
								statement.setString(9, edrModel.getLac());
								statement.setString(10, edrModel.getCallType());
								statement.setString(11, edrModel.getCallUsageType());
								statement.setString(12, edrModel.getImsi());
								statement.setString(13, edrModel.getSim());
								statement.setString(14, edrModel.getMscAddress());
								statement.setString(15, edrModel.getNetworkCallId());
								statement.setInt(16, edrModel.getOnNet());
								statement.setString(17, edrModel.getSessionId());
								statement.setString(18, edrModel.getWalletId());
								statement.setString(19, edrModel.getWalletOwner());
								statement.setInt(20, edrModel.getUsageUtcOffset());
								statement.setString(21, edrModel.getSubscriberType());
								statement.setInt(22, edrModel.getRoamingFlag());
								statement.setString(23, edrModel.getChargedPartyMccMnc());
								statement.setString(24, edrModel.getOriginationCarrier());
								statement.setString(25, edrModel.getRoamingCarrier());
								statement.setInt(26, edrModel.getRatingGroup());
								statement.setString(27, edrModel.getApplicationName());
								statement.setString(28, edrModel.getApplicationCategory());
								statement.setInt(29, edrModel.getServiceId());
								statement.setString(30, edrModel.getSgsnIp());
								statement.setString(31, edrModel.getAggregationId());
								statement.setDouble(32, edrModel.getUsageQuantityAmount());
								statement.setDouble(33, edrModel.getUsageQuantityRatingAmount());
								statement.setString(34, edrModel.getUsageQuantityUnit());
								statement.setString(35, edrModel.getMeterUpdate());
								statement.setString(36, edrModel.getAppliedOfferBalanceUpdateChargeGlInfo());
								statement.setString(37, edrModel.getOfferInfo());
								statement.setString(38, edrModel.getBundleInfo());
								statement.setString(39, edrModel.getCycleCatalog());
								statement.setDouble(40, edrModel.getUsageVolume());
								statement.setDouble(41, edrModel.getRoundedUsageVolume());
								statement.setDouble(42, edrModel.getChargedAmount());
								statement.setInt(43, edrModel.getDeleteCode());
							},
							JdbcExecutionOptions.builder().withBatchSize(1000).withBatchIntervalMs(200)
									.withMaxRetries(5).build(),
							new JdbcConnectionOptions.JdbcConnectionOptionsBuilder()
									.withUrl("jdbc:oracle:thin:@10.115.55.114:1521/tnadb")
									.withDriverName("oracle.jdbc.driver.OracleDriver").withUsername("hyper")
									.withPassword("hyper1").build()));
			env.execute("dataconsumer");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
