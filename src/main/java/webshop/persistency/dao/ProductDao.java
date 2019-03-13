package webshop.persistency.dao;

import java.sql.SQLException;
import java.util.List;
import webshop.domain.Product;

public interface ProductDao {
	
	List<Product> geefAlleProducten() throws SQLException;
	Product geefEenProduct(int id) throws SQLException;

}
