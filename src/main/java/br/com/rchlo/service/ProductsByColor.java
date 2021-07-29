package br.com.rchlo.service;

import java.util.List;

import br.com.rchlo.domain.Color;
import br.com.rchlo.domain.Product;

public class ProductsByColor {
	
	public List<Product> filter(Color color, List<Product> products) {
		
		if(color == null) {
			throw new IllegalArgumentException("N�o foi passada nenhuma cor");
		} else if(products == null) {
			throw new NullPointerException("N�o h� lista de produtos para buscar");
		}
		
		return products.stream().filter(p -> p.getColor().name() == color.name()).toList();		
	}
	
}
