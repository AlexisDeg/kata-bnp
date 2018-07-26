package shoppyng.sales;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import shoppyng.sales.beans.LignePanier;
import shoppyng.sales.beans.Produit;

public class LignePanierTest {
	
	Produit produit1;
	Produit produit2;
	LignePanier lignePanier1;
	LignePanier lignePanier2;
	LignePanier lignePanier3;
	
	@Before
	public void setUp() {
		produit1 = new Produit("laptop-01", "Ordinateur portable", "Il s'agit d'un ordinateur portable dernier cri", BigDecimal.valueOf(399.99));
		produit2 = new Produit("mug-02", "Mug", "Ce superbe mug égaiera vos petits déjeuners", BigDecimal.valueOf(10.50));
		lignePanier1 = new LignePanier(produit1, 1);
		lignePanier2 = new LignePanier(produit2, 4);
	}
	
	@Test
	public void testCalculerMontant()
    {
		BigDecimal montant1 = lignePanier1.calculerMontant();
        assertEquals(BigDecimal.valueOf(399.99), montant1);
        
        BigDecimal montant2 = lignePanier2.calculerMontant();
        assertEquals(BigDecimal.valueOf(42.0), montant2);
        
        lignePanier1.afficher(System.out);
		lignePanier2.afficher(System.out);
    }
	
}
