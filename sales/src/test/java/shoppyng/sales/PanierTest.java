package shoppyng.sales;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import shoppyng.sales.beans.Panier;
import shoppyng.sales.beans.Produit;

public class PanierTest {
	
	Produit produit1;
	Produit produit2;
	Produit produit3;
	
	Panier panier1;
	Panier panier2;
	Panier panier3;
	
	@Before
	public void setUp() {
		produit1 = new Produit("tv-03", "Télévision", "Ecran plasma OLED pour une expérience optimale", BigDecimal.valueOf(2340.99));
		produit2 = new Produit("fauteuil-04", "Fauteuil", "Très confortable", BigDecimal.valueOf(89.89));
		produit3 = new Produit("chaise-05", "Chaise", "Moins confortable", BigDecimal.valueOf(9.00));
		panier1 = new Panier(123, "DEGAINE");
		panier2 = new Panier(456, "SOAT");
		panier3 = new Panier(789, "DUPONT");
	}
	
	@Test
	public void testAjouter() {
		panier1.ajouterProduit(produit1, 1);
		panier1.ajouterProduit(produit2, 2);
		panier1.ajouterProduit(produit3, 4);
		
		System.out.println("Panier 1");
		panier1.consulter(System.out);
		System.out.println("Panier 2");
		panier2.consulter(System.out);
		
		assertEquals(3, panier1.getLignes().size());
		assertEquals(0, panier2.getLignes().size());
		assertEquals(BigDecimal.valueOf(2556.77), panier1.calculerMontantTotal());
		assertEquals(BigDecimal.ZERO, panier2.calculerMontantTotal());
	}
	
	@Test
	public void testSupprimer() {
		panier3.ajouterProduit(produit1, 1);
		panier3.ajouterProduit(produit2, 2);
		panier3.ajouterProduit(produit3, 4);
		assertEquals(3, panier3.getLignes().size());
		assertEquals(BigDecimal.valueOf(2556.77), panier3.calculerMontantTotal());
		
		panier3.supprimerProduit("tv-03", 1);
		
		System.out.println("Panier 3");
		panier3.consulter(System.out);
		
		assertEquals(2, panier3.getLignes().size());
		assertEquals(BigDecimal.valueOf(215.78), panier3.calculerMontantTotal());
	}
	
}
