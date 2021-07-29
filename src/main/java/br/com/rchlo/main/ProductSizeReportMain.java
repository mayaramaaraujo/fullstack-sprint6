package br.com.rchlo.main;

import java.util.List;
import java.util.Map;

import br.com.rchlo.data.ProductRepository;
import br.com.rchlo.domain.Product;
import br.com.rchlo.domain.Size;
import br.com.rchlo.service.ProductSizesReport;

public class ProductSizeReportMain {

	public static void main(String[] args) {
		List<Product> allProducts = ProductRepository.all();

		ProductSizesReport productSizesReport = new ProductSizesReport();
		Map<Size, List<Product>> productsReport = productSizesReport.report(allProducts);

//		imprime o relatório no console
		for (Size key : productsReport.keySet()) {
			System.out.println("Tamanho: " + key.getDescription());
			System.out.println("Quantidade: " + productsReport.get(key).size());
			System.out.println("Produtos: " + productsReport.get(key));
		}
	}

}
