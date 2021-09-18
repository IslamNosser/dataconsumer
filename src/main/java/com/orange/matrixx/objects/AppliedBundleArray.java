package com.orange.matrixx.objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AppliedBundleArray {
	public int appliedCatalogItemIndex;
	public String bundleExternalId;
	public int bundleId;
	public int bundleResourceId;
	public int bundleVersion;
	public String mtx_container_name;
	public int mtx_ext_ver;
	public int mtx_sys_ver;
	public PurchasedBundleAttr purchasedBundleAttr;

	public int getAppliedCatalogItemIndex() {
		return appliedCatalogItemIndex;
	}

	public void setAppliedCatalogItemIndex(int appliedCatalogItemIndex) {
		this.appliedCatalogItemIndex = appliedCatalogItemIndex;
	}

	public String getBundleExternalId() {
		return bundleExternalId;
	}

	public void setBundleExternalId(String bundleExternalId) {
		this.bundleExternalId = bundleExternalId;
	}

	public int getBundleId() {
		return bundleId;
	}

	public void setBundleId(int bundleId) {
		this.bundleId = bundleId;
	}

	public int getBundleResourceId() {
		return bundleResourceId;
	}

	public void setBundleResourceId(int bundleResourceId) {
		this.bundleResourceId = bundleResourceId;
	}

	public int getBundleVersion() {
		return bundleVersion;
	}

	public void setBundleVersion(int bundleVersion) {
		this.bundleVersion = bundleVersion;
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

	public PurchasedBundleAttr getPurchasedBundleAttr() {
		return purchasedBundleAttr;
	}

	public void setPurchasedBundleAttr(PurchasedBundleAttr purchasedBundleAttr) {
		this.purchasedBundleAttr = purchasedBundleAttr;
	}
}
