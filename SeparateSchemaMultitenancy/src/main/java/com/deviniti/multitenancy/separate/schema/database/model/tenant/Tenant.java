package com.deviniti.multitenancy.separate.schema.database.model.tenant;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(schema="public")
@Data
public class Tenant {

	@Id
	private String tenantId;
	private String schemaName;
	
}
