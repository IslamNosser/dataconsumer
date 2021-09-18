package com.orange.matrixx.objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BalanceUpdateArray {
	public int appliedBundleIndex;
	public String mtx_container_name;
	public int mtx_ext_ver;
	public int mtx_sys_ver;
	public String productOfferExternalId;
	public String productOfferExternalOwnerId;
	public int productOfferId;
	public String productOfferOwnerId;
	public int productOfferResourceId;
	public int productOfferVersion;
	public int usageQuantity;
	public int usageQuantityUnit;

	public int getAppliedBundleIndex() {
		return appliedBundleIndex;
	}

	public void setAppliedBundleIndex(int appliedBundleIndex) {
		this.appliedBundleIndex = appliedBundleIndex;
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

	public String getProductOfferExternalId() {
		return productOfferExternalId;
	}

	public void setProductOfferExternalId(String productOfferExternalId) {
		this.productOfferExternalId = productOfferExternalId;
	}

	public String getProductOfferExternalOwnerId() {
		return productOfferExternalOwnerId;
	}

	public void setProductOfferExternalOwnerId(String productOfferExternalOwnerId) {
		this.productOfferExternalOwnerId = productOfferExternalOwnerId;
	}

	public int getProductOfferId() {
		return productOfferId;
	}

	public void setProductOfferId(int productOfferId) {
		this.productOfferId = productOfferId;
	}

	public String getProductOfferOwnerId() {
		return productOfferOwnerId;
	}

	public void setProductOfferOwnerId(String productOfferOwnerId) {
		this.productOfferOwnerId = productOfferOwnerId;
	}

	public int getProductOfferResourceId() {
		return productOfferResourceId;
	}

	public void setProductOfferResourceId(int productOfferResourceId) {
		this.productOfferResourceId = productOfferResourceId;
	}

	public int getProductOfferVersion() {
		return productOfferVersion;
	}

	public void setProductOfferVersion(int productOfferVersion) {
		this.productOfferVersion = productOfferVersion;
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
