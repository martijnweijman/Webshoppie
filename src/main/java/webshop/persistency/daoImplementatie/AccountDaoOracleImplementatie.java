package webshop.persistency.daoImplementatie;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import webshop.domain.Account;
import webshop.persistency.Tooldatabase;
import webshop.persistency.dao.AccountDao;

public class AccountDaoOracleImplementatie extends Tooldatabase implements AccountDao {

	public List<Account> geefAlleAccounts() throws SQLException {
		List<Account> mijnAccounts = new ArrayList<Account>();
		Connection con = super.getConnection();
		Statement st= con.createStatement();
		ResultSet rsAccount=st.executeQuery("select * from Account");
		while(rsAccount.next()) {
			mijnAccounts.add(new Account(rsAccount.getDate(1), rsAccount.getInt(3), rsAccount.getString(4),rsAccount.getString(5),rsAccount.getString(6),rsAccount.getString(7)));
		}
		rsAccount.close();
		con.close();
		return mijnAccounts;
	}

	public Account geefMijnAccount(int id) throws SQLException {
		Account mijnAccount = null;
		Connection con = super.getConnection();
		Statement st= con.createStatement();
		ResultSet rsAccount=st.executeQuery("select * from Account where ACCOUNTID = '" + id +"'");
		while(rsAccount.next()) {
			mijnAccount = new Account(rsAccount.getDate(1), rsAccount.getInt(3), rsAccount.getString(4),rsAccount.getString(5),rsAccount.getString(6),rsAccount.getString(7));
		}
		rsAccount.close();
		con.close();
		return mijnAccount;
	}

}
