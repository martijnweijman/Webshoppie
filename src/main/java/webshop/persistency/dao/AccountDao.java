package webshop.persistency.dao;
import java.sql.SQLException;
import java.util.List;

import webshop.domain.Account;

public interface AccountDao {
	List<Account> geefAlleAccounts() throws SQLException;
	Account geefMijnAccount(int id) throws SQLException;

}
