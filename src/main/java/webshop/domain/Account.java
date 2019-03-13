package webshop.domain;

import java.util.Date;
import java.util.List;

public class Account {
	
	private Date OpenDatum;
	private int id;
	private String isActief;
	private String rol;
	private String email;
	private String wachtwoord;
	private Adres mijnAdres;
	private List<Bestelling> mijnBestellingen;
	
	

	public Account(Date openDatum, int id, String isActief, String rol, String email,
			String wachtwoord) {
		super();
		OpenDatum = openDatum;
		this.id = id;
		this.isActief = isActief;
		this.rol = rol;
		this.email = email;
		this.wachtwoord = wachtwoord;
	}

	public Account(Date openDatum, int id, String isActief, String rol, String email,
			String wachtwoord, Adres mijnAdres, List<Bestelling> mijnBestellingen) {
		super();
		OpenDatum = openDatum;
		this.id = id;
		this.isActief = isActief;
		this.rol = rol;
		this.email = email;
		this.wachtwoord = wachtwoord;
		this.mijnAdres = mijnAdres;
		this.mijnBestellingen = mijnBestellingen;
	}

	public Date getOpenDatum() {
		return OpenDatum;
	}

	public void setOpenDatum(Date openDatum) {
		OpenDatum = openDatum;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIsActief() {
		return isActief;
	}

	public void setIsActief(String isActief) {
		this.isActief = isActief;
	}

	public Adres getMijnAdres() {
		return mijnAdres;
	}

	public void setMijnAdres(Adres mijnAdres) {
		this.mijnAdres = mijnAdres;
	}

	public List<Bestelling> getMijnBestellingen() {
		return mijnBestellingen;
	}

	public void setMijnBestellingen(List<Bestelling> mijnBestellingen) {
		this.mijnBestellingen = mijnBestellingen;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWachtwoord() {
		return wachtwoord;
	}

	public void setWachtwoord(String wachtwoord) {
		this.wachtwoord = wachtwoord;
	}
	
	

}
