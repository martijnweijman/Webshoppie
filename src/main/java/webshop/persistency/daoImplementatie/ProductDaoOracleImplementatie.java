package webshop.persistency.daoImplementatie;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import webshop.domain.Product;
import webshop.persistency.Tooldatabase;
import webshop.persistency.dao.ProductDao;

public class ProductDaoOracleImplementatie extends Tooldatabase implements ProductDao {

	public List<Product> geefAlleProducten() throws SQLException {
		List<Product> mijnProduct = new ArrayList<Product>();
		Connection con = super.getConnection();
		Statement st= con.createStatement();
		ResultSet rsProduct=st.executeQuery("select * from Product");
		while(rsProduct.next()) {
			mijnProduct.add(new Product(rsProduct.getInt(1), rsProduct.getString(2), rsProduct.getString(5), rsProduct.getString(7), rsProduct.getInt(8), rsProduct.getString(6),rsProduct.getInt(3)));
		}
		rsProduct.close();
		con.close();
		return mijnProduct;
	}

	public Product geefEenProduct(int id) throws SQLException {
		Product mijnProduct = null;
		Connection con = super.getConnection();
		Statement st= con.createStatement();
		ResultSet rsProduct=st.executeQuery("select * from Product where PRODUCTID = '" + id +"'");
		while(rsProduct.next()) {
			mijnProduct = new Product(rsProduct.getInt(1), rsProduct.getString(2), rsProduct.getString(5), rsProduct.getString(7), rsProduct.getInt(8), rsProduct.getString(6),rsProduct.getInt(3));
		}
		rsProduct.close();
		con.close();
		return mijnProduct;
	}

}
