package webshop.persistency.daoImplementatie;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import webshop.domain.Category;
import webshop.persistency.Tooldatabase;
import webshop.persistency.dao.CategoryDao;

public class CategoryDaoOracleImplementatie extends Tooldatabase implements CategoryDao {

	public List<Category> geefAlleCategorien() throws SQLException {
		List<Category> mijnCategory = new ArrayList<Category>();
		Connection con = super.getConnection();
		Statement st= con.createStatement();
		ResultSet rsCategory=st.executeQuery("select * from categorie");
		while(rsCategory.next()) {
			mijnCategory.add(new Category(rsCategory.getString(1)));
		}
		rsCategory.close();
		con.close();
		return mijnCategory;
	}

	public Category geefMijnCategory(String naam) throws SQLException {
		Category mijnCategory = null;
		Connection con = super.getConnection();
		Statement st= con.createStatement();
		ResultSet rsCategory=st.executeQuery("select * from Category where naam = '" + naam +"'");
		while(rsCategory.next()) {
			mijnCategory = new Category(rsCategory.getString(1));
		}
		rsCategory.close();
		con.close();
		return mijnCategory;
	}

}
