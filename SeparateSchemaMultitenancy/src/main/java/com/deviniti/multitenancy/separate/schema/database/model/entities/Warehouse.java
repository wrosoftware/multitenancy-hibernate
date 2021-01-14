package com.deviniti.multitenancy.separate.schema.database.model.entities;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@SequenceGenerator(name="seq_gen", sequenceName="warehouse_seq_gen", allocationSize = 1, initialValue = 1)
@Data
@EqualsAndHashCode(callSuper=true)
public class Warehouse extends BaseEntity{

	private BigDecimal amount;

	@OneToOne(mappedBy="warehouse")
	private Product product;
	
}
