package webshop.persistency.dao;

import java.sql.SQLException;
import java.util.List;

import webshop.domain.Bestelling;
import webshop.domain.Bestellingsregel;

public interface BestellingsregelDao {
	
	List<Bestellingsregel> geefAlleBestellingsregels() throws SQLException;
	void geefMijnBestellingsregels(Bestelling best) throws SQLException;

}
