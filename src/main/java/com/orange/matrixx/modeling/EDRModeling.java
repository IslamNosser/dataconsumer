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
		edrModel.setInitiatorId(value.getInitiatorId());
		edrModel.setInitiatorExternalId(value.getInitiatorExternalId());
		edrModel.setInitiatorDeviceId(value.getInitiatorDeviceId());
		edrModel.setInitiatorDeviceExternalId(value.getInitiatorDeviceExternalId());
		edrModel.setWalletId(value.getWalletId());
		edrModel.setWalletOwnerId(value.getWalletOwnerId());
		edrModel.setWalletOwnerExternalId(value.getWalletOwnerExternalId());
		edrModel.setWalletOwnerType(Integer.valueOf(value.getWalletOwnerType()));
		edrModel.setFlags(value.getFlags());
		edrModel.setEventTime(value.getEventTime());
		edrModel.setDuration(Integer.valueOf(String.valueOf(value.getDuration())));
		edrModel.setAssociatedEventId(value.getAssociatedEventIdList().get(0));
		edrModel.setInitiatorPrimaryUserId(value.getInitiatorPrimaryUserId());
		edrModel.setInitiatorPrimaryUserExternalId(value.getInitiatorPrimaryUserExternalId());
		edrModel.setInitiatorType(Integer.valueOf(value.getInitiatorType()));
		edrModel.setAggregationId(value.getAggregationId());
		edrModel.setSessionIdCust(value.getSessionIdCust());
		edrModel.setCallUsageType(value.getCallUsageType());
		edrModel.setEventClass("Data");
		edrModel.setServiceId(value.getServiceId());
		edrModel.setAPartyMsisdn(value.getaPartyMsisdn());
		edrModel.setBPartyMsisdn(value.getbPartyMsisdn());
		edrModel.setMSISDN(value.getmSISDN());
		edrModel.setVLRInfo(value.getvLRInfo());
		edrModel.setLac(value.getlAC());
		edrModel.setCid(value.getcID());
		edrModel.setApn(value.getaPN());
		edrModel.setApplicationName(value.getApplicationName());
		edrModel.setApplicationCategory(value.getApplicationCategory());
		edrModel.setSgsnIpAddress(value.getSgsnIpAddress());
		edrModel.setImsi(String.valueOf(value.getImsi()));
		edrModel.setChargedPartyCountry(value.getChargedPartyCountry());
		edrModel.setOtherPartyCountry(value.getChargedPartyCountry());
		edrModel.setRoamingCarrier(value.getRoamingCarrier());
		edrModel.setRoamingFlag(Integer.valueOf(value.getRoamingFlag()));
		edrModel.setSubscriberType(value.getSubscriberType());
		edrModel.setUsageUtcOffset(value.getUsageUtcOffset());
//		edrModel.setInfo(value.getinfo);
		if (value.getMeterUpdateArray() != null && value.getMeterUpdateArray().size() > 0) {
			for (MeterUpdateArray single_meter_update_arr : value.getMeterUpdateArray()) {
				if (edrModel.getMeterUpdateArray() == null) {
					edrModel.setMeterUpdateArray(
							single_meter_update_arr.getTemplateId() + "," + single_meter_update_arr.getAmount() + ";");
				} else {
					edrModel.setMeterUpdateArray(
							edrModel.getMeterUpdateArray() + single_meter_update_arr.getTemplateId() + ","
									+ single_meter_update_arr.getAmount() + ";");
				}
			}
		}
		if (value.getOfferInfoArray() != null && value.getOfferInfoArray().size() > 0) {
			for (OfferInfoArray single_offer_info_arr : value.getOfferInfoArray()) {
				if (edrModel.getOfferInfoArray() == null) {
					edrModel.setOfferInfoArray(single_offer_info_arr.getOfferId() + ";");
				} else {
					edrModel.setOfferInfoArray(edrModel.getOfferInfoArray() + single_offer_info_arr.getOfferId());
				}
			}
		}
		if (value.getBundleInfoArray() != null && value.getBundleInfoArray().size() > 0) {
			for (BundleInfoArray single_bundle_info_arr : value.getBundleInfoArray()) {
				if (edrModel.getBundleInfoArray() == null) {
					edrModel.setBundleInfoArray(single_bundle_info_arr.getBundleId() + ","
							+ single_bundle_info_arr.getCatalogItemId() + ";");
				} else {
					edrModel.setBundleInfoArray(edrModel.getBundleInfoArray() + single_bundle_info_arr.getBundleId()
							+ "," + single_bundle_info_arr.getCatalogItemId() + ";");
				}
			}
		}
		if (value.getUsageQuantityList() != null && value.getUsageQuantityList().size() > 0) {
			int usage_volume = 0;
			int rounded_usage_volume = 0;
			for (UsageQuantityList single_usage_quantity_list : value.getUsageQuantityList()) {
				if (edrModel.getUsageQuantityList() == null) {
					edrModel.setUsageQuantityList(single_usage_quantity_list.getQuantityType() + ","
							+ single_usage_quantity_list.getQuantityUnit() + ","
							+ single_usage_quantity_list.getMsgAmount() + ","
							+ single_usage_quantity_list.getRatingAmount() + ","
							+ String.valueOf(single_usage_quantity_list.getFlags()) + ";");
				} else {
					edrModel.setUsageQuantityList(
							edrModel.getUsageQuantityList() + "," + single_usage_quantity_list.getQuantityType() + ","
									+ single_usage_quantity_list.getQuantityUnit() + ","
									+ single_usage_quantity_list.getMsgAmount() + ","
									+ single_usage_quantity_list.getRatingAmount() + ","
									+ String.valueOf(single_usage_quantity_list.getFlags()) + ";");
				}
				if (single_usage_quantity_list.getFlags() == 1) {
					usage_volume += single_usage_quantity_list.getMsgAmount();
				}
				if (single_usage_quantity_list.getFlags() == 1) {
					rounded_usage_volume += single_usage_quantity_list.getRatingAmount();
				}
				edrModel.setUsageVolume(usage_volume);
				edrModel.setRoundedUsageVolume(rounded_usage_volume);
			}
		}
		if (value.getChargeList() != null && value.getChargeList().size() > 0) {
			int charge_amount = 0;
			for (ChargeList single_charge_list : value.getChargeList()) {
				if (single_charge_list.getUpdateType() == 1) {
					charge_amount += single_charge_list.getAmount();
				}
			}
			edrModel.setChargedAmount(charge_amount);
		}
		return edrModel;
	}
}
