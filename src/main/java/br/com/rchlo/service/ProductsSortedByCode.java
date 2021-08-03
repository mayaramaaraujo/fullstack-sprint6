package br.com.rchlo.service;

import java.util.List;

import br.com.rchlo.domain.Product;

public class ProductsSortedByCode {
	
	public List<Product> sort(List<Product> allProducts) {
		if(allProducts == null) {
			throw new NullPointerException("É necessário passar uma lista de produtos para ordenar");
		}
		
		return allProducts
			.stream()
			.sorted()
			.toList();
	}
	
}
