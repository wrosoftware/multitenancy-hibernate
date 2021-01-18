package com.deviniti.multitenancy.separate.schema.configuration.hibernate.multitenancy;

import java.util.Properties;

import org.springframework.stereotype.Repository;

import com.deviniti.multitenancy.separate.schema.tenant.domain.TenantDomain;
import com.deviniti.multitenancy.separate.schema.tenant.model.TenantDto;

@Repository
class TenantHelper {

	private TenantDomain tenantDomain;
	
	public static TenantHelper instance;
	
	
	public TenantHelper(TenantDomain tenantDomain) {
		this.tenantDomain = tenantDomain;
		instance = this;
	}

	public TenantDto getTenantByTenantId(String tenantId) {
		return tenantDomain.getTenantByTenantId(tenantId);
	}

	public Properties getHibernatePropertiesForTenantId(String tenantId) {
		return tenantDomain.getHibernatePropertiesForTenantId(tenantId);
	}

	public static TenantHelper getInstance() {
		return instance;
	}
	
}
