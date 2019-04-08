package webshop.persistency.daoImplementatie;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import webshop.domain.Bestellingsregel;
import webshop.persistency.Tooldatabase;
import webshop.persistency.dao.BestellingsregelDao;

public class BestellingsregelDaoOracleImplementatie extends Tooldatabase implements BestellingsregelDao {

	public List<Bestellingsregel> geefAlleBestellingsregels() throws SQLException {
		List<Bestellingsregel> mijnBestellingsregels = new ArrayList<Bestellingsregel>();
		Connection con = super.getConnection();
		Statement st= con.createStatement();
		ResultSet rsBestellingsregel=st.executeQuery("select * from Bestellingsregel");
		while(rsBestellingsregel.next()) {
			mijnBestellingsregels.add(new Bestellingsregel(rsBestellingsregel.getInt(1), rsBestellingsregel.getInt(3), rsBestellingsregel.getInt(4)));
		}
		rsBestellingsregel.close();
		con.close();
		return mijnBestellingsregels;
	}

	public Bestellingsregel geefMijnBestellingsregels(int id) throws SQLException {
		Bestellingsregel mijnBestellingsregel = null;
		Connection con = super.getConnection();
		Statement st= con.createStatement();
		ResultSet rsBestellingsregel=st.executeQuery("select * from Bestellingsregel where REGELID = '" + id +"'");
		while(rsBestellingsregel.next()) {
			mijnBestellingsregel = new Bestellingsregel(rsBestellingsregel.getInt(1), rsBestellingsregel.getInt(3), rsBestellingsregel.getInt(4));
		}
		rsBestellingsregel.close();
		con.close();
		return mijnBestellingsregel;
	}

}
