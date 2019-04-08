package webshop.persistency.daoImplementatie;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import webshop.domain.Aanbieding;
import webshop.domain.Category;
import webshop.domain.Product;
import webshop.persistency.Tooldatabase;
import webshop.persistency.dao.ProductDao;

public class ProductDaoOracleImplementatie extends Tooldatabase implements ProductDao {

	public List<Product> geefAlleProducten() throws SQLException {
		List<Product> mijnProduct = new ArrayList<Product>();
		Connection con = super.getConnection();
		Statement st = con.createStatement();
		ResultSet rsProduct = st.executeQuery("select * from Product");
		while (rsProduct.next()) {
			mijnProduct.add(new Product(rsProduct.getInt(1), rsProduct.getString(2), rsProduct.getString(5),
					rsProduct.getString(7), rsProduct.getInt(8), rsProduct.getString(6), rsProduct.getInt(3)));
		}
		rsProduct.close();
		con.close();
		return mijnProduct;
	}

	public Product geefEenProduct(int id) throws SQLException {
		Product mijnProduct = null;
		Connection con = super.getConnection();
		Statement st = con.createStatement();
		ResultSet rsProduct = st.executeQuery("select * from Product where PRODUCTID = '" + id + "'");
		while (rsProduct.next()) {
			mijnProduct = new Product(rsProduct.getInt(1), rsProduct.getString(2), rsProduct.getString(5),
					rsProduct.getString(7), rsProduct.getInt(8), rsProduct.getString(6), rsProduct.getInt(3));
		}
		rsProduct.close();
		con.close();
		return mijnProduct;
	}

	public boolean deleteProduct(int id) throws SQLException {
		boolean waarheid = false;
		Product ditProduct = geefEenProduct(id);
		if (ditProduct != null) {
			Connection con = super.getConnection();
			Statement st = con.createStatement();
			ResultSet rsProduct = st.executeQuery("delete from Product where PRODUCTID = '" + ditProduct + "'");
			waarheid = true;
			rsProduct.close();
			con.close();
		}
		return waarheid;
	}

	public boolean addProduct(int id, String naam, String artiest, double prijs, String categorie, int uitgavejaar,
			String beschrijving, String cover) throws SQLException {
		boolean waarheid = false;
		Connection con = super.getConnection();
		Statement st = con.createStatement();
		ResultSet rsProduct = st.executeQuery(
				"insert into product (productid, albumnaam, prijs, categorie, artiest, beschrijving, cover, uitgavejaar, aanbieding) values ("
						+ "PRODUCT_SEQ.nextval" + ", '" + naam + "', " + prijs + ", '" + categorie + "', '" + artiest + "', '" + beschrijving
						+ "', '" + cover + "', " + uitgavejaar + ", " + aanbieding + ");");
		waarheid = true;
		rsProduct.close();
		con.close();
		waarheid = true;
		return waarheid;
	}

	public boolean updateProduct(int id, String naam, String artiest, double prijs, String categorie, int uitgavejaar,
			String beschrijving, String cover) throws SQLException {
		boolean waarheid = false;
		Product ditProduct = geefEenProduct(id);
		if (ditProduct != null) {
			Connection con = super.getConnection();
			Statement st = con.createStatement();
			ResultSet rsProduct = st.executeQuery("update product set albumnaam = '" + naam + "', prijs = " + prijs
					+ ", categorie = '" + categorie + "', artiest = '" + artiest + "', beschrijvivng = '" + beschrijving
					+ "', cover = '" + cover + "', uitgavejaar = " + uitgavejaar + ", aanbieding = " + aanbieding
					+ " where productid = " + id + ";");
			waarheid = true;
			rsProduct.close();
			con.close();
			waarheid = true;
		}
		return waarheid;
	}

}
