package com.artikel;

public class ServiceProvider {
	private static ArtikelService artikelservice = new ArtikelService();

	public static ArtikelService getArtikelService() {
		return artikelservice;
	}
}