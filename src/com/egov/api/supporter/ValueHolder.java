package com.egov.api.supporter;

public class ValueHolder {
	
	private String objectType;
	private String key;
	private String value;
	
	public static ValueHolder newHolder() {
		return new ValueHolder();
	}
	
	public ValueHolder set( String objectType,  String key, String value) {
		this.objectType = objectType;
		this.key = key;
		this.value = value;
		return this;
	}
	
	public String getObjectType() {
		return objectType;
	}
	
	public String getKey() {
		return key;
	}
	public String getValue() {
		return value;
	}
	
	public String toString() {
		return objectType + "{" + key + ":" + value + "}";
	}
	
	
}
