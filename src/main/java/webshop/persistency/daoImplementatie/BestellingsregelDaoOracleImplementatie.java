package webshop.persistency.daoImplementatie;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import webshop.domain.Bestelling;
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

	public void geefMijnBestellingsregels(Bestelling best) throws SQLException {
		Connection con = super.getConnection();
		Statement st= con.createStatement();
		ResultSet rsBestellingsregel=st.executeQuery("select * from Bestellingsregel where BESTELLINGID = '" + best.getId() +"'");
		while(rsBestellingsregel.next()) {
			best.setMijnBestellingsregels(new Bestellingsregel(rsBestellingsregel.getInt(1), rsBestellingsregel.getInt(3), rsBestellingsregel.getInt(4)));
		}
		rsBestellingsregel.close();
		con.close();
	}
	
	public void voegBestelregelToe(Bestellingsregel br) throws SQLException{
		Connection con = super.getConnection();
		Statement st= con.createStatement();
		ResultSet rsBestelling=st.executeQuery("insert into bestellingregel values("+br.getMijnBestelling().getId()+","+br.getMijnProduct().getProductID()+"," +br.getAantal()+","+ br.getPrijs()+",BESTELLINGREGEL_SEQ.NEXTVAL)");
		rsBestelling.close();
		con.close();
	}

}
