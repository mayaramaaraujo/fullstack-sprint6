package br.com.rchlo.main;

import java.util.List;
import java.util.Map;

import br.com.rchlo.data.ProductRepository;
import br.com.rchlo.domain.Color;
import br.com.rchlo.domain.Product;
import br.com.rchlo.service.ProductColorReport;

public class ProductColorsReportMain {

	public static void main(String[] args) {
		List<Product> allProducts = ProductRepository.all();
		
		ProductColorReport productColorReport = new ProductColorReport();
		Map<Color, Integer> productsReport = productColorReport.report(allProducts);
		
//		imprime o relatório no console
		for(Color key : productsReport.keySet()) {
			System.out.println(key + ": " + productsReport.get(key));
		}
	}
	

}
