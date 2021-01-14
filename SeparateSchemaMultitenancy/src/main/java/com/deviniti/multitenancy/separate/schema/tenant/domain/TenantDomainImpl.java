package com.deviniti.multitenancy.separate.schema.tenant.domain;

import org.springframework.stereotype.Component;

import com.deviniti.multitenancy.separate.schema.tenant.model.TenantDto;

@Component
class TenantDomainImpl implements TenantDomain {

	@Override
	public TenantDto getTenantByTenantId(String tenantId) {
		//TODO
		return null;
	}
	
}
