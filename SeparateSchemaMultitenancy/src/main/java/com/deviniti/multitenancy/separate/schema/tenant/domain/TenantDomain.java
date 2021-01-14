package com.deviniti.multitenancy.separate.schema.tenant.domain;

import com.deviniti.multitenancy.separate.schema.tenant.model.TenantDto;

public interface TenantDomain {

	public TenantDto getTenantByTenantId(String tenantId);
}
