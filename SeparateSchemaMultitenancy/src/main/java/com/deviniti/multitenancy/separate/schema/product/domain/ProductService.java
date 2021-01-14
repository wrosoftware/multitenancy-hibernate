package com.deviniti.multitenancy.separate.schema.product.domain;

import static java.util.stream.Collectors.toList;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.deviniti.multitenancy.separate.schema.product.dto.ProductDto;

@Service
@Transactional
class ProductService {

	private ProductRepository productRepository;
	
	
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public List<ProductDto> getAllProducts() {
		return productRepository.findAll().stream()
				.map(ProductMapper::mapToDto)
				.collect(toList());
	}
	
	
}
