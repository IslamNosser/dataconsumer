package com.orange.matrixx.objects;

import java.io.IOException;
import java.util.Date;

import org.apache.flink.api.common.typeinfo.TypeHint;
import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.streaming.util.serialization.DeserializationSchema;
import org.apache.flink.streaming.util.serialization.SerializationSchema;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MtxBalanceUpdate {
	@JsonProperty("BalanceClassId")
	public String balanceClassId;
	@JsonProperty("BalanceTemplateId")
	public String balanceTemplateId;
	@JsonProperty("BalanceResourceId")
	public String balanceResourceId;
	@JsonProperty("BalanceStartTime")
	public Date balanceStartTime;
	@JsonProperty("BalanceEndTime")
	public Date balanceEndTime;
	@JsonProperty("Flags")
	public String flags;
	@JsonProperty("Amount")
	public String amount;

	public String getBalanceClassId() {
		return balanceClassId;
	}

	public void setBalanceClassId(String balanceClassId) {
		this.balanceClassId = balanceClassId;
	}

	public String getBalanceTemplateId() {
		return balanceTemplateId;
	}

	public void setBalanceTemplateId(String balanceTemplateId) {
		this.balanceTemplateId = balanceTemplateId;
	}

	public String getBalanceResourceId() {
		return balanceResourceId;
	}

	public void setBalanceResourceId(String balanceResourceId) {
		this.balanceResourceId = balanceResourceId;
	}

	public Date getBalanceStartTime() {
		return balanceStartTime;
	}

	public void setBalanceStartTime(Date balanceStartTime) {
		this.balanceStartTime = balanceStartTime;
	}

	public Date getBalanceEndTime() {
		return balanceEndTime;
	}

	public void setBalanceEndTime(Date balanceEndTime) {
		this.balanceEndTime = balanceEndTime;
	}

	public String getFlags() {
		return flags;
	}

	public void setFlags(String flags) {
		this.flags = flags;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}
}
