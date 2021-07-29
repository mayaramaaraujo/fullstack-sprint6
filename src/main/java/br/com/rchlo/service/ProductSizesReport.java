package br.com.rchlo.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.rchlo.domain.Product;
import br.com.rchlo.domain.Size;

public class ProductSizesReport {
	private Map<Size, List<Product>> quantityOfProductsBySize = new HashMap<Size, List<Product>>();
	
	public Map<Size, List<Product>> report(List<Product> products) {
		List<Size> sizes = Arrays.asList(Size.values());	
		
		if(products == null) {
			throw new NullPointerException("Não foi passado nenhuma lista de produtos");
		}
		
		sizes.forEach(s -> {
			List<Product> filteredProducts = products.stream().filter(p -> p.getAvailableSizes().contains(s)).toList();
			quantityOfProductsBySize.put(s, filteredProducts);
		});
		
		return quantityOfProductsBySize;		
	}
}
