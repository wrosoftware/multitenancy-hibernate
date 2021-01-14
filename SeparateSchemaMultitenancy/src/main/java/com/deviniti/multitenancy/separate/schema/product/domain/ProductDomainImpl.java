package com.deviniti.multitenancy.separate.schema.product.domain;

import java.util.List;

import org.springframework.stereotype.Component;

import com.deviniti.multitenancy.separate.schema.product.dto.ProductDto;

@Component
class ProductDomainImpl implements ProductDomain {
	
	private ProductService productService;
	
	public ProductDomainImpl(ProductService productService) {
		this.productService = productService;
	}
	
	@Override
	public List<ProductDto> getAllProducts() {
		return productService.getAllProducts();
	}

}
