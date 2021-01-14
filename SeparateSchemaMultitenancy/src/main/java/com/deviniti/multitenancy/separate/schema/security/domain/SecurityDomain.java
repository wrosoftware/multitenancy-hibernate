package com.deviniti.multitenancy.separate.schema.security.domain;

import javax.servlet.http.HttpServletRequest;

public interface SecurityDomain {

	public String getTenantIdFromJwt(HttpServletRequest request);
}
