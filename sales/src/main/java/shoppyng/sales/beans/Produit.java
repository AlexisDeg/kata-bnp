package shoppyng.sales.beans;

import java.io.PrintStream;
import java.math.BigDecimal;

public class Produit {
	
	/*
	 * Attributs
	 */
	private String id;
	
	private String nom;
	
	private String description;
	
	private BigDecimal prix;
	
	/*
	 * Getters/Setters
	 */
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrix() {
		return prix;
	}

	public void setPrix(BigDecimal prix) {
		this.prix = prix;
	}
	
	/*
	 * Constructeurs
	 */
	public Produit(String id, String nom, String description, BigDecimal prix) {
		this.id = id;
		this.nom = nom;
		this.description = description;
		this.prix = prix;
	}
	
	public Produit() {
		
	}

	/*
	 * Méthodes
	 */
	public void afficher(PrintStream printStream) {
		printStream.println(nom + " - " + description + " - Prix unitaire : " + prix);
	}

	
	
}
