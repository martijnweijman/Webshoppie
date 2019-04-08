package webshop.domain;

import java.util.List;

public class Bestelling {
	
	private int id;
	private String afleverAdres;
	private Adres mijnAdres;
	private List<Bestellingsregel> mijnBestellingsregels;
	
	public Bestelling(int id) {
		super();
		this.id = id;
	}
	
	public Bestelling(int id, String afleverAdres) {
		super();
		this.id = id;
		this.afleverAdres = afleverAdres;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAfleverAdres() {
		return afleverAdres;
	}
	public void setAfleverAdres(String afleverAdres) {
		this.afleverAdres = afleverAdres;
	}
	public Adres getMijnAdres() {
		return mijnAdres;
	}
	public void setMijnAdres(Adres mijnAdres) {
		this.mijnAdres = mijnAdres;
	}
	public List<Bestellingsregel> getMijnBestellingsregels() {
		return mijnBestellingsregels;
	}
	public void setMijnBestellingsregels(Bestellingsregel bestellingsregel) {
		mijnBestellingsregels.add(bestellingsregel);
	}
	
	
	
	
}
