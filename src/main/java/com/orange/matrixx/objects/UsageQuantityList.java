package com.orange.matrixx.objects;

import java.io.IOException;
import java.util.List;

import org.apache.flink.api.common.typeinfo.TypeHint;
import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.streaming.util.serialization.DeserializationSchema;
import org.apache.flink.streaming.util.serialization.SerializationSchema;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UsageQuantityList {
	public List<MtxEventUsageQuantity> mtxEventUsageQuantity;

	public List<MtxEventUsageQuantity> getMtxEventUsageQuantity() {
		return mtxEventUsageQuantity;
	}

	public void setMtxEventUsageQuantity(List<MtxEventUsageQuantity> mtxEventUsageQuantity) {
		this.mtxEventUsageQuantity = mtxEventUsageQuantity;
	}
}
