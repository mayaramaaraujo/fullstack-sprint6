package br.com.rchlo.service;

import java.util.List;

import br.com.rchlo.domain.Color;
import br.com.rchlo.domain.Product;

public class ProductsByColor {
	
	public List<Product> filter(Color color, List<Product> products) {
		
		if(color == null) {
			throw new IllegalArgumentException("Não foi passada nenhuma cor");
		} else if(products == null) {
			throw new NullPointerException("Não há lista de produtos para buscar");
		}
		
		return products.stream().filter(p -> p.getColor().name() == color.name()).toList();		
	}
	
}
