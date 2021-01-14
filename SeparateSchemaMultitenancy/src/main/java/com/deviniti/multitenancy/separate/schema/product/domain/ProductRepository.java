package com.deviniti.multitenancy.separate.schema.product.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deviniti.multitenancy.separate.schema.database.model.entities.Product;

@Repository
interface ProductRepository extends JpaRepository<Product, Long>{

	
}
