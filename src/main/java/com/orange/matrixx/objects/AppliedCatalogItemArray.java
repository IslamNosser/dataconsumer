package com.orange.matrixx.objects;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AppliedCatalogItemArray {
	public String catalogItemExternalId;
	public int catalogItemId;
	public List<CatalogItemParameterArray> catalogItemParameterArray;
	public int catalogItemResourceId;
	public CatalogItemTemplateAttr catalogItemTemplateAttr;
	public String mtx_container_name;
	public int mtx_ext_ver;
	public int mtx_sys_ver;

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

	public List<CatalogItemParameterArray> getCatalogItemParameterArray() {
		return catalogItemParameterArray;
	}

	public void setCatalogItemParameterArray(List<CatalogItemParameterArray> catalogItemParameterArray) {
		this.catalogItemParameterArray = catalogItemParameterArray;
	}

	public int getCatalogItemResourceId() {
		return catalogItemResourceId;
	}

	public void setCatalogItemResourceId(int catalogItemResourceId) {
		this.catalogItemResourceId = catalogItemResourceId;
	}

	public CatalogItemTemplateAttr getCatalogItemTemplateAttr() {
		return catalogItemTemplateAttr;
	}

	public void setCatalogItemTemplateAttr(CatalogItemTemplateAttr catalogItemTemplateAttr) {
		this.catalogItemTemplateAttr = catalogItemTemplateAttr;
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
}
