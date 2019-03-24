package webshop.persistency.dao;
import java.sql.SQLException;
import java.util.List;

import webshop.domain.Aanbieding;
import webshop.domain.Product;

public interface AanbiedingDao  {
	List<Aanbieding> geefAlleAanbiedingen() throws SQLException;
	Aanbieding geefMijnAanbiedingen(Product p) throws SQLException;

}
