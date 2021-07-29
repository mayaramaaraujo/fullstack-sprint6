package br.com.rchlo.service;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.rchlo.domain.Color;
import br.com.rchlo.domain.Product;
import br.com.rchlo.domain.Size;

class ProductSizesReportTest {
	
	private ProductSizesReport productSizesReport;
	
	@BeforeEach
    void setUp() {
		productSizesReport = new ProductSizesReport();
    }
	
	@Test
	void shouldReturnOnlyOneProductWithTheSmallSize() {
		List<Product> products = List.of(aTShirt(), aJacket());
		Map<Size, List<Product>> productsReport = productSizesReport.report(products);
		
		assertTrue(productsReport.get(Size.SMALL).contains(products.get(0)));
		assertEquals(1, productsReport.get(Size.SMALL).size());
	}
	
	@Test
	void shouldReturnZeroIfThereAreNoProductsOfOneSize() {
		List<Product> products = List.of(aTShirt(), aJacket());
		Map<Size, List<Product>> productsReport = productSizesReport.report(products);
		
		assertFalse(productsReport.get(Size.LARGE).contains(products.get(0)));
		assertEquals(0, productsReport.get(Size.LARGE).size());
	}
	
	@Test
	void shouldThrowAnExceptionIfTheProductListIsNull() {
		assertThrows(NullPointerException.class,() -> productSizesReport.report(null)); 
	}
	
	private Product aTShirt() {
        return new Product(14125021L,
                "Camiseta Infantil Manga Curta Super Mario",
                "A Camiseta Infantil Manga Curta Super Mario é confeccionada em malha macia de algodão e possui decote careca, mangas curtas e detalhe de estampa frontal e padronagem do Super Mario. Aposte na peça na hora de compor visuais geek divertidos.",
                "camiseta-infantil-manga-curta-super-mario-14125021_sku",
                "Nintendo",
                new BigDecimal("49.90"),
                new BigDecimal("5.0"),
                Color.WHITE,
                106,
                "https://static.riachuelo.com.br/RCHLO/14125021001/portrait/a53fcda4f1ea1e04f5d67f4d4fe98248f25bcd73.jpg",
                Set.of(Size.SMALL, Size.MEDIUM));
    }

    private Product aJacket() {
        return new Product(13834193L,
                "Jaqueta Puffer Juvenil Com Capuz Super Mario",
                "A Jaqueta Puffer Juvenil Com Capuz Super Mario é confeccionada em material sintético. Possui estrutura ampla e modelo puffer, com capuz em pelúcia e bolsos frontais. Ideal para compor looks de inverno, mas sem perder o estilo. Combine com uma camiseta, calça jeans e tênis colorido.",
                "jaqueta-puffer-juvenil-com-capuz-super-mario-13834193_sku",
                "Nintendo",
                new BigDecimal("199.90"),
                null,
                Color.WHITE,
                147,
                "https://static.riachuelo.com.br/RCHLO/13834193003/portrait/3107b7473df334c6ff206cd78d16dec86d7dfe9a.jpg",
                Set.of(Size.MEDIUM, Size.EXTRA_LARGE));
    }

}
