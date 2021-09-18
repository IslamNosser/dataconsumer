package com.orange.matrixx.modeling;

import org.apache.flink.api.common.functions.MapFunction;

import com.orange.matrixx.modelingobjects.EDRModel;
import com.orange.matrixx.objects.BundleInfoArray;
import com.orange.matrixx.objects.ChargeList;
import com.orange.matrixx.objects.MeterUpdateArray;
import com.orange.matrixx.objects.OEGEvent;
import com.orange.matrixx.objects.OfferInfoArray;
import com.orange.matrixx.objects.UsageQuantityList;

public class EDRModeling implements MapFunction<OEGEvent, EDRModel> {
	@Override
	public EDRModel map(OEGEvent value) throws Exception {
		EDRModel edrModel = new EDRModel();
		edrModel.setEventId(value.getEventId());
		edrModel.setAssociatedEventId(value.getAssociatedEventId());
		edrModel.setEventTime(value.getEventTime());
		switch (value.getMtx_container_name()) {
		case "OEGVoiceEvent":
			edrModel.setEventType(1);
			break;
		case "OEGDataEvent":
			edrModel.setEventType(2);
			break;
		case "OEGTextEvent":
			edrModel.setEventType(3);
			break;
		case "OEGPurchaseEvent":
			edrModel.setEventType(4);
			break;
		case "OEGRecurringEvent":
			edrModel.setEventType(5);
			break;
		default:
		}
		if (value.getaPartyMsisdn() == null || value.getaPartyMsisdn().isEmpty()) {
			edrModel.setAParty(value.getmSISDN());
		} else {
			edrModel.setAParty(value.getaPartyMsisdn());
		}
		edrModel.setBParty(value.getbPartyMsisdn());
		edrModel.setApn(value.getaPN());
		edrModel.setCellId(value.getcID());
		edrModel.setLac(value.getlAC());
		edrModel.setCallType(value.getCallType());
		edrModel.setCallUsageType(value.getCallUsageType());
		edrModel.setImsi(String.valueOf(value.getImsi()));
		edrModel.setSim(value.getInitiatorDeviceExternalId());

		edrModel.setMscAddress(value.getMscAddress());
		edrModel.setNetworkCallId(value.getNetworkCallReferenceId());
		if (value.getOnNet() != null && value.getOnNet() == "Onnet") {
			edrModel.setOnNet(1);
		} else if (value.getOnNet() != null && value.getOnNet() == "Offnet") {
			edrModel.setOnNet(0);
		}
		edrModel.setSessionId(value.getSessionId());
		edrModel.setWalletId(value.getWalletId());
		edrModel.setWalletOwner(value.getWalletOwnerExternalId());
		edrModel.setUsageUtcOffset(value.getUsageUtcOffset());
		edrModel.setSubscriberType(value.getSubscriberType());
		edrModel.setRoamingFlag(Integer.valueOf(value.getRoamingFlag()));
		edrModel.setChargedPartyMccMnc(value.getChargedPartyMccMnc());
		edrModel.setOriginationCarrier(value.getOriginationCarrier());
		edrModel.setRoamingCarrier(value.getRoamingCarrier());
		edrModel.setRatingGroup(value.getRatingGroup());
		edrModel.setApplicationName(value.getApplicationName());
		edrModel.setApplicationCategory(value.getApplicationCategory());
		edrModel.setServiceId(value.getServiceId());
		edrModel.setSgsnIp(value.getSgsnIpAddress());
		edrModel.setAggregationId(value.getAggregationId());

		if (value.getUsageQuantityList() != null) {

			for (int i = 0; i < value.getUsageQuantityList().size(); i++) {
				if (value.getUsageQuantityList().get(i).flags == 1) {
					edrModel.setUsageQuantityAmount(Double.valueOf(value.getUsageQuantityList().get(i).getMsgAmount()));
					edrModel.setUsageQuantityRatingAmount(
							Double.valueOf(value.getUsageQuantityList().get(i).getRatingAmount()));
					edrModel.setUsageQuantityUnit(value.getUsageQuantityList().get(i).getQuantityUnit());
					break;
				}
			}
		}
		if (edrModel.getUsageQuantityAmount() != null) {
			edrModel.setUsageVolume(edrModel.getUsageQuantityAmount());
		} else if (edrModel.getEventType() != null
				&& (edrModel.getEventType() == 3 || edrModel.getEventType() == 4 || edrModel.getEventType() == 5)) {
			edrModel.setUsageVolume(Double.valueOf(1));
		}
		if (edrModel.getUsageQuantityRatingAmount() != null) {
			edrModel.setRoundedUsageVolume(edrModel.getUsageQuantityRatingAmount());
		} else if (edrModel.getEventType() != null
				&& (edrModel.getEventType() == 3 || edrModel.getEventType() == 4 || edrModel.getEventType() == 5)) {
			edrModel.setRoundedUsageVolume(Double.valueOf(1));
		}
		if (value.getChargeList() != null) {

			for (int i = 0; i < value.getChargeList().size(); i++) {
				if (value.getChargeList().get(i).getUpdateType() == 1) {
					edrModel.setChargedAmount(value.getChargeList().get(i).getAmount());
					break;
				} else if (value.getChargeList().get(i).getUpdateType() == 3) {
					edrModel.setChargedAmount(-1 * value.getChargeList().get(i).getAmount());
					break;
				}
			}
		}
		edrModel.setDeleteCode(Integer.valueOf(value.getDeleteCode()));

		if (value.getMeterUpdateArray() != null && value.getMeterUpdateArray().size() > 0) {
			for (MeterUpdateArray single_meter_update_arr : value.getMeterUpdateArray()) {
				if (edrModel.getMeterUpdate() == null) {
					edrModel.setMeterUpdate(
							single_meter_update_arr.getTemplateId() + "," + single_meter_update_arr.getAmount() + ";");
				} else {
					edrModel.setMeterUpdate(edrModel.getMeterUpdate() + single_meter_update_arr.getTemplateId() + ","
							+ single_meter_update_arr.getAmount() + ";");
				}
			}
		}
		if (value.getOfferInfoArray() != null && value.getOfferInfoArray().size() > 0) {
			for (OfferInfoArray single_offer_info_arr : value.getOfferInfoArray()) {
				if (edrModel.getOfferInfo() == null) {
					edrModel.setOfferInfo(
							single_offer_info_arr.getOfferId() + "," + single_offer_info_arr.getExternalId() + ";");
				} else {
					edrModel.setOfferInfo(edrModel.getOfferInfo() + single_offer_info_arr.getOfferId() + ","
							+ single_offer_info_arr.getExternalId() + ";");
				}
			}
		}
		if (value.getBundleInfoArray() != null && value.getBundleInfoArray().size() > 0) {
			for (BundleInfoArray single_bundle_info_arr : value.getBundleInfoArray()) {
				if (edrModel.getBundleInfo() == null) {
					edrModel.setBundleInfo(
							single_bundle_info_arr.getBundleId() + "," + single_bundle_info_arr.getExternalId() + ","
									+ single_bundle_info_arr.getCatalogItemExternalId() + ","
									+ single_bundle_info_arr.getCatalogItemTemplateAttr().getOfferType() + ";");
				} else {
					edrModel.setBundleInfo(edrModel.getBundleInfo() + single_bundle_info_arr.getBundleId() + ","
							+ single_bundle_info_arr.getExternalId() + ","
							+ single_bundle_info_arr.getCatalogItemExternalId() + ","
							+ single_bundle_info_arr.getCatalogItemTemplateAttr().getOfferType() + ";");
				}
			}
		}
		if (value.getCycleType() != null) {
			edrModel.setCycleCatalog(value.getCycleCatalogItemExternalId() + "," + value.getCycleType() + ","
					+ value.getCycleStartTime() + "," + value.getCycleEndTime());
		}
		edrModel.setAppliedOfferBalanceUpdateChargeGlInfo("");
//		if (value.getChargeList() != null) {
//
//			for (int i = 0; i < value.getChargeList().size(); i++) {
//				if(value.getChargeList().get(i).getAppliedOfferIndex() != null) {
//					if(value.getAppliedOfferArray().get(value.getChargeList().get(i).getAppliedOfferIndex()).getAppliedBundleIndex() != null) {}
//				}
//			}
//			edrModel.setAppliedOfferBalanceUpdateChargeGlInfo("");
//		}
		return edrModel;
	}
}
