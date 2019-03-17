package webshop.persistency.dao;

import java.sql.SQLException;
import java.util.List;

import webshop.domain.Category;

public interface CategoryDao {
	
	List<Category> geefAlleCategoriën() throws SQLException;
	Category geefMijnCategory(String naam) throws SQLException;

}
