package webshop.persistency.daoImplementatie;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import webshop.domain.Klant;
import webshop.persistency.Tooldatabase;
import webshop.persistency.dao.KlantDao;

public class KlantDaoOracleImplementatie extends Tooldatabase implements KlantDao {

	public List<Klant> geefAlleKlanten() throws SQLException {
		List<Klant> mijnKlant = new ArrayList<Klant>();
		Connection con = super.getConnection();
		Statement st= con.createStatement();
		ResultSet rsKlant=st.executeQuery("select * from Klant");
		while(rsKlant.next()) {
			mijnKlant.add(new Klant(rsKlant.getInt(4), rsKlant.getString(1), rsKlant.getString(2)));
		}
		rsKlant.close();
		con.close();
		return mijnKlant;
	}

	public Klant geefEenKlant(String naam, String adres) throws SQLException {
		Klant mijnKlant = null;
		Connection con = super.getConnection();
		Statement st= con.createStatement();
		ResultSet rsKlant=st.executeQuery("select * from Klant where naam = '" + naam +"' and adres = '" + adres + "'");
		while(rsKlant.next()) {
			mijnKlant = new Klant(rsKlant.getInt(4), rsKlant.getString(1), rsKlant.getString(2));
		}
		rsKlant.close();
		con.close();
		return mijnKlant;
	}

}
