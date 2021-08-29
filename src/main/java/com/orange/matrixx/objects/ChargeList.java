package com.orange.matrixx.objects;

import java.io.IOException;
import java.util.List;

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
public class ChargeList {
	@JsonProperty("MtxEventCharge")
	public List<MtxEventCharge> mtxEventCharge;

	public List<MtxEventCharge> getMtxEventCharge() {
		return mtxEventCharge;
	}

	public void setMtxEventCharge(List<MtxEventCharge> mtxEventCharge) {
		this.mtxEventCharge = mtxEventCharge;
	}
}
