package webshop.persistency.daoImplementatie;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import webshop.domain.Bestelling;
import webshop.persistency.Tooldatabase;
import webshop.persistency.dao.BestellingDao;

public class BestellingDaoOracleImplementatie extends Tooldatabase implements BestellingDao {

	public List<Bestelling> geefAlleBestellingen() throws SQLException {
		List<Bestelling> mijnBestellingen = new ArrayList<Bestelling>();
		Connection con = super.getConnection();
		Statement st= con.createStatement();
		ResultSet rsBestelling=st.executeQuery("select * from Bestelling");
		while(rsBestelling.next()) {
			mijnBestellingen.add(new Bestelling(rsBestelling.getInt(1), rsBestelling.getString(2)));
		}
		rsBestelling.close();
		con.close();
		return mijnBestellingen;
	}

	public Bestelling geefMijnBestelling(int id) throws SQLException {
		Bestelling mijnBestelling = null;
		Connection con = super.getConnection();
		Statement st= con.createStatement();
		ResultSet rsBestelling=st.executeQuery("select * from Bestelling where BESTELLINGID = '" + id +"'");
		while(rsBestelling.next()) {
			mijnBestelling = new Bestelling(rsBestelling.getInt(1), rsBestelling.getString(2));
		}
		rsBestelling.close();
		con.close();
		return mijnBestelling;
	}
	
	public Boolean addBestelling(int accountID, int adresID) throws SQLException {
        boolean waarheid = false;
        Connection con = super.getConnection();
        Statement st = con.createStatement();
        ResultSet rsProduct = st.executeQuery(
                "insert into bestelling (AFLEVERADRESID, ACCOUNTID ) values (1, 1)");
        waarheid = true;
        rsProduct.close();
        con.close();
        waarheid = true;
        return waarheid;
    }

}
