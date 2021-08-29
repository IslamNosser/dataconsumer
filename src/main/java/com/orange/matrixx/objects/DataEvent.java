package com.orange.matrixx.objects;

import java.io.IOException;

import org.apache.flink.api.common.typeinfo.TypeHint;
import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.streaming.util.serialization.DeserializationSchema;
import org.apache.flink.streaming.util.serialization.SerializationSchema;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DataEvent implements DeserializationSchema<DataEvent>, SerializationSchema<DataEvent> {
	ObjectMapper mapper;
	@JsonProperty("OEGDataEvent")
	public OEGDataEvent OEGDataEvent;

	public OEGDataEvent getOEGDataEvent() {
		return OEGDataEvent;
	}

	public void setOEGDataEvent(OEGDataEvent oEGDataEvent) {
		OEGDataEvent = oEGDataEvent;
	}

	@Override
	public TypeInformation getProducedType() {
		return TypeInformation.of(new TypeHint<DataEvent>() {
		});
	}

	@Override
	public DataEvent deserialize(byte[] message) throws IOException {
		mapper = new ObjectMapper();
//		mapper.setDefaultPropertyInclusion(JsonInclude.Value.construct(Include.ALWAYS, Include.ALWAYS));
		DataEvent temp = new DataEvent();
		try {
			mapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
			mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
			temp = mapper.readValue(message, DataEvent.class);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		if (temp.getOEGDataEvent() != null) {
			System.out.println(temp.getOEGDataEvent().getaPartyMsisdn());
		}
		return temp;
	}

	@Override
	public boolean isEndOfStream(DataEvent nextElement) {
		return false;
	}

	@Override
	public byte[] serialize(DataEvent element) {
		String json = "";
//		mapper.setDefaultPropertyInclusion(Include.NON_NULL);
		try {
			json = mapper.writeValueAsString(element);
		} catch (Exception ex) {

		}
		return json.getBytes();
	}
}
