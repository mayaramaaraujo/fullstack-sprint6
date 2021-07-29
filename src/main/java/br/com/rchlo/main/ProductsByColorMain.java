package br.com.rchlo.main;

import java.util.List;

import br.com.rchlo.data.ProductRepository;
import br.com.rchlo.domain.Color;
import br.com.rchlo.domain.Product;
import br.com.rchlo.service.ProductsByColor;

public class ProductsByColorMain {

	public static void main(String[] args) {
		new ProductRepository();
		List<Product> products = ProductRepository.all();
		
		ProductsByColor productsByColor = new ProductsByColor();
		List<Product> filteredProducts = productsByColor.filter(Color.WHITE, products);
		System.out.println(filteredProducts); 
	}

}
