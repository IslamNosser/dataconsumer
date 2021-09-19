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
		properties.put("errors.tolerance", "all");

		try {
			KafkaSource<OEGEvent> source = KafkaSource.<OEGEvent>builder()
					.setBootstrapServers(ConfigurationConstants.bootStrapServer).setTopics(consumer_topic_name)
					.setGroupId(group).setStartingOffsets(OffsetsInitializer.earliest())
					.setValueOnlyDeserializer(new OEGEvent()).build();
			env.fromSource(source, WatermarkStrategy.noWatermarks(), "dataconsumer").map(new EDRModeling())
					.addSink(JdbcSink.sink(
//							"INSERT INTO MTX_USAGE_T (EVENTID,ASSOCIATEDEVENTID,EVENTTIME,EVENTTYPE,APARTY,BPARTY,APN,CELLID,LAC,"
//									+ "CALLTYPE,CALLUSAGETYPE,IMSI,SIM,MSCADDRESS,NETWORKCALLID,ONNET,SESSIONID,WALLETID,WALLETOWNER,"
//									+ "USAGEUTCOFFSET,SUBSCRIBERTYPE,ROAMINGFLAG,CHARGEDPARTYMCCMNC,ORIGINATIONCARRIER,ROAMINGCARRIER,"
//									+ "RATINGGROUP,APPLICATIONNAME,APPLICATIONCATEGORY,SERVICEID,SGSNIP,AGGREGATIONID,USAGEQUANTITYAMOUNT,"
//									+ "USAGEQUANTITYRATINGAMOUNT,USAGEQUANTITYQUANTITYUNIT,METERUPDATE,APPLIEDOFFERBALANCEUPDATECHARGEGLINFO,"
//									+ "OFFERINFO,BUNDLEINFO,CYCLECATALOG,USAGEVOLUME,ROUNDEDUSAGEVOLUME,CHARGEDAMOUNT,DELETECODE) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
							"INSERT INTO MTX_USAGE_T (EVENTID,EVENTTIME,EVENTTYPE,APARTY,BPARTY,CALLTYPE,CALLUSAGETYPE,ONNET,SESSIONID,USAGEVOLUME,ROUNDEDUSAGEVOLUME,CHARGEDAMOUNT) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)",
							(statement, edrModel) -> {
								statement.setString(1, edrModel.getEventId());
								statement.setDate(2, new Date(edrModel.getEventTime().getTime()));
								if (edrModel.getEventType() != null)
									statement.setInt(3, edrModel.getEventType().intValue());
								else
									statement.setNull(3, java.sql.Types.NULL);
								if (edrModel.getAParty() != null)
									statement.setString(4, edrModel.getAParty());
								else
									statement.setNull(4, java.sql.Types.NULL);
								if (edrModel.getBParty() != null)
									statement.setString(5, edrModel.getBParty());
								else
									statement.setNull(5, java.sql.Types.NULL);
								if (edrModel.getCallType() != null)
									statement.setString(6, edrModel.getCallType());
								else
									statement.setNull(6, java.sql.Types.NULL);
								if (edrModel.getCallUsageType() != null)
									statement.setString(7, edrModel.getCallUsageType());
								else
									statement.setNull(7, java.sql.Types.NULL);
								if (edrModel.getOnNet() != null)
									statement.setInt(8, edrModel.getOnNet().intValue());
								else
									statement.setNull(8, java.sql.Types.NULL);
								if (edrModel.getSessionId() != null)
									statement.setString(9, edrModel.getSessionId());
								else
									statement.setNull(9, java.sql.Types.NULL);
								if (edrModel.getUsageVolume() != null)
									statement.setDouble(10, edrModel.getUsageVolume().doubleValue());
								else
									statement.setNull(10, java.sql.Types.NULL);
								if (edrModel.getRoundedUsageVolume() != null)
									statement.setDouble(11, edrModel.getRoundedUsageVolume().doubleValue());
								else
									statement.setNull(11, java.sql.Types.NULL);
								if (edrModel.getChargedAmount() != null)
									statement.setDouble(12, edrModel.getChargedAmount().doubleValue());
								else
									statement.setNull(12, java.sql.Types.NULL);
								
//								statement.setString(1, edrModel.getEventId());
//								if (edrModel.getAssociatedEventId() != null)
//									statement.setString(2, edrModel.getAssociatedEventId());
//								else
//									statement.setNull(2, java.sql.Types.NULL);
//								statement.setDate(3, new Date(edrModel.getEventTime().getTime()));
//								if (edrModel.getEventType() != null)
//									statement.setInt(4, edrModel.getEventType().intValue());
//								else
//									statement.setNull(4, java.sql.Types.NULL);
//								if (edrModel.getAParty() != null)
//									statement.setString(5, edrModel.getAParty());
//								else
//									statement.setNull(5, java.sql.Types.NULL);
//								if (edrModel.getBParty() != null)
//									statement.setString(6, edrModel.getBParty());
//								else
//									statement.setNull(6, java.sql.Types.NULL);
//								if (edrModel.getApn() != null)
//									statement.setString(7, edrModel.getApn());
//								else
//									statement.setNull(7, java.sql.Types.NULL);
//								if (edrModel.getCellId() != null)
//									statement.setString(8, edrModel.getCellId());
//								else
//									statement.setNull(8, java.sql.Types.NULL);
//								if (edrModel.getLac() != null)
//									statement.setString(9, edrModel.getLac());
//								else
//									statement.setNull(9, java.sql.Types.NULL);
//								if (edrModel.getCallType() != null)
//									statement.setString(10, edrModel.getCallType());
//								else
//									statement.setNull(10, java.sql.Types.NULL);
//								if (edrModel.getCallUsageType() != null)
//									statement.setString(11, edrModel.getCallUsageType());
//								else
//									statement.setNull(11, java.sql.Types.NULL);
//								if (edrModel.getImsi() != null)
//									statement.setString(12, edrModel.getImsi());
//								else
//									statement.setNull(12, java.sql.Types.NULL);
//								if (edrModel.getSim() != null)
//									statement.setString(13, edrModel.getSim());
//								else
//									statement.setNull(13, java.sql.Types.NULL);
//								if (edrModel.getMscAddress() != null)
//									statement.setString(14, edrModel.getMscAddress());
//								else
//									statement.setNull(14, java.sql.Types.NULL);
//								if (edrModel.getNetworkCallId() != null)
//									statement.setString(15, edrModel.getNetworkCallId());
//								else
//									statement.setNull(15, java.sql.Types.NULL);
//								if (edrModel.getOnNet() != null)
//									statement.setInt(16, edrModel.getOnNet().intValue());
//								else
//									statement.setNull(16, java.sql.Types.NULL);
//								if (edrModel.getSessionId() != null)
//									statement.setString(17, edrModel.getSessionId());
//								else
//									statement.setNull(17, java.sql.Types.NULL);
//								if (edrModel.getWalletId() != null)
//									statement.setString(18, edrModel.getWalletId());
//								else
//									statement.setNull(18, java.sql.Types.NULL);
//								if (edrModel.getWalletOwner() != null)
//									statement.setString(19, edrModel.getWalletOwner());
//								else
//									statement.setNull(19, java.sql.Types.NULL);
//								if (edrModel.getUsageUtcOffset() != null)
//									statement.setInt(20, edrModel.getUsageUtcOffset().intValue());
//								else
//									statement.setNull(20, java.sql.Types.NULL);
//								if (edrModel.getSubscriberType() != null)
//									statement.setString(21, edrModel.getSubscriberType());
//								else
//									statement.setNull(21, java.sql.Types.NULL);
//								if (edrModel.getRoamingFlag() != null)
//									statement.setInt(22, edrModel.getRoamingFlag().intValue());
//								else
//									statement.setNull(22, java.sql.Types.NULL);
//								if (edrModel.getChargedPartyMccMnc() != null)
//									statement.setString(23, edrModel.getChargedPartyMccMnc());
//								else
//									statement.setNull(23, java.sql.Types.NULL);
//								if (edrModel.getOriginationCarrier() != null)
//									statement.setString(24, edrModel.getOriginationCarrier());
//								else
//									statement.setNull(24, java.sql.Types.NULL);
//								if (edrModel.getRoamingCarrier() != null)
//									statement.setString(25, edrModel.getRoamingCarrier());
//								else
//									statement.setNull(25, java.sql.Types.NULL);
//								if (edrModel.getRatingGroup() != null)
//									statement.setInt(26, edrModel.getRatingGroup().intValue());
//								else
//									statement.setNull(26, java.sql.Types.NULL);
//								if (edrModel.getApplicationName() != null)
//									statement.setString(27, edrModel.getApplicationName());
//								else
//									statement.setNull(27, java.sql.Types.NULL);
//								if (edrModel.getApplicationCategory() != null)
//									statement.setString(28, edrModel.getApplicationCategory());
//								else
//									statement.setNull(28, java.sql.Types.NULL);
//								if (edrModel.getServiceId() != null)
//									statement.setInt(29, edrModel.getServiceId().intValue());
//								else
//									statement.setNull(29, java.sql.Types.NULL);
//								if (edrModel.getSgsnIp() != null)
//									statement.setString(30, edrModel.getSgsnIp());
//								else
//									statement.setNull(30, java.sql.Types.NULL);
//								if (edrModel.getAggregationId() != null)
//									statement.setString(31, edrModel.getAggregationId());
//								else
//									statement.setNull(31, java.sql.Types.NULL);
//								if (edrModel.getUsageQuantityAmount() != null)
//									statement.setDouble(32, edrModel.getUsageQuantityAmount().doubleValue());
//								else
//									statement.setNull(32, java.sql.Types.NULL);
//								if (edrModel.getUsageQuantityRatingAmount() != null)
//									statement.setDouble(33, edrModel.getUsageQuantityRatingAmount().doubleValue());
//								else
//									statement.setNull(33, java.sql.Types.NULL);
//								if (edrModel.getUsageQuantityUnit() != null)
//									statement.setString(34, edrModel.getUsageQuantityUnit());
//								else
//									statement.setNull(34, java.sql.Types.NULL);
//								if (edrModel.getMeterUpdate() != null)
//									statement.setString(35, edrModel.getMeterUpdate());
//								else
//									statement.setNull(35, java.sql.Types.NULL);
//								if (edrModel.getAppliedOfferBalanceUpdateChargeGlInfo() != null)
//									statement.setString(36, edrModel.getAppliedOfferBalanceUpdateChargeGlInfo());
//								else
//									statement.setNull(36, java.sql.Types.NULL);
//								if (edrModel.getOfferInfo() != null)
//									statement.setString(37, edrModel.getOfferInfo());
//								else
//									statement.setNull(37, java.sql.Types.NULL);
//								if (edrModel.getBundleInfo() != null)
//									statement.setString(38, edrModel.getBundleInfo());
//								else
//									statement.setNull(38, java.sql.Types.NULL);
//								if (edrModel.getCycleCatalog() != null)
//									statement.setString(39, edrModel.getCycleCatalog());
//								else
//									statement.setNull(39, java.sql.Types.NULL);
//								if (edrModel.getUsageVolume() != null)
//									statement.setDouble(40, edrModel.getUsageVolume().doubleValue());
//								else
//									statement.setNull(40, java.sql.Types.NULL);
//								if (edrModel.getRoundedUsageVolume() != null)
//									statement.setDouble(41, edrModel.getRoundedUsageVolume().doubleValue());
//								else
//									statement.setNull(41, java.sql.Types.NULL);
//								if (edrModel.getChargedAmount() != null)
//									statement.setDouble(42, edrModel.getChargedAmount().doubleValue());
//								else
//									statement.setNull(42, java.sql.Types.NULL);
//								if (edrModel.getDeleteCode() != null)
//									statement.setInt(43, edrModel.getDeleteCode().intValue());
//								else
//									statement.setNull(43, java.sql.Types.NULL);
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
