package com.deviniti.multitenancy.separate.schema.product.domain;

import java.util.List;

import com.deviniti.multitenancy.separate.schema.product.dto.ProductDto;

public interface ProductDomain {

	List<ProductDto> getAllProducts();

}
