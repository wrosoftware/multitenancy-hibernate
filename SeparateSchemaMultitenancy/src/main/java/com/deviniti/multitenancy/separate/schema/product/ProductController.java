package com.deviniti.multitenancy.separate.schema.product;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deviniti.multitenancy.separate.schema.product.domain.ProductDomain;
import com.deviniti.multitenancy.separate.schema.product.dto.ProductDto;

@RestController
@RequestMapping("api/product")
public class ProductController {
	
	private ProductDomain productDomain;
	
	public ProductController(ProductDomain productDomain) {
		this.productDomain = productDomain;
	}
	
	@GetMapping("/all")
	public List<ProductDto> getAllProductsOfClient(){
		return productDomain.getAllProducts();
	}
}
