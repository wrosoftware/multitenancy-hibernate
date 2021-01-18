package com.deviniti.multitenancy.separate.schema.configuration.multitenancy.context;

public abstract class TenantContext {

	public static final String DEFAULT_TENANT_ID = "multitenancy_default";
	private static ThreadLocal<String> currentTenant = new ThreadLocal<String>();

    public static void setCurrentTenant(String tenant) {
        currentTenant.set(tenant);
    }

    public static String getCurrentTenant() {
        return currentTenant.get();
    }

    public static void clear() {
        currentTenant.remove();
    }
	
}
