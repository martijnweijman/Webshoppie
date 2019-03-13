package webshop.domain;

public class Klant {

	private int id;
	private String naam;
	private String afbeelding;
	private Adres mijnAdres;
	private Account mijnAccount;
	
	public Klant(int id, String naam, String afbeelding, Adres mijnAdres, Account mijnAccount) {
		super();
		this.id = id;
		this.naam = naam;
		this.afbeelding = afbeelding;
		this.mijnAdres = mijnAdres;
		this.mijnAccount = mijnAccount;
	}
	
	public Klant(int id,String naam, String afbeelding) {
		super();
		this.id = id;
		this.naam = naam;
		this.afbeelding = afbeelding;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public String getAfbeelding() {
		return afbeelding;
	}

	public void setAfbeelding(String afbeelding) {
		this.afbeelding = afbeelding;
	}

	public Adres getMijnAdres() {
		return mijnAdres;
	}

	public void setMijnAdres(Adres mijnAdres) {
		this.mijnAdres = mijnAdres;
	}

	public Account getMijnAccount() {
		return mijnAccount;
	}

	public void setMijnAccount(Account mijnAccount) {
		this.mijnAccount = mijnAccount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
