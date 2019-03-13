package webshop.persistency.dao;
import java.sql.SQLException;
import java.util.List;

import webshop.domain.Aanbieding;

public interface AanbiedingDao  {
	List<Aanbieding> geefAlleAanbiedingen() throws SQLException;
	Aanbieding geefMijnAanbiedingen(int id) throws SQLException;

}
