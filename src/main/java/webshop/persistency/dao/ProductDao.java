package webshop.persistency.dao;

import java.sql.SQLException;
import java.util.List;

import webshop.domain.Aanbieding;
import webshop.domain.Category;
import webshop.domain.Product;

public interface ProductDao {
	
	List<Product> geefAlleProducten() throws SQLException;
	Product geefEenProduct(int id) throws SQLException;
	boolean deleteProduct(int id) throws SQLException;
	boolean addProduct(int id, String naam, String artiest, double prijs, String categorie, int uitgavejaar,
			String beschrijving, String cover, double aanbieding) throws SQLException;
	boolean updateProduct(int id, String naam, String artiest, double prijs, String categorie, int uitgavejaar,
			String beschrijving, String cover, double aanbieding) throws SQLException;
	List<Product> geefAlleProductenMetCategorie(String categorie) throws SQLException;

}
