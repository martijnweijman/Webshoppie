package com.artikel;

public class Artikel {
	private int id;
	private String naam;
	private String artiest;
	private double prijs;
	private String categorie;
	private int uitgavejaar;
	private String beschrijving;
	private String cover;
	
	public Artikel(int id, String naam, String artiest, double prijs, String categorie, int uitgavejaar,
			String beschrijving, String cover) {
		super();
		this.id = id;
		this.naam = naam;
		this.artiest = artiest;
		this.prijs = prijs;
		this.categorie = categorie;
		this.uitgavejaar = uitgavejaar;
		this.beschrijving = beschrijving;
		this.cover = cover;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNaam() {
		return naam;
	}
	public void setNaam(String naam) {
		this.naam = naam;
	}
	public String getArtiest() {
		return artiest;
	}
	public void setArtiest(String artiest) {
		this.artiest = artiest;
	}
	public double getPrijs() {
		return prijs;
	}
	public void setPrijs(double prijs) {
		this.prijs = prijs;
	}
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	public int getUitgavejaar() {
		return uitgavejaar;
	}
	public void setUitgavejaar(int uitgavejaar) {
		this.uitgavejaar = uitgavejaar;
	}
	public String getBeschrijving() {
		return beschrijving;
	}
	public void setBeschrijving(String beschrijving) {
		this.beschrijving = beschrijving;
	}
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}
	
	
}
