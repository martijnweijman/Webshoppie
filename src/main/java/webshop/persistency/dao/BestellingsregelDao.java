package webshop.persistency.dao;

import java.sql.SQLException;
import java.util.List;
import webshop.domain.Bestellingsregel;

public interface BestellingsregelDao {
	
	List<Bestellingsregel> geefAlleBestellingsregels() throws SQLException;
	Bestellingsregel geefMijnBestellingsregels(int id) throws SQLException;
	Boolean addBestelRegel(int bestellingid, int productid, int aantal, double totaalprijs);

}
