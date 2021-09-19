package com.orange.matrixx.objects;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.flink.api.common.typeinfo.TypeHint;
import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.streaming.util.serialization.DeserializationSchema;
import org.apache.flink.streaming.util.serialization.SerializationSchema;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OEGEvent implements DeserializationSchema<OEGEvent>, SerializationSchema<OEGEvent> {
	ObjectMapper mapper;
	public String aPN;
	public String aPartyMsisdn;
	public String accountBrand;
	public String applicationCategory;
	public String applicationName;
	public List<AppliedBundleArray> appliedBundleArray;
	public List<AppliedCatalogItemArray> appliedCatalogItemArray;
	public List<AppliedOfferArray> appliedOfferArray;
	public String bPartyMsisdn;
	public List<BalanceUpdateArray> balanceUpdateArray;
	public String cID;
	public String callUsageType;
	public int ccRequestNumber;
	public int ccRequestType;
	public List<ChargeList> chargeList;
	public String chargedPartyCountry;
	public String chargedPartyMccMnc;
	public String chargingId;
	public int chargingIdInt;
	public int deleteCode;
	public long duration;
	public String eventId;
	public String associatedEventId;
	public Date eventTime;
	public List<Integer> eventTypeArray;
	public int flags;
	public String glDate;
	public long imsi;
	
	public String cycleCatalogItemExternalId;
	public int cycleCatalogItemId;
	public Date cycleEndTime;
	public int cycleIntervalId;
	public int cyclePurchasedItemResourceId;
	public Date cycleStartTime;
	public String cycleType;

	public String initiatorDeviceExternalId;
	public String initiatorDeviceId;
	public String initiatorExternalId;
	public String initiatorId;
	public String initiatorPrimaryUserExternalId;
	public String initiatorPrimaryUserId;
	public String initiatorType;
	public String lAC;
	public int lastUsageRoundingAmount;
	public String mSISDN;
	public List<MeterUpdateArray> meterUpdateArray;
	public String mtx_container_name;
	public int mtx_ext_ver;
	public int mtx_sys_ver;
	public String originationCCRegion;
	public String originationCarrier;
	public int ratingGroup;
	public String roamingCarrier;
	public String roamingFlag;
	public int serviceId;
	public String sessionId;
	public String sessionIdCust;
	public String sgsnIpAddress;
	public String streamCursor;
	public int subState;
	public String subscriberType;
	public String uliType;
	public List<UsageQuantityList> usageQuantityList;
	public int usageRoundingAmount;
	public int usageRoundingAmountUnit;
	public int usageUtcOffset;
	public String walletId;
	public String walletOwnerExternalId;
	public String walletOwnerId;
	public String walletOwnerType;
	public String event_type;
	public String aggregationId;
	public String bearerName;
	public String callType;
	public List<GlInfoArray> glInfoArray;
	public String iddCCRegion;
	public String mscAddress;
	public String networkCallReferenceId;
	public String onNet;
	public String otherPartyCountry;
	public String specialNumber;
	public String vLRInfo;
	public List<String> associatedEventIdList;
	public List<BundleInfoArray> bundleInfoArray;
	public List<OfferInfoArray> offerInfoArray;

	public String getCycleCatalogItemExternalId() {
		return cycleCatalogItemExternalId;
	}

	public void setCycleCatalogItemExternalId(String cycleCatalogItemExternalId) {
		this.cycleCatalogItemExternalId = cycleCatalogItemExternalId;
	}

	public int getCycleCatalogItemId() {
		return cycleCatalogItemId;
	}

	public void setCycleCatalogItemId(int cycleCatalogItemId) {
		this.cycleCatalogItemId = cycleCatalogItemId;
	}

	public Date getCycleEndTime() {
		return cycleEndTime;
	}

	public void setCycleEndTime(Date cycleEndTime) {
		this.cycleEndTime = cycleEndTime;
	}

	public int getCycleIntervalId() {
		return cycleIntervalId;
	}

	public void setCycleIntervalId(int cycleIntervalId) {
		this.cycleIntervalId = cycleIntervalId;
	}

	public int getCyclePurchasedItemResourceId() {
		return cyclePurchasedItemResourceId;
	}

	public void setCyclePurchasedItemResourceId(int cyclePurchasedItemResourceId) {
		this.cyclePurchasedItemResourceId = cyclePurchasedItemResourceId;
	}

	public Date getCycleStartTime() {
		return cycleStartTime;
	}

	public void setCycleStartTime(Date cycleStartTime) {
		this.cycleStartTime = cycleStartTime;
	}

	public String getCycleType() {
		return cycleType;
	}

	public void setCycleType(String cycleType) {
		this.cycleType = cycleType;
	}

	public String getAggregationId() {
		return aggregationId;
	}

	public void setAggregationId(String aggregationId) {
		this.aggregationId = aggregationId;
	}

	public String getBearerName() {
		return bearerName;
	}

	public void setBearerName(String bearerName) {
		this.bearerName = bearerName;
	}

	public String getCallType() {
		return callType;
	}

	public void setCallType(String callType) {
		this.callType = callType;
	}

	public List<GlInfoArray> getGlInfoArray() {
		return glInfoArray;
	}

	public void setGlInfoArray(List<GlInfoArray> glInfoArray) {
		this.glInfoArray = glInfoArray;
	}

	public String getIddCCRegion() {
		return iddCCRegion;
	}

	public void setIddCCRegion(String iddCCRegion) {
		this.iddCCRegion = iddCCRegion;
	}

	public String getMscAddress() {
		return mscAddress;
	}

	public void setMscAddress(String mscAddress) {
		this.mscAddress = mscAddress;
	}

	public String getNetworkCallReferenceId() {
		return networkCallReferenceId;
	}

	public void setNetworkCallReferenceId(String networkCallReferenceId) {
		this.networkCallReferenceId = networkCallReferenceId;
	}

	public String getOnNet() {
		return onNet;
	}

	public void setOnNet(String onNet) {
		this.onNet = onNet;
	}

	public String getOtherPartyCountry() {
		return otherPartyCountry;
	}

	public void setOtherPartyCountry(String otherPartyCountry) {
		this.otherPartyCountry = otherPartyCountry;
	}

	public String getSpecialNumber() {
		return specialNumber;
	}

	public void setSpecialNumber(String specialNumber) {
		this.specialNumber = specialNumber;
	}

	public String getvLRInfo() {
		return vLRInfo;
	}

	public void setvLRInfo(String vLRInfo) {
		this.vLRInfo = vLRInfo;
	}

	public String getaPN() {
		return aPN;
	}

	public void setaPN(String aPN) {
		this.aPN = aPN;
	}

	public String getaPartyMsisdn() {
		return aPartyMsisdn;
	}

	public void setaPartyMsisdn(String aPartyMsisdn) {
		this.aPartyMsisdn = aPartyMsisdn;
	}

	public String getAccountBrand() {
		return accountBrand;
	}

	public void setAccountBrand(String accountBrand) {
		this.accountBrand = accountBrand;
	}

	public String getApplicationCategory() {
		return applicationCategory;
	}

	public void setApplicationCategory(String applicationCategory) {
		this.applicationCategory = applicationCategory;
	}

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	public List<AppliedBundleArray> getAppliedBundleArray() {
		return appliedBundleArray;
	}

	public void setAppliedBundleArray(List<AppliedBundleArray> appliedBundleArray) {
		this.appliedBundleArray = appliedBundleArray;
	}

	public List<AppliedCatalogItemArray> getAppliedCatalogItemArray() {
		return appliedCatalogItemArray;
	}

	public void setAppliedCatalogItemArray(List<AppliedCatalogItemArray> appliedCatalogItemArray) {
		this.appliedCatalogItemArray = appliedCatalogItemArray;
	}

	public List<AppliedOfferArray> getAppliedOfferArray() {
		return appliedOfferArray;
	}

	public void setAppliedOfferArray(List<AppliedOfferArray> appliedOfferArray) {
		this.appliedOfferArray = appliedOfferArray;
	}

	public String getbPartyMsisdn() {
		return bPartyMsisdn;
	}

	public void setbPartyMsisdn(String bPartyMsisdn) {
		this.bPartyMsisdn = bPartyMsisdn;
	}

	public List<BalanceUpdateArray> getBalanceUpdateArray() {
		return balanceUpdateArray;
	}

	public void setBalanceUpdateArray(List<BalanceUpdateArray> balanceUpdateArray) {
		this.balanceUpdateArray = balanceUpdateArray;
	}

	public String getcID() {
		return cID;
	}

	public void setcID(String cID) {
		this.cID = cID;
	}

	public String getCallUsageType() {
		return callUsageType;
	}

	public void setCallUsageType(String callUsageType) {
		this.callUsageType = callUsageType;
	}

	public int getCcRequestNumber() {
		return ccRequestNumber;
	}

	public void setCcRequestNumber(int ccRequestNumber) {
		this.ccRequestNumber = ccRequestNumber;
	}

	public int getCcRequestType() {
		return ccRequestType;
	}

	public void setCcRequestType(int ccRequestType) {
		this.ccRequestType = ccRequestType;
	}

	public List<ChargeList> getChargeList() {
		return chargeList;
	}

	public void setChargeList(List<ChargeList> chargeList) {
		this.chargeList = chargeList;
	}

	public String getChargedPartyCountry() {
		return chargedPartyCountry;
	}

	public void setChargedPartyCountry(String chargedPartyCountry) {
		this.chargedPartyCountry = chargedPartyCountry;
	}

	public String getChargedPartyMccMnc() {
		return chargedPartyMccMnc;
	}

	public void setChargedPartyMccMnc(String chargedPartyMccMnc) {
		this.chargedPartyMccMnc = chargedPartyMccMnc;
	}

	public String getChargingId() {
		return chargingId;
	}

	public void setChargingId(String chargingId) {
		this.chargingId = chargingId;
	}

	public int getChargingIdInt() {
		return chargingIdInt;
	}

	public void setChargingIdInt(int chargingIdInt) {
		this.chargingIdInt = chargingIdInt;
	}

	public int getDeleteCode() {
		return deleteCode;
	}

	public void setDeleteCode(int deleteCode) {
		this.deleteCode = deleteCode;
	}

	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public Date getEventTime() {
		return eventTime;
	}

	public void setEventTime(Date eventTime) {
		this.eventTime = eventTime;
	}

	public List<Integer> getEventTypeArray() {
		return eventTypeArray;
	}

	public void setEventTypeArray(List<Integer> eventTypeArray) {
		this.eventTypeArray = eventTypeArray;
	}

	public int getFlags() {
		return flags;
	}

	public void setFlags(int flags) {
		this.flags = flags;
	}

	public String getGlDate() {
		return glDate;
	}

	public void setGlDate(String glDate) {
		this.glDate = glDate;
	}

	public Long getImsi() {
		return imsi;
	}

	public void setImsi(Long imsi) {
		this.imsi = imsi;
	}

	public String getInitiatorDeviceExternalId() {
		return initiatorDeviceExternalId;
	}

	public void setInitiatorDeviceExternalId(String initiatorDeviceExternalId) {
		this.initiatorDeviceExternalId = initiatorDeviceExternalId;
	}

	public String getInitiatorDeviceId() {
		return initiatorDeviceId;
	}

	public void setInitiatorDeviceId(String initiatorDeviceId) {
		this.initiatorDeviceId = initiatorDeviceId;
	}

	public String getInitiatorExternalId() {
		return initiatorExternalId;
	}

	public void setInitiatorExternalId(String initiatorExternalId) {
		this.initiatorExternalId = initiatorExternalId;
	}

	public String getInitiatorId() {
		return initiatorId;
	}

	public void setInitiatorId(String initiatorId) {
		this.initiatorId = initiatorId;
	}

	public String getInitiatorPrimaryUserExternalId() {
		return initiatorPrimaryUserExternalId;
	}

	public void setInitiatorPrimaryUserExternalId(String initiatorPrimaryUserExternalId) {
		this.initiatorPrimaryUserExternalId = initiatorPrimaryUserExternalId;
	}

	public String getInitiatorPrimaryUserId() {
		return initiatorPrimaryUserId;
	}

	public void setInitiatorPrimaryUserId(String initiatorPrimaryUserId) {
		this.initiatorPrimaryUserId = initiatorPrimaryUserId;
	}

	public String getInitiatorType() {
		return initiatorType;
	}

	public void setInitiatorType(String initiatorType) {
		this.initiatorType = initiatorType;
	}

	public String getlAC() {
		return lAC;
	}

	public void setlAC(String lAC) {
		this.lAC = lAC;
	}

	public int getLastUsageRoundingAmount() {
		return lastUsageRoundingAmount;
	}

	public void setLastUsageRoundingAmount(int lastUsageRoundingAmount) {
		this.lastUsageRoundingAmount = lastUsageRoundingAmount;
	}

	public String getmSISDN() {
		return mSISDN;
	}

	public void setmSISDN(String mSISDN) {
		this.mSISDN = mSISDN;
	}

	public List<MeterUpdateArray> getMeterUpdateArray() {
		return meterUpdateArray;
	}

	public void setMeterUpdateArray(List<MeterUpdateArray> meterUpdateArray) {
		this.meterUpdateArray = meterUpdateArray;
	}

	public String getMtx_container_name() {
		return mtx_container_name;
	}

	public void setMtx_container_name(String mtx_container_name) {
		this.mtx_container_name = mtx_container_name;
	}

	public int getMtx_ext_ver() {
		return mtx_ext_ver;
	}

	public void setMtx_ext_ver(int mtx_ext_ver) {
		this.mtx_ext_ver = mtx_ext_ver;
	}

	public int getMtx_sys_ver() {
		return mtx_sys_ver;
	}

	public void setMtx_sys_ver(int mtx_sys_ver) {
		this.mtx_sys_ver = mtx_sys_ver;
	}

	public String getOriginationCCRegion() {
		return originationCCRegion;
	}

	public void setOriginationCCRegion(String originationCCRegion) {
		this.originationCCRegion = originationCCRegion;
	}

	public String getOriginationCarrier() {
		return originationCarrier;
	}

	public void setOriginationCarrier(String originationCarrier) {
		this.originationCarrier = originationCarrier;
	}

	public int getRatingGroup() {
		return ratingGroup;
	}

	public void setRatingGroup(int ratingGroup) {
		this.ratingGroup = ratingGroup;
	}

	public String getRoamingCarrier() {
		return roamingCarrier;
	}

	public void setRoamingCarrier(String roamingCarrier) {
		this.roamingCarrier = roamingCarrier;
	}

	public String getRoamingFlag() {
		return roamingFlag;
	}

	public void setRoamingFlag(String roamingFlag) {
		this.roamingFlag = roamingFlag;
	}

	public int getServiceId() {
		return serviceId;
	}

	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getSessionIdCust() {
		return sessionIdCust;
	}

	public void setSessionIdCust(String sessionIdCust) {
		this.sessionIdCust = sessionIdCust;
	}

	public String getSgsnIpAddress() {
		return sgsnIpAddress;
	}

	public void setSgsnIpAddress(String sgsnIpAddress) {
		this.sgsnIpAddress = sgsnIpAddress;
	}

	public String getStreamCursor() {
		return streamCursor;
	}

	public void setStreamCursor(String streamCursor) {
		this.streamCursor = streamCursor;
	}

	public int getSubState() {
		return subState;
	}

	public void setSubState(int subState) {
		this.subState = subState;
	}

	public String getSubscriberType() {
		return subscriberType;
	}

	public void setSubscriberType(String subscriberType) {
		this.subscriberType = subscriberType;
	}

	public String getUliType() {
		return uliType;
	}

	public void setUliType(String uliType) {
		this.uliType = uliType;
	}

	public List<UsageQuantityList> getUsageQuantityList() {
		return usageQuantityList;
	}

	public void setUsageQuantityList(List<UsageQuantityList> usageQuantityList) {
		this.usageQuantityList = usageQuantityList;
	}

	public int getUsageRoundingAmount() {
		return usageRoundingAmount;
	}

	public void setUsageRoundingAmount(int usageRoundingAmount) {
		this.usageRoundingAmount = usageRoundingAmount;
	}

	public int getUsageRoundingAmountUnit() {
		return usageRoundingAmountUnit;
	}

	public void setUsageRoundingAmountUnit(int usageRoundingAmountUnit) {
		this.usageRoundingAmountUnit = usageRoundingAmountUnit;
	}

	public int getUsageUtcOffset() {
		return usageUtcOffset;
	}

	public void setUsageUtcOffset(int usageUtcOffset) {
		this.usageUtcOffset = usageUtcOffset;
	}

	public String getWalletId() {
		return walletId;
	}

	public void setWalletId(String walletId) {
		this.walletId = walletId;
	}

	public String getWalletOwnerExternalId() {
		return walletOwnerExternalId;
	}

	public void setWalletOwnerExternalId(String walletOwnerExternalId) {
		this.walletOwnerExternalId = walletOwnerExternalId;
	}

	public String getWalletOwnerId() {
		return walletOwnerId;
	}

	public void setWalletOwnerId(String walletOwnerId) {
		this.walletOwnerId = walletOwnerId;
	}

	public String getWalletOwnerType() {
		return walletOwnerType;
	}

	public void setWalletOwnerType(String walletOwnerType) {
		this.walletOwnerType = walletOwnerType;
	}

	public String getEvent_type() {
		return event_type;
	}

	public void setEvent_type(String event_type) {
		this.event_type = event_type;
	}

	public String getAssociatedEventId() {
		return associatedEventId;
	}

	public void setAssociatedEventId(String associatedEventId) {
		this.associatedEventId = associatedEventId;
	}

	public List<BundleInfoArray> getBundleInfoArray() {
		return bundleInfoArray;
	}

	public void setBundleInfoArray(List<BundleInfoArray> bundleInfoArray) {
		this.bundleInfoArray = bundleInfoArray;
	}

	public List<OfferInfoArray> getOfferInfoArray() {
		return offerInfoArray;
	}

	public void setOfferInfoArray(List<OfferInfoArray> offerInfoArray) {
		this.offerInfoArray = offerInfoArray;
	}

	@Override
	public TypeInformation getProducedType() {
		return TypeInformation.of(new TypeHint<OEGEvent>() {
		});
	}

	@Override
	public OEGEvent deserialize(byte[] message) throws IOException {
		mapper = new ObjectMapper();
//		mapper.setDefaultPropertyInclusion(JsonInclude.Value.construct(Include.ALWAYS, Include.ALWAYS));
		OEGEvent temp = new OEGEvent();
		try {
			mapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
			mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
			temp = mapper.readValue(message, OEGEvent.class);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return temp;
	}

	@Override
	public boolean isEndOfStream(OEGEvent nextElement) {
		return false;
	}

	@Override
	public byte[] serialize(OEGEvent element) {
		String json = "";
//		mapper.setDefaultPropertyInclusion(Include.NON_NULL);
		try {
			json = mapper.writeValueAsString(element);
		} catch (Exception ex) {

		}
		return json.getBytes();
	}
}
