package webshop.persistency.daoImplementatie;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import webshop.domain.Aanbieding;
import webshop.persistency.Tooldatabase;
import webshop.persistency.dao.AanbiedingDao;

public class AanbiedingDaoOracleImplementatie extends Tooldatabase implements AanbiedingDao {

	public List<Aanbieding> geefAlleAanbiedingen() throws SQLException {
		List<Aanbieding> mijnAanbiedingen = new ArrayList<Aanbieding>();
		Connection con = super.getConnection();
		Statement st= con.createStatement();
		ResultSet rsAanbieding=st.executeQuery("select * from Aanbieding");
		while(rsAanbieding.next()) {
			mijnAanbiedingen.add(new Aanbieding(rsAanbieding.getInt(1), rsAanbieding.getDate(2), rsAanbieding.getDate(3), rsAanbieding.getInt(5)));
		}
		rsAanbieding.close();
		con.close();
		return mijnAanbiedingen;
	}

	public Aanbieding geefMijnAanbiedingen(int id) throws SQLException {
		Aanbieding mijnAanbieding = null;
		Connection con = super.getConnection();
		Statement st= con.createStatement();
		ResultSet rsAanbieding=st.executeQuery("select * from Aanbieding where AANBIEDINGID = '" + id +"'");
		while(rsAanbieding.next()) {
			mijnAanbieding = new Aanbieding(rsAanbieding.getInt(1), rsAanbieding.getDate(2), rsAanbieding.getDate(3), rsAanbieding.getInt(5));
		}
		rsAanbieding.close();
		con.close();
		return mijnAanbieding;
	}

}
