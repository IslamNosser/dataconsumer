package com.orange.matrixx.objects;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BundleInfoArray {
	public int bundleId;
	public int bundleVersion;
	public String catalogItemExternalId;
	public int catalogItemId;
	public CatalogItemTemplateAttr catalogItemTemplateAttr;
	public String endTime;
	public String externalId;
	public String mtx_container_name;
	public int mtx_ext_ver;
	public int mtx_sys_ver;
	public boolean preActiveState;
	public int resourceId;
	public Date startTime;

	public int getBundleId() {
		return bundleId;
	}

	public void setBundleId(int bundleId) {
		this.bundleId = bundleId;
	}

	public int getBundleVersion() {
		return bundleVersion;
	}

	public void setBundleVersion(int bundleVersion) {
		this.bundleVersion = bundleVersion;
	}

	public String getCatalogItemExternalId() {
		return catalogItemExternalId;
	}

	public void setCatalogItemExternalId(String catalogItemExternalId) {
		this.catalogItemExternalId = catalogItemExternalId;
	}

	public int getCatalogItemId() {
		return catalogItemId;
	}

	public void setCatalogItemId(int catalogItemId) {
		this.catalogItemId = catalogItemId;
	}

	public CatalogItemTemplateAttr getCatalogItemTemplateAttr() {
		return catalogItemTemplateAttr;
	}

	public void setCatalogItemTemplateAttr(CatalogItemTemplateAttr catalogItemTemplateAttr) {
		this.catalogItemTemplateAttr = catalogItemTemplateAttr;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getExternalId() {
		return externalId;
	}

	public void setExternalId(String externalId) {
		this.externalId = externalId;
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

	public boolean isPreActiveState() {
		return preActiveState;
	}

	public void setPreActiveState(boolean preActiveState) {
		this.preActiveState = preActiveState;
	}

	public int getResourceId() {
		return resourceId;
	}

	public void setResourceId(int resourceId) {
		this.resourceId = resourceId;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
}
