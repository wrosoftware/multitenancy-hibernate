package com.deviniti.multitenancy.separate.schema.tenant.domain;

import java.io.IOException;
import java.util.Properties;

import org.springframework.stereotype.Component;

import com.deviniti.multitenancy.separate.schema.tenant.model.TenantDto;

@Component
class TenantDomainImpl implements TenantDomain {
	
	private static final String HIBERNATE_PROPERTIES_PATH = "/application.properties";
	private TenantService tenantService;
	
	public TenantDomainImpl(TenantService tenantService) {
		this.tenantService = tenantService;
	}

	@Override
	public TenantDto getTenantByTenantId(String tenantId) {
		return tenantService.findByTenantId(tenantId);
	}

	@Override
	public Properties getHibernatePropertiesForTenantId(String tenantId) {
        try {
        	Properties properties = new Properties();
			properties.load(getClass().getResourceAsStream(HIBERNATE_PROPERTIES_PATH));
			return properties;
		} catch (IOException e) {
			throw new RuntimeException("Cannot open hibernate properties: "+ HIBERNATE_PROPERTIES_PATH);
		}
	}
	
}
