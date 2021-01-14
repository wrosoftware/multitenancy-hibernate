package com.deviniti.multitenancy.separate.schema.database.model.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Data;

@Data
@MappedSuperclass
public class BaseEntity {

	@Id
	@GeneratedValue(generator="seq_gen")
	protected Long id;
	
}
