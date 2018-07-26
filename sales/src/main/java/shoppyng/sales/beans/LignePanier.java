package shoppyng.sales.beans;

import java.io.PrintStream;
import java.math.BigDecimal;

public class LignePanier {
	
	/*
	 * Attributs
	 */
	private Produit produit;
	
	private Integer quantite;
	
	/* 
	 * Getters/Setters
	 */
	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public Integer getQuantite() {
		return quantite;
	}

	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}
	
	/*
	 * Constructeurs
	 */
	public LignePanier(Produit produit, Integer quantite) {
		this.produit = produit;
		this.quantite = quantite;
		calculerMontant();
	}

	public LignePanier() {
		
	}

	/*
	 * Méthodes
	 */
	public BigDecimal calculerMontant() {
		BigDecimal montantLigne = BigDecimal.ZERO;
		if(produit != null && produit.getPrix() != null && quantite != null) {
			montantLigne = produit.getPrix().multiply(new BigDecimal(quantite));
		}
		return montantLigne;
	}
	
	public void afficher(PrintStream printStream) {
		if(produit != null && quantite != null) {
			produit.afficher(printStream);
			printStream.println("Quantité : " + quantite + " " + "Montant : " + this.calculerMontant());
		}
	}
	
}
