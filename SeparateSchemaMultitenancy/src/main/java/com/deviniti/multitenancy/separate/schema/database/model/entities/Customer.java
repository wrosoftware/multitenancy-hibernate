package com.deviniti.multitenancy.separate.schema.database.model.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Entity
@SequenceGenerator(name="seq_gen", sequenceName="customer_seq_gen", allocationSize = 1, initialValue = 1)
@Data
@EqualsAndHashCode(callSuper=true)
public class Customer extends BaseEntity {

	private String name;
	private String surname;
	private String login;
	private String password;
	@ManyToOne
	private Address address;
	
}
