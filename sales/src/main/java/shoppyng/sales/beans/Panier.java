package shoppyng.sales.beans;

import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Panier {
	
	/*
	 * Attributs
	 */
	private Integer id;
	
	private String nomAcheteur;
	
	private List<LignePanier> lignes = new ArrayList<>();
	
	/*
	 * Getters/Setters
	 */
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomAcheteur() {
		return nomAcheteur;
	}

	public void setNomAcheteur(String nomAcheteur) {
		this.nomAcheteur = nomAcheteur;
	}

	public List<LignePanier> getLignes() {
		return lignes;
	}

	public void setLignes(List<LignePanier> lignes) {
		this.lignes = lignes;
	}
	
	/*
	 * Constructeurs
	 */
	public Panier(Integer id, String nomAcheteur) {
		this.id = id;
		this.nomAcheteur = nomAcheteur;
	}
	
	public Panier() {
		
	}

	/*
	 * Méthodes
	 */
	public void ajouterProduit(Produit produit, Integer quantite) {
		if(lignes == null) {
			lignes = new ArrayList<>();
		}
		LignePanier lignePanier = new LignePanier(produit, quantite);
		lignes.add(lignePanier);
	}
	
	public void supprimerProduit(String idProduit, Integer quantite) {
		LignePanier lignePanier = rechercherLignePanier(idProduit);
		if(lignePanier != null) {
			if(lignePanier.getQuantite() > 1) {
				lignePanier.setQuantite(lignePanier.getQuantite() - 1);
				lignePanier.calculerMontant();
			}
			else {
				lignes.remove(lignePanier);
			}
		}
	}
	
	public void consulter(PrintStream printStream) {
		printStream.println("Contenu du panier de " + nomAcheteur);
		if(lignes != null && lignes.size() > 0) {
			for(LignePanier lignePanier : lignes) {
				lignePanier.afficher(printStream);
			}
			printStream.println("Montant total : " + calculerMontantTotal());
		}
		else {
			printStream.println("Vide");
		}
	}
	
	public BigDecimal calculerMontantTotal() {
		BigDecimal montantTotal = BigDecimal.ZERO;
		if(lignes != null && lignes.size() > 0) {
			for(LignePanier lignePanier : lignes) {
				montantTotal = montantTotal.add(lignePanier.calculerMontant());
			}
		}
		return montantTotal;
	}
	
	private LignePanier rechercherLignePanier(String idProduit) {
		LignePanier resultat = null;
		if(idProduit != null && !idProduit.isEmpty() && lignes != null && lignes.size() > 0) {
			for(LignePanier lignePanier : lignes) {
				if(lignePanier.getProduit() != null && idProduit.equals(lignePanier.getProduit().getId())) {
					resultat = lignePanier;
				}
			}
		}
		return resultat;
	}
	
}
