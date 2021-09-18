package com.orange.matrixx.objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PurchasedBundleAttr {
	public String combinationId1;
	public String combinationId2;
	public String mtx_container_name;
	public int mtx_ext_ver;
	public int mtx_sys_ver;
	public String transactionId;
	public String vendorId;

	public String getCombinationId1() {
		return combinationId1;
	}

	public void setCombinationId1(String combinationId1) {
		this.combinationId1 = combinationId1;
	}

	public String getCombinationId2() {
		return combinationId2;
	}

	public void setCombinationId2(String combinationId2) {
		this.combinationId2 = combinationId2;
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

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getVendorId() {
		return vendorId;
	}

	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}
}
