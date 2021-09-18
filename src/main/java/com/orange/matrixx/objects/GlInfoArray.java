package com.orange.matrixx.objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GlInfoArray {
	public String account1;
	public String account2;
	public double amount;
	public int appliedOfferIndex;
	public int balanceUpdateIndex;
	public String mtx_container_name;
	public int mtx_ext_ver;
	public int mtx_sys_ver;
	public int revenueRecognitionType;
	public int txnType;
	public int updateType;

	public String getAccount1() {
		return account1;
	}

	public void setAccount1(String account1) {
		this.account1 = account1;
	}

	public String getAccount2() {
		return account2;
	}

	public void setAccount2(String account2) {
		this.account2 = account2;
	}

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

	public int getRevenueRecognitionType() {
		return revenueRecognitionType;
	}

	public void setRevenueRecognitionType(int revenueRecognitionType) {
		this.revenueRecognitionType = revenueRecognitionType;
	}

	public int getTxnType() {
		return txnType;
	}

	public void setTxnType(int txnType) {
		this.txnType = txnType;
	}

	public int getUpdateType() {
		return updateType;
	}

	public void setUpdateType(int updateType) {
		this.updateType = updateType;
	}
}
