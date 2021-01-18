package com.deviniti.multitenancy.separate.schema.configuration.hibernate.multitenancy;

import java.util.Optional;

import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import com.deviniti.multitenancy.separate.schema.configuration.multitenancy.context.TenantContext;

@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class TenantIdentifierResolver implements CurrentTenantIdentifierResolver {
	
	@Override
	public String resolveCurrentTenantIdentifier() {
		return Optional.ofNullable(TenantContext.getCurrentTenant())
				.orElse(TenantContext.DEFAULT_TENANT_ID);
	}

	@Override
	public boolean validateExistingCurrentSessions() {
		return true;
	}

}
