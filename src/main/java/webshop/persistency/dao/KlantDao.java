package webshop.persistency.dao;

import java.sql.SQLException;
import java.util.List;

import webshop.domain.Klant;

public interface KlantDao {
	
	List<Klant> geefAlleKlanten() throws SQLException;
	Klant geefEenKlant(String naam, String adres) throws SQLException;

}
