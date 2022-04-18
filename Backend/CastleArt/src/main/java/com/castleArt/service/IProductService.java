package com.castleArt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.castleArt.dto.ProductDto;
import com.castleArt.entities.Product;

@Service
public interface IProductService {
	List<ProductDto> findAllProducts();
	List<Product> findProductsByName(String name);
	List<Product> findProductsByCategory(String category);
	List<Product> findProductsByPrice(int price);
	List<Product> findProductsByPriceInRange(int base,int top);
	List<Product> findProductsByNamePattern(String name);
	boolean deleteProduct(int productId);
	

}
