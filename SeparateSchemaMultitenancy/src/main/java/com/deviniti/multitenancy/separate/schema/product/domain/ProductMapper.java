package com.deviniti.multitenancy.separate.schema.product.domain;

import java.math.BigDecimal;
import java.util.Optional;

import com.deviniti.multitenancy.separate.schema.database.model.entities.Product;
import com.deviniti.multitenancy.separate.schema.database.model.entities.Warehouse;
import com.deviniti.multitenancy.separate.schema.product.dto.ProductDto;

public class ProductMapper {

	public static ProductDto mapToDto(Product product) {
		return ProductDto.builder()
				.name(product.getName())
				.description(product.getDescription())
				.price(product.getPrice())
				.availableAmount(getAvailableAmount(product))
				.build();
	}

	private static BigDecimal getAvailableAmount(Product product) {
		return Optional.ofNullable(product)
				.map(Product::getWarehouse)
				.map(Warehouse::getAmount)
				.orElse(BigDecimal.ZERO);
	}
}
