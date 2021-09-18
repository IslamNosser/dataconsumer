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
	String initiatorId;
	String initiatorExternalId;
	String initiatorDeviceId;
	String initiatorDeviceExternalId;
	String walletId;
	String walletOwnerId;
	String walletOwnerExternalId;
	int walletOwnerType;
	int flags;
	Date eventTime;
	int duration;
	String associatedEventId;
	String initiatorPrimaryUserId;
	String initiatorPrimaryUserExternalId;
	int initiatorType;
	String aggregationId;
	String sessionIdCust;
	String callUsageType;
	String eventClass;
	int serviceId;
	String APartyMsisdn;
	String BPartyMsisdn;
	String MSISDN;
	String VLRInfo;
	String lac;
	String cid;
	String apn;
	String applicationName;
	String applicationCategory;
	String sgsnIpAddress;
	String imsi;
	String chargedPartyCountry;
	String otherPartyCountry;
	String roamingCarrier;
	int roamingFlag;
	String subscriberType;
	int usageUtcOffset;
	String info;
	String reason;
	String meterUpdateArray;
	String offerInfoArray;
	String bundleInfoArray;
	String usageQuantityList;
	String balanceUpdateChargeList;
	String appliedOfferBundleCatalogItemArray;
	int usageVolume;
	int roundedUsageVolume;
	int chargedAmount;

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public String getInitiatorId() {
		return initiatorId;
	}

	public void setInitiatorId(String initiatorId) {
		this.initiatorId = initiatorId;
	}

	public String getInitiatorExternalId() {
		return initiatorExternalId;
	}

	public void setInitiatorExternalId(String initiatorExternalId) {
		this.initiatorExternalId = initiatorExternalId;
	}

	public String getInitiatorDeviceId() {
		return initiatorDeviceId;
	}

	public void setInitiatorDeviceId(String initiatorDeviceId) {
		this.initiatorDeviceId = initiatorDeviceId;
	}

	public String getInitiatorDeviceExternalId() {
		return initiatorDeviceExternalId;
	}

	public void setInitiatorDeviceExternalId(String initiatorDeviceExternalId) {
		this.initiatorDeviceExternalId = initiatorDeviceExternalId;
	}

	public String getWalletId() {
		return walletId;
	}

	public void setWalletId(String walletId) {
		this.walletId = walletId;
	}

	public String getWalletOwnerId() {
		return walletOwnerId;
	}

	public void setWalletOwnerId(String walletOwnerId) {
		this.walletOwnerId = walletOwnerId;
	}

	public String getWalletOwnerExternalId() {
		return walletOwnerExternalId;
	}

	public void setWalletOwnerExternalId(String walletOwnerExternalId) {
		this.walletOwnerExternalId = walletOwnerExternalId;
	}

	public int getWalletOwnerType() {
		return walletOwnerType;
	}

	public void setWalletOwnerType(int walletOwnerType) {
		this.walletOwnerType = walletOwnerType;
	}

	public int getFlags() {
		return flags;
	}

	public void setFlags(int flags) {
		this.flags = flags;
	}

	public Date getEventTime() {
		return eventTime;
	}

	public void setEventTime(Date eventTime) {
		this.eventTime = eventTime;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getAssociatedEventId() {
		return associatedEventId;
	}

	public void setAssociatedEventId(String associatedEventId) {
		this.associatedEventId = associatedEventId;
	}

	public String getInitiatorPrimaryUserId() {
		return initiatorPrimaryUserId;
	}

	public void setInitiatorPrimaryUserId(String initiatorPrimaryUserId) {
		this.initiatorPrimaryUserId = initiatorPrimaryUserId;
	}

	public String getInitiatorPrimaryUserExternalId() {
		return initiatorPrimaryUserExternalId;
	}

	public void setInitiatorPrimaryUserExternalId(String initiatorPrimaryUserExternalId) {
		this.initiatorPrimaryUserExternalId = initiatorPrimaryUserExternalId;
	}

	public int getInitiatorType() {
		return initiatorType;
	}

	public void setInitiatorType(int initiatorType) {
		this.initiatorType = initiatorType;
	}

	public String getAggregationId() {
		return aggregationId;
	}

	public void setAggregationId(String aggregationId) {
		this.aggregationId = aggregationId;
	}

	public String getSessionIdCust() {
		return sessionIdCust;
	}

	public void setSessionIdCust(String sessionIdCust) {
		this.sessionIdCust = sessionIdCust;
	}

	public String getCallUsageType() {
		return callUsageType;
	}

	public void setCallUsageType(String callUsageType) {
		this.callUsageType = callUsageType;
	}

	public String getEventClass() {
		return eventClass;
	}

	public void setEventClass(String eventClass) {
		this.eventClass = eventClass;
	}

	public int getServiceId() {
		return serviceId;
	}

	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}

	public String getAPartyMsisdn() {
		return APartyMsisdn;
	}

	public void setAPartyMsisdn(String aPartyMsisdn) {
		APartyMsisdn = aPartyMsisdn;
	}

	public String getBPartyMsisdn() {
		return BPartyMsisdn;
	}

	public void setBPartyMsisdn(String bPartyMsisdn) {
		BPartyMsisdn = bPartyMsisdn;
	}

	public String getMSISDN() {
		return MSISDN;
	}

	public void setMSISDN(String mSISDN) {
		MSISDN = mSISDN;
	}

	public String getVLRInfo() {
		return VLRInfo;
	}

	public void setVLRInfo(String vLRInfo) {
		VLRInfo = vLRInfo;
	}

	public String getLac() {
		return lac;
	}

	public void setLac(String lac) {
		this.lac = lac;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
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

	public String getSgsnIpAddress() {
		return sgsnIpAddress;
	}

	public void setSgsnIpAddress(String sgsnIpAddress) {
		this.sgsnIpAddress = sgsnIpAddress;
	}

	public String getImsi() {
		return imsi;
	}

	public void setImsi(String imsi) {
		this.imsi = imsi;
	}

	public String getChargedPartyCountry() {
		return chargedPartyCountry;
	}

	public void setChargedPartyCountry(String chargedPartyCountry) {
		this.chargedPartyCountry = chargedPartyCountry;
	}

	public String getOtherPartyCountry() {
		return otherPartyCountry;
	}

	public void setOtherPartyCountry(String otherPartyCountry) {
		this.otherPartyCountry = otherPartyCountry;
	}

	public String getRoamingCarrier() {
		return roamingCarrier;
	}

	public void setRoamingCarrier(String roamingCarrier) {
		this.roamingCarrier = roamingCarrier;
	}

	public int getRoamingFlag() {
		return roamingFlag;
	}

	public void setRoamingFlag(int roamingFlag) {
		this.roamingFlag = roamingFlag;
	}

	public String getSubscriberType() {
		return subscriberType;
	}

	public void setSubscriberType(String subscriberType) {
		this.subscriberType = subscriberType;
	}

	public int getUsageUtcOffset() {
		return usageUtcOffset;
	}

	public void setUsageUtcOffset(int usageUtcOffset) {
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

	public String getMeterUpdateArray() {
		return meterUpdateArray;
	}

	public void setMeterUpdateArray(String meterUpdateArray) {
		this.meterUpdateArray = meterUpdateArray;
	}

	public String getOfferInfoArray() {
		return offerInfoArray;
	}

	public void setOfferInfoArray(String offerInfoArray) {
		this.offerInfoArray = offerInfoArray;
	}

	public String getBundleInfoArray() {
		return bundleInfoArray;
	}

	public void setBundleInfoArray(String bundleInfoArray) {
		this.bundleInfoArray = bundleInfoArray;
	}

	public String getUsageQuantityList() {
		return usageQuantityList;
	}

	public void setUsageQuantityList(String usageQuantityList) {
		this.usageQuantityList = usageQuantityList;
	}

	public String getBalanceUpdateChargeList() {
		return balanceUpdateChargeList;
	}

	public void setBalanceUpdateChargeList(String balanceUpdateChargeList) {
		this.balanceUpdateChargeList = balanceUpdateChargeList;
	}

	public String getAppliedOfferBundleCatalogItemArray() {
		return appliedOfferBundleCatalogItemArray;
	}

	public void setAppliedOfferBundleCatalogItemArray(String appliedOfferBundleCatalogItemArray) {
		this.appliedOfferBundleCatalogItemArray = appliedOfferBundleCatalogItemArray;
	}

	public int getUsageVolume() {
		return usageVolume;
	}

	public void setUsageVolume(int usageVolume) {
		this.usageVolume = usageVolume;
	}

	public int getRoundedUsageVolume() {
		return roundedUsageVolume;
	}

	public void setRoundedUsageVolume(int roundedUsageVolume) {
		this.roundedUsageVolume = roundedUsageVolume;
	}

	public int getChargedAmount() {
		return chargedAmount;
	}

	public void setChargedAmount(int chargedAmount) {
		this.chargedAmount = chargedAmount;
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
