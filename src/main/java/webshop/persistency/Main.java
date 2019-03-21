package webshop.persistency;

import java.sql.SQLException;

import webshop.domain.Product;
import webshop.persistency.dao.AdresDao;
import webshop.persistency.dao.ProductDao;
import webshop.persistency.daoImplementatie.AdresDaoOracleImplementatie;
import webshop.persistency.daoImplementatie.ProductDaoOracleImplementatie;

public class Main {

    public static void main(String[] args) {
    	ProductDao prdD = new ProductDaoOracleImplementatie();
        try {
        	for (Product p : prdD.geefAlleProducten()) {
        		System.out.println(p.getProductNaam());
        		System.out.println(p.getArtiest());
        		System.out.println(p.getCover());
        		System.out.println(p.getProductBeschrijving());
        		System.out.println(p.getProductID());
        		System.out.println(p.getProductPrijs());
        		System.out.println(p.getUitgavejaar());
        	}
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}