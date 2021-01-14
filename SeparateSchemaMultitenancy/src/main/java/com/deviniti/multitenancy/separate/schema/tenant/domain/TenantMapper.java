package com.deviniti.multitenancy.separate.schema.tenant.domain;

import com.deviniti.multitenancy.separate.schema.database.model.tenant.Tenant;
import com.deviniti.multitenancy.separate.schema.tenant.model.TenantDto;

public class TenantMapper {

	public static TenantDto mapToDto(Tenant tenant) {
		return TenantDto.builder()
				.tenantId(tenant.getTenantId())
				.databaseSchemaName(tenant.getSchemaName())
				.build();
	}
}
