package webshop.persistency.dao;

import java.sql.SQLException;
import java.util.List;

import webshop.domain.Bestelling;

public interface BestellingDao {
	
	List<Bestelling> geefAlleBestellingen() throws SQLException;
	Bestelling geefMijnBestelling(int id) throws SQLException;
	Boolean addBestelling(int afleveradres, int accountid) throws SQLException;

}
