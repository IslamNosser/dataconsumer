package com.orange.matrixx.objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CatalogItemParameterArray {
	public boolean isDefaultValue;
	public String mtx_container_name;
	public int mtx_ext_ver;
	public int mtx_sys_ver;
	public int parameterDefnId;
	public String parameterName;
	public Value value;
	public String valueType;

	public boolean isDefaultValue() {
		return isDefaultValue;
	}

	public void setDefaultValue(boolean isDefaultValue) {
		this.isDefaultValue = isDefaultValue;
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

	public int getParameterDefnId() {
		return parameterDefnId;
	}

	public void setParameterDefnId(int parameterDefnId) {
		this.parameterDefnId = parameterDefnId;
	}

	public String getParameterName() {
		return parameterName;
	}

	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
	}

	public Value getValue() {
		return value;
	}

	public void setValue(Value value) {
		this.value = value;
	}

	public String getValueType() {
		return valueType;
	}

	public void setValueType(String valueType) {
		this.valueType = valueType;
	}
}
