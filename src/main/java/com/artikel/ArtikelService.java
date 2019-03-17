package com.artikel;

import java.util.ArrayList;
import java.util.List;

public class ArtikelService {
	private static List<Artikel> artikellijst = new ArrayList<Artikel>();

	public ArtikelService() {
		artikellijst.add(new Artikel(90000, "TestAlbum1", "TestArtiest1", 19.50, "Blues", 2000, "Test beschrijving 1", "Geencover1"));
		artikellijst.add(new Artikel(90001, "TestAlbum2", "TestArtiest2", 22.00, "Reggae", 1950, "Test beschrijving 2", "Geencover2"));
	}

	public List<Artikel> geefAlleArtikelen() {
		return artikellijst;
	}

	public static Artikel geefArtikelMetId(int id) {
		Artikel resultaat = null;
		for (Artikel a : artikellijst) {
			if (a.getId() == id) {
				resultaat = a;
			}
		}
		return resultaat;
	}
	
	public boolean deleteArtikel(int id) {
		boolean waarheid = false;
		Artikel ditArtikel = geefArtikelMetId(id);
		if (ditArtikel != null) {
			artikellijst.remove(ditArtikel);
			waarheid = true;
		} 
		return waarheid;
	}
	
	public Artikel addArtikel(int id, String naam, String artiest, double prijs, String categorie, int uitgavejaar,
			String beschrijving, String cover) {
		Artikel p = new Artikel(id, naam, artiest, prijs, categorie, uitgavejaar, beschrijving, cover);
		artikellijst.add(p);
		return p;
	}
	
	public Artikel updateArtikel(int id, String naam, String artiest, double prijs, String categorie, int uitgavejaar,
			String beschrijving, String cover) {
		Artikel ditArtikel = geefArtikelMetId(id);
		if (ditArtikel != null) {
			artikellijst.remove(ditArtikel);
			artikellijst.add(new Artikel(id, naam, artiest, prijs, categorie, uitgavejaar, beschrijving, cover));
		}
		return ditArtikel;
	}
}
