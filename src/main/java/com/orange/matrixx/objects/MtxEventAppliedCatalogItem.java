package com.orange.matrixx.objects;

import java.io.IOException;

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
public class MtxEventAppliedCatalogItem {
	@JsonProperty("CatalogItemId")
	public String catalogItemId;
	@JsonProperty("CatalogItemExternalId")
	public String catalogItemExternalId;
	@JsonProperty("CatalogItemResourceId")
	public String catalogItemResourceId;
	@JsonProperty("CatalogItemTemplateAttr")
	public CatalogItemTemplateAttr catalogItemTemplateAttr;

	public String getCatalogItemId() {
		return catalogItemId;
	}

	public void setCatalogItemId(String catalogItemId) {
		this.catalogItemId = catalogItemId;
	}

	public String getCatalogItemExternalId() {
		return catalogItemExternalId;
	}

	public void setCatalogItemExternalId(String catalogItemExternalId) {
		this.catalogItemExternalId = catalogItemExternalId;
	}

	public String getCatalogItemResourceId() {
		return catalogItemResourceId;
	}

	public void setCatalogItemResourceId(String catalogItemResourceId) {
		this.catalogItemResourceId = catalogItemResourceId;
	}

	public CatalogItemTemplateAttr getCatalogItemTemplateAttr() {
		return catalogItemTemplateAttr;
	}

	public void setCatalogItemTemplateAttr(CatalogItemTemplateAttr catalogItemTemplateAttr) {
		this.catalogItemTemplateAttr = catalogItemTemplateAttr;
	}
}
