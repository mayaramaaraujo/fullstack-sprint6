package br.com.rchlo.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.rchlo.domain.Color;
import br.com.rchlo.domain.Product;

public class ProductColorReport {
	private Map<Color, Integer> quantityOfProductsByColor = new HashMap<Color, Integer>();

	public Map<Color, Integer> report(List<Product> products) {
		ProductsByColor productByColor = new ProductsByColor();		
		List<Color> colors = Arrays.asList(Color.values());		
		
		colors.forEach(c -> quantityOfProductsByColor.put(c, productByColor.filter(c, products).size()));
		
		return quantityOfProductsByColor;		
	}
}
