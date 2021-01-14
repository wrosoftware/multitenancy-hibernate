package com.deviniti.multitenancy.separate.schema.configuration.hibernate.multitenancy;

import com.deviniti.multitenancy.separate.schema.tenant.model.TenantDto;

public abstract class TenantContext {

	private static ThreadLocal<TenantDto> currentTenant = new ThreadLocal<TenantDto>();

    public static void setCurrentTenant(TenantDto tenant) {
        currentTenant.set(tenant);
    }

    public static TenantDto getCurrentTenant() {
        return currentTenant.get();
    }

    public static void clear() {
        currentTenant.remove();
    }
	
}
