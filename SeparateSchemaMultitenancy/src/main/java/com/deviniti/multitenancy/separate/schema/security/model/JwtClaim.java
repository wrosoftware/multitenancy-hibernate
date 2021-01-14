package com.deviniti.multitenancy.separate.schema.security.model;

public enum JwtClaim {

	TOKEN_ID("token-id");
	
	private String value;
	
	private JwtClaim(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
	public String getKey() {
		return this.name();
	}
}
