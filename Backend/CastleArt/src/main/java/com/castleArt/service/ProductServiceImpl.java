package com.castleArt.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.castleArt.dao.ProductRepository;
import com.castleArt.dto.ArtistDto;
import com.castleArt.dto.ProductDto;
import com.castleArt.entities.Artist;
import com.castleArt.entities.Product;

@Service
public class ProductServiceImpl implements IProductService {
	
	@Autowired
	ProductRepository productrepo;

	@Override
	public List<ProductDto> findAllProducts() {
		List<Product>products =this.productrepo.findAll();
		List<ProductDto> productsDtos= products.stream().map(product -> ProductDto.fromEntitytoDto(product)).collect(Collectors.toList());
		return productsDtos;
	}

	@Override
	public List<Product> findProductsByName(String name) {
		// TODO Auto-generated method stub
		return productrepo.findProductsByName(name);
	}

	@Override
	public List<Product> findProductsByCategory(String category) {
		// TODO Auto-generated method stub
		return productrepo.findProductsByCategory(category);
	}

	@Override
	public List<Product> findProductsByPrice(int price) {
		// TODO Auto-generated method stub
		return productrepo.findProductsByPrice(price);
	}

	@Override
	public List<Product> findProductsByPriceInRange(int base, int top) {
		// TODO Auto-generated method stub
		return productrepo.findProductsByPriceBetweenRange(base, top);
	}

	@Override
	public List<Product> findProductsByNamePattern(String name) {
		// TODO Auto-generated method stub
		return productrepo.findProductsByNamePattern(name);
	}

	@Override
	public boolean deleteProduct(int productId) {
		// TODO Auto-generated method stub
		int row=this.productrepo.deleteProductById(productId);
		if(row!=0)
			return true;
		else 
			return false;
	}

	

}
