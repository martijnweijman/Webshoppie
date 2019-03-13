package webshop.domain;

import java.util.ArrayList;
import java.util.List;

public class PersoonService {
	private List<Persoon> personenlijst = new ArrayList<Persoon>();

	public PersoonService() {
		personenlijst.add(new Persoon("Chris", "Heuvel", 19));
		personenlijst.add(new Persoon("Martijn", "Wijeman", 22));
		personenlijst.add(new Persoon("Daan", "Pepping", 21));
		personenlijst.add(new Persoon("Kevin", "Kentie", 22));
	}

	public List<Persoon> geefAllePersonen() {
		return personenlijst;
	}

	public Persoon geefPersoonMetNaam(String naam) {
		Persoon resultaat = null;
		for (Persoon p : personenlijst) {
			if (p.getVoornaam().equals(naam)) {
				resultaat = p;
			}
		}
		return resultaat;
	}
	
	public boolean deletePersoon(String naam) {
		boolean waarheid = false;
		Persoon dezePersoon = geefPersoonMetNaam(naam);
		if (dezePersoon != null) {
			personenlijst.remove(dezePersoon);
			waarheid = true;
		} 
		return waarheid;
	}
	
	public Persoon addPersoon(String naam,String achternaam,int leeftijd) {
		Persoon p = new Persoon(naam, achternaam, leeftijd);
		personenlijst.add(p);
		return p;
	}
	
	public Persoon updatePersoon(String naam,String achternaam,int leeftijd) {
		Persoon dezePersoon = geefPersoonMetNaam(naam);
		if (dezePersoon != null) {
			personenlijst.remove(dezePersoon);
			personenlijst.add(new Persoon(naam, achternaam, leeftijd));
		}
		return dezePersoon;
	}
}
