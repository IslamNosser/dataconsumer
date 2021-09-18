package com.orange.matrixx.modelingobjects;

import java.io.IOException;
import java.util.Date;

import org.apache.flink.api.common.typeinfo.TypeHint;
import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.streaming.util.serialization.DeserializationSchema;
import org.apache.flink.streaming.util.serialization.SerializationSchema;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.orange.matrixx.objects.OEGEvent;

public class EDRModel implements DeserializationSchema<EDRModel>, SerializationSchema<EDRModel> {
	ObjectMapper mapper;
	String eventId;
	String associatedEventId;
	Date eventTime;
	Integer eventType;
	String AParty;
	String BParty;
	String apn;
	String cellId;
	String lac;
	String callType;
	String callUsageType;
	String imsi;
	String sim;
	String mscAddress;
	String networkCallId;
	Integer onNet;
	String sessionId;
	String walletOwner;
	Integer roamingFlag;
	String chargedPartyMccMnc;
	String originationCarrier;
	Integer ratingGroup;
	
	String walletId;
	
	String aggregationId;
	Integer serviceId;
	
	String applicationName;
	String applicationCategory;
	String sgsnIp;
	
	String roamingCarrier;
	String subscriberType;
	Integer usageUtcOffset;
	
	Double usageQuantityAmount;
	Double usageQuantityRatingAmount;
	String usageQuantityUnit;
	
	String info;
	String reason;
	
	String meterUpdate;
	String offerInfo;
	String bundleInfo;
	String cycleCatalog;

	String appliedOfferBalanceUpdateChargeGlInfo;
	
	Double usageVolume;
	Double roundedUsageVolume;
	Double chargedAmount;
	
	Integer deleteCode;
	
	public String getCycleCatalog() {
		return cycleCatalog;
	}

	public void setCycleCatalog(String cycleCatalog) {
		this.cycleCatalog = cycleCatalog;
	}
	
	public Integer getDeleteCode() {
		return deleteCode;
	}

	public void setDeleteCode(Integer deleteCode) {
		this.deleteCode = deleteCode;
	}

	public Double getUsageQuantityAmount() {
		return usageQuantityAmount;
	}

	public void setUsageQuantityAmount(Double usageQuantityAmount) {
		this.usageQuantityAmount = usageQuantityAmount;
	}

	public Double getUsageQuantityRatingAmount() {
		return usageQuantityRatingAmount;
	}

	public void setUsageQuantityRatingAmount(Double usageQuantityRatingAmount) {
		this.usageQuantityRatingAmount = usageQuantityRatingAmount;
	}

	public String getUsageQuantityUnit() {
		return usageQuantityUnit;
	}

	public void setUsageQuantityUnit(String usageQuantityUnit) {
		this.usageQuantityUnit = usageQuantityUnit;
	}

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}
	public Integer getEventType() {
		return eventType;
	}

	public void setEventType(Integer eventType) {
		this.eventType = eventType;
	}


	public String getWalletId() {
		return walletId;
	}

	public void setWalletId(String walletId) {
		this.walletId = walletId;
	}

	public Date getEventTime() {
		return eventTime;
	}

	public void setEventTime(Date eventTime) {
		this.eventTime = eventTime;
	}

	public String getAssociatedEventId() {
		return associatedEventId;
	}

	public void setAssociatedEventId(String associatedEventId) {
		this.associatedEventId = associatedEventId;
	}

	public String getAggregationId() {
		return aggregationId;
	}

	public void setAggregationId(String aggregationId) {
		this.aggregationId = aggregationId;
	}

	public String getCallType() {
		return callType;
	}

	public void setCallType(String callType) {
		this.callType = callType;
	}

	public String getCallUsageType() {
		return callUsageType;
	}

	public void setCallUsageType(String callUsageType) {
		this.callUsageType = callUsageType;
	}

	public Integer getServiceId() {
		return serviceId;
	}

	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}

	public String getAParty() {
		return AParty;
	}

	public void setAParty(String AParty) {
		this.AParty = AParty;
	}

	public String getBParty() {
		return BParty;
	}

	public void setBParty(String BParty) {
		this.BParty = BParty;
	}

	public String getLac() {
		return lac;
	}

	public void setLac(String lac) {
		this.lac = lac;
	}

	public String getCellId() {
		return cellId;
	}

	public void setCellId(String cellId) {
		this.cellId = cellId;
	}

	public String getApn() {
		return apn;
	}

	public void setApn(String apn) {
		this.apn = apn;
	}

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	public String getApplicationCategory() {
		return applicationCategory;
	}

	public void setApplicationCategory(String applicationCategory) {
		this.applicationCategory = applicationCategory;
	}

	public String getSgsnIp() {
		return sgsnIp;
	}

	public void setSgsnIp(String sgsnIp) {
		this.sgsnIp = sgsnIp;
	}

	public String getImsi() {
		return imsi;
	}

	public void setImsi(String imsi) {
		this.imsi = imsi;
	}

	public String getSim() {
		return sim;
	}

	public void setSim(String sim) {
		this.sim = sim;
	}

	public String getRoamingCarrier() {
		return roamingCarrier;
	}

	public void setRoamingCarrier(String roamingCarrier) {
		this.roamingCarrier = roamingCarrier;
	}

	public Integer getRoamingFlag() {
		return roamingFlag;
	}

	public void setRoamingFlag(Integer roamingFlag) {
		this.roamingFlag = roamingFlag;
	}

	public String getSubscriberType() {
		return subscriberType;
	}

	public void setSubscriberType(String subscriberType) {
		this.subscriberType = subscriberType;
	}

	public Integer getUsageUtcOffset() {
		return usageUtcOffset;
	}

	public void setUsageUtcOffset(Integer usageUtcOffset) {
		this.usageUtcOffset = usageUtcOffset;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getMeterUpdate() {
		return meterUpdate;
	}

	public void setMeterUpdate(String meterUpdate) {
		this.meterUpdate = meterUpdate;
	}

	public String getOfferInfo() {
		return offerInfo;
	}

	public void setOfferInfo(String offerInfo) {
		this.offerInfo = offerInfo;
	}

	public String getBundleInfo() {
		return bundleInfo;
	}

	public void setBundleInfo(String bundleInfo) {
		this.bundleInfo = bundleInfo;
	}
	
	public String getAppliedOfferBalanceUpdateChargeGlInfo() {
		return appliedOfferBalanceUpdateChargeGlInfo;
	}

	public void setAppliedOfferBalanceUpdateChargeGlInfo(String appliedOfferBalanceUpdateChargeGlInfo) {
		this.appliedOfferBalanceUpdateChargeGlInfo = appliedOfferBalanceUpdateChargeGlInfo;
	}

	public Double getUsageVolume() {
		return usageVolume;
	}

	public void setUsageVolume(Double usageVolume) {
		this.usageVolume = usageVolume;
	}

	public Double getRoundedUsageVolume() {
		return roundedUsageVolume;
	}

	public void setRoundedUsageVolume(Double roundedUsageVolume) {
		this.roundedUsageVolume = roundedUsageVolume;
	}

	public Double getChargedAmount() {
		return chargedAmount;
	}

	public void setChargedAmount(Double chargedAmount) {
		this.chargedAmount = chargedAmount;
	}

	public String getMscAddress() {
		return mscAddress;
	}

	public void setMscAddress(String mscAddress) {
		this.mscAddress = mscAddress;
	}

	public String getNetworkCallId() {
		return networkCallId;
	}

	public void setNetworkCallId(String networkCallId) {
		this.networkCallId = networkCallId;
	}

	public Integer getOnNet() {
		return onNet;
	}

	public void setOnNet(Integer onNet) {
		this.onNet = onNet;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getWalletOwner() {
		return walletOwner;
	}

	public void setWalletOwner(String walletOwner) {
		this.walletOwner = walletOwner;
	}

	public String getChargedPartyMccMnc() {
		return chargedPartyMccMnc;
	}

	public void setChargedPartyMccMnc(String chargedPartyMccMnc) {
		this.chargedPartyMccMnc = chargedPartyMccMnc;
	}

	public String getOriginationCarrier() {
		return originationCarrier;
	}

	public void setOriginationCarrier(String originationCarrier) {
		this.originationCarrier = originationCarrier;
	}

	public Integer getRatingGroup() {
		return ratingGroup;
	}

	public void setRatingGroup(Integer ratingGroup) {
		this.ratingGroup = ratingGroup;
	}

	@Override
	public TypeInformation getProducedType() {
		return TypeInformation.of(new TypeHint<EDRModel>() {
		});
	}

	@Override
	public EDRModel deserialize(byte[] message) throws IOException {
		mapper = new ObjectMapper();
//		mapper.setDefaultPropertyInclusion(JsonInclude.Value.construct(Include.ALWAYS, Include.ALWAYS));
		EDRModel temp = new EDRModel();
		try {
			mapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
			mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
			temp = mapper.readValue(message, EDRModel.class);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return temp;
	}

	@Override
	public boolean isEndOfStream(EDRModel nextElement) {
		return false;
	}

	@Override
	public byte[] serialize(EDRModel element) {
		String json = "";
//		mapper.setDefaultPropertyInclusion(Include.NON_NULL);
		try {
			json = mapper.writeValueAsString(element);
		} catch (Exception ex) {

		}
		return json.getBytes();
	}
}
