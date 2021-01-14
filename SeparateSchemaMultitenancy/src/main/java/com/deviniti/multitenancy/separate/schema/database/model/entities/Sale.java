package com.deviniti.multitenancy.separate.schema.database.model.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@SequenceGenerator(name="seq_gen", sequenceName="sale_seq_gen", allocationSize = 1, initialValue = 1)
@Data
@EqualsAndHashCode(callSuper=true)
public class Sale extends BaseEntity{

	@ManyToOne
	private Customer customer;
	@ManyToMany
	@JoinTable(
			name = "Sale_Product", 
			joinColumns = @JoinColumn(name="sale_id"),
			inverseJoinColumns = @JoinColumn(name="product_id")
	)
	private List<Product> products;
	
}
