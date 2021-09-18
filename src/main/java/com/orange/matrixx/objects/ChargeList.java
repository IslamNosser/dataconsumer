package com.orange.matrixx.objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ChargeList {
	public double amount;
	public int appliedOfferIndex;
	public int balanceUpdateIndex;
	public String impactSource;
	public String mtx_container_name;
	public int mtx_ext_ver;
	public int mtx_sys_ver;
	public int paymentType;
	public int updateType;
	public int usageQuantity;
	public int usageQuantityUnit;

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getAppliedOfferIndex() {
		return appliedOfferIndex;
	}

	public void setAppliedOfferIndex(int appliedOfferIndex) {
		this.appliedOfferIndex = appliedOfferIndex;
	}

	public int getBalanceUpdateIndex() {
		return balanceUpdateIndex;
	}

	public void setBalanceUpdateIndex(int balanceUpdateIndex) {
		this.balanceUpdateIndex = balanceUpdateIndex;
	}

	public String getImpactSource() {
		return impactSource;
	}

	public void setImpactSource(String impactSource) {
		this.impactSource = impactSource;
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

	public int getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(int paymentType) {
		this.paymentType = paymentType;
	}

	public int getUpdateType() {
		return updateType;
	}

	public void setUpdateType(int updateType) {
		this.updateType = updateType;
	}

	public int getUsageQuantity() {
		return usageQuantity;
	}

	public void setUsageQuantity(int usageQuantity) {
		this.usageQuantity = usageQuantity;
	}

	public int getUsageQuantityUnit() {
		return usageQuantityUnit;
	}

	public void setUsageQuantityUnit(int usageQuantityUnit) {
		this.usageQuantityUnit = usageQuantityUnit;
	}
}
