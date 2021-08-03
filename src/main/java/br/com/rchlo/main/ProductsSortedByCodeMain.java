package br.com.rchlo.main;


import java.util.List;

import br.com.rchlo.data.ProductRepository;
import br.com.rchlo.domain.Product;
import br.com.rchlo.service.ProductsSortedByCode;

public class ProductsSortedByCodeMain {

	public static void main(String[] args) {
		List<Product> allProducts = ProductRepository.all();
		
		ProductsSortedByCode productSortedByCode = new ProductsSortedByCode();
		List<Product> sortedProducts = productSortedByCode.sort(allProducts);
		
		System.out.println(sortedProducts);
	}

}
