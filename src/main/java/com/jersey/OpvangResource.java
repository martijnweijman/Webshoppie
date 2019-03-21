package com.jersey;

import java.sql.SQLException;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.artikel.ArtikelService;

import com.artikel.ServiceProvider;

import webshop.domain.Product;
import webshop.persistency.dao.ProductDao;
import webshop.persistency.daoImplementatie.ProductDaoOracleImplementatie;

@Path("msg")
public class OpvangResource {

	@GET
	@Produces("application/json")
	@Path("/{param}")
	public Response getMsg(@PathParam("param") int msg) throws SQLException {

		JsonArrayBuilder jab = Json.createArrayBuilder();
		ProductDao prdD = new ProductDaoOracleImplementatie();
		for (Product p : prdD.geefAlleProducten()) {
			if (p.getProductID() == msg) {
				System.out.println(p.getProductNaam());
				JsonObjectBuilder job = Json.createObjectBuilder();
				job.add("id", p.getProductID());
				job.add("naam", p.getProductNaam());
				job.add("artiest", p.getArtiest());
				job.add("prijs", p.getProductPrijs());
//				job.add("categorie", p.getMijnCategory().getNaam());
				job.add("uitgavejaar", p.getUitgavejaar());
				job.add("beschrijving", p.getProductBeschrijving());
//				job.add("cover", p.getCover());
//				job.add("aanbieding", p.getMijnAanbieding());
				jab.add(job);
			}
			break;
		}
		JsonArray array = jab.build();
		return Response.status(200).entity(array.toString()).build();
	}
	
	@GET
	@Produces("application/json")
	@Path("/producten")
	public Response getAll() throws SQLException {

		JsonArrayBuilder jab = Json.createArrayBuilder();
		ProductDao prdD = new ProductDaoOracleImplementatie();
		for (Product p : prdD.geefAlleProducten()) {
				System.out.println(p.getProductNaam());
				JsonObjectBuilder job = Json.createObjectBuilder();
				job.add("id", p.getProductID());
				job.add("naam", p.getProductNaam());
				job.add("artiest", p.getArtiest());
				job.add("prijs", p.getProductPrijs());
//				job.add("categorie", p.getMijnCategory().getNaam());
				job.add("uitgavejaar", p.getUitgavejaar());
				job.add("beschrijving", p.getProductBeschrijving());
//				job.add("cover", p.getCover());
//				job.add("aanbieding", p.getMijnAanbieding());
				jab.add(job);
		}
		JsonArray array = jab.build();
		return Response.status(200).entity(array.toString()).build();
	}

}
