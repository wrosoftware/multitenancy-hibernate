package com.deviniti.multitenancy.separate.schema.tenant.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TenantDto {

	private String tenantId;
	private String databaseSchemaName;
	
}
