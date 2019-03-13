package webshop.persistency.dao;

import java.sql.SQLException;
import java.util.List;

import webshop.domain.Adres;

public interface AdresDao {
	
	List<Adres> geefAlleAdressen() throws SQLException;
	Adres geefMijnAdres(int id) throws SQLException;

}
