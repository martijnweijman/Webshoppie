package webshop.persistency.daoImplementatie;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import webshop.domain.Adres;
import webshop.persistency.Tooldatabase;
import webshop.persistency.dao.AdresDao;

public class AdresDaoOracleImplementatie extends Tooldatabase implements AdresDao {

	public List<Adres> geefAlleAdressen() throws SQLException {
		List<Adres> mijnAdres = new ArrayList<Adres>();
		Connection con = super.getConnection();
		Statement st= con.createStatement();
		ResultSet rsAdres=st.executeQuery("select * from Adres");
		while(rsAdres.next()) {
			mijnAdres.add(new Adres(rsAdres.getInt(1), rsAdres.getString(2), rsAdres.getInt(3)));
		}
		rsAdres.close();
		con.close();
		return mijnAdres;
	}

	public Adres geefMijnAdres(int id) throws SQLException {
		Adres mijnAdres = null;
		Connection con = super.getConnection();
		Statement st= con.createStatement();
		ResultSet rsAdres=st.executeQuery("select * from Adres where id = '" + id +"'");
		while(rsAdres.next()) {
			mijnAdres = new Adres(rsAdres.getInt(1), rsAdres.getString(2), rsAdres.getInt(3));
		}
		rsAdres.close();
		con.close();
		return mijnAdres;
	}

}
