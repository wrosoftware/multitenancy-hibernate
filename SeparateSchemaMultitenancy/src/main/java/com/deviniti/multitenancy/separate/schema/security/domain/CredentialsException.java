package com.deviniti.multitenancy.separate.schema.security.domain;

@SuppressWarnings("serial")
public class CredentialsException extends RuntimeException{

	public CredentialsException(String message) {
		super(message);
	}
}
