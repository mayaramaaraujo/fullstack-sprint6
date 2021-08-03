package br.com.rchlo.service;

import br.com.rchlo.domain.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ProductsByEffectivePriceRange {

	public List<Product> filterProductsByEffectivePrice(BigDecimal minimumPrice, BigDecimal maximumPrice,
			List<Product> allProducts) {
		if (minimumPrice == null)
			throw new IllegalArgumentException("minimum price should not be null");
		if (maximumPrice == null)
			throw new IllegalArgumentException("maximum price should not be null");
		if (allProducts == null)
			throw new IllegalArgumentException("product list should not be null");

		List<Product> filteredProducts = new ArrayList<>();

		filteredProducts.addAll(
			allProducts
				.stream()
				.filter(p -> p.compare(minimumPrice , maximumPrice))
				.toList()
		);

		return filteredProducts;
	}

}
