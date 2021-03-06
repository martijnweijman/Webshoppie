package com.jersey;

import java.sql.SQLException;

import javax.annotation.security.RolesAllowed;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import webshop.domain.Aanbieding;
import webshop.domain.Category;
import webshop.domain.Product;
import webshop.persistency.dao.AanbiedingDao;
import webshop.persistency.dao.ProductDao;
import webshop.persistency.daoImplementatie.AanbiedingDaoOracleImplementatie;
import webshop.persistency.daoImplementatie.ProductDaoOracleImplementatie;

@Path("msg")
public class OpvangResource {

	AanbiedingDao ADao = new AanbiedingDaoOracleImplementatie();
	ProductDao PDao = new ProductDaoOracleImplementatie();

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
				break;
			}
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
//			job.add("categorie", p.getMijnCategory().getNaam());
			job.add("uitgavejaar", p.getUitgavejaar());
			job.add("beschrijving", p.getProductBeschrijving());
//			job.add("cover", p.getCover());
//			job.add("aanbieding", p.getMijnAanbieding());
			jab.add(job);
		}
		JsonArray array = jab.build();
		return Response.status(200).entity(array.toString()).build();
	}

	@GET
	@Produces("application/json")
	@Path("/catagorien")
	public Response getAllcat() throws SQLException {

		JsonArrayBuilder jab = Json.createArrayBuilder();
		CategoryDao cd = new CategoryDaoOracleImplementatie();
		for (Category c : cd.geefAlleCategorien()) {
			JsonObjectBuilder job = Json.createObjectBuilder();
			job.add("Naam", c.getNaam());
			jab.add(job);
		}
		JsonArray array = jab.build();
		return Response.status(200).entity(array.toString()).build();
	}

	@DELETE
	@RolesAllowed("admin")
	@Path("{id}")
	@Produces("application/json")
	public Response deletePersoon(@PathParam("id") int id) throws SQLException {
		if (!PDao.deleteProduct(id)) {
			return Response.status(404).build();
		} else {
			return null;
		}

	}

	@POST
	@RolesAllowed("admin")
	@Produces("application/json")
	public Response addPersoon(@FormParam("id") int id, @FormParam("naam") String naam,
			@FormParam("artiest") String artiest, @FormParam("prijs") double prijs,
			@FormParam("categorie") String categorie, @FormParam("uitgavejaar") int uitgavejaar,
			@FormParam("beschrijving") String beschrijving, @FormParam("cover") String cover,
			@FormParam("aanbieding") double aanbieding) throws SQLException {

		Boolean product = PDao.addProduct(id, naam, artiest, prijs, categorie, uitgavejaar, beschrijving, cover,
				aanbieding);
		return Response.ok().build();
	}

	@PUT
	@RolesAllowed("admin")
	@Path("{id}")
	@Produces("application/json")
	public Response updatePersoon(@FormParam("id") int id, @FormParam("naam") String naam,
			@FormParam("artiest") String artiest, @FormParam("prijs") double prijs,
			@FormParam("categorie") String categorie, @FormParam("uitgavejaar") int uitgavejaar,
			@FormParam("beschrijving") String beschrijving, @FormParam("cover") String cover,
			@FormParam("aanbieding") double aanbieding) throws SQLException {

		PDao.updateProduct(id, naam, artiest, prijs, categorie, uitgavejaar, beschrijving, cover, aanbieding);
		return Response.ok().build();
	}

//  Getten van specifieke aanbieding
  @GET
  @Produces("application/json")
  @Path("/aanbiedingen/{param}")
  public Response getAanbieding(@PathParam("param") int msg) throws SQLException {

      Product p = PDao.geefEenProduct(msg);
      JsonArrayBuilder jab = Json.createArrayBuilder();
      Aanbieding a = ADao.geefMijnAanbiedingen(p);
       if(a.getMijnProduct() == p) {
          JsonObjectBuilder job = Json.createObjectBuilder();
          System.out.println("1");
          job.add("aanbiedingid", a.getId());
          System.out.println("2");
          job.add("startdatum", a.getVanDatum().toString());
          System.out.println("3");
          job.add("einddatum", a.getTotDatum().toString());
          System.out.println("4");
          job.add("productid", p.getProductID());
          System.out.println("5");
          job.add("kortingspercentage", a.getKortingsPercentage());
          job.build();
          jab.add(job);
       }

      JsonArray array = jab.build();
      return Response.status(200).entity(array.toString()).build();
  }

}
