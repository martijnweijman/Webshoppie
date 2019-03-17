package webshop.persistency;

import java.sql.SQLException;

import webshop.persistency.dao.AdresDao;
import webshop.persistency.daoImplementatie.AdresDaoOracleImplementatie;

public class Main {

    public static void main(String[] args) {
        AdresDao dao = new AdresDaoOracleImplementatie();
        try {
            System.out.println(dao.geefMijnAdres(1).getStraat());
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}