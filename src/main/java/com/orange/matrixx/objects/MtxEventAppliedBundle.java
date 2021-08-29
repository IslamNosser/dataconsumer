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
public class MtxEventAppliedBundle {
	@JsonProperty("BundleId")
	public String bundleId;
	@JsonProperty("BundleExternalId")
	public String bundleExternalId;
	@JsonProperty("BundleResourceId")
	public String bundleResourceId;
	@JsonProperty("BundleVersion")
	public String bundleVersion;
	@JsonProperty("AppliedCatalogItemIndex")
	public String appliedCatalogItemIndex;

	public String getBundleId() {
		return bundleId;
	}

	public void setBundleId(String bundleId) {
		this.bundleId = bundleId;
	}

	public String getBundleExternalId() {
		return bundleExternalId;
	}

	public void setBundleExternalId(String bundleExternalId) {
		this.bundleExternalId = bundleExternalId;
	}

	public String getBundleResourceId() {
		return bundleResourceId;
	}

	public void setBundleResourceId(String bundleResourceId) {
		this.bundleResourceId = bundleResourceId;
	}

	public String getBundleVersion() {
		return bundleVersion;
	}

	public void setBundleVersion(String bundleVersion) {
		this.bundleVersion = bundleVersion;
	}

	public String getAppliedCatalogItemIndex() {
		return appliedCatalogItemIndex;
	}

	public void setAppliedCatalogItemIndex(String appliedCatalogItemIndex) {
		this.appliedCatalogItemIndex = appliedCatalogItemIndex;
	}
}
