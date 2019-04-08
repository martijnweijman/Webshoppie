package com.jersey;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.json.JsonValue;
import javax.ws.rs.Consumes;
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
import webshop.persistency.dao.CategoryDao;
import webshop.persistency.dao.ProductDao;
import webshop.persistency.daoImplementatie.AanbiedingDaoOracleImplementatie;
import webshop.persistency.daoImplementatie.CategoryDaoOracleImplementatie;
import webshop.persistency.daoImplementatie.ProductDaoOracleImplementatie;

@Path("msg")
public class OpvangResource {

	ProductDao PDao = new ProductDaoOracleImplementatie();
	AanbiedingDao ADao = new AanbiedingDaoOracleImplementatie();

	@GET
	@Produces("application/json")
	@Path("/{param}")
	public Response getMsg(@PathParam("param") int msg) throws SQLException {

		JsonArrayBuilder jab = Json.createArrayBuilder();
		ProductDao prdD = new ProductDaoOracleImplementatie();
		for (Product p : prdD.geefAlleProducten()) {
			if (p.getProductID() == msg) {
				System.out.println("naam:" + p.getProductNaam() + "  categorie:" + p.getMijnCategory());
				JsonObjectBuilder job = Json.createObjectBuilder();
				job.add("id", p.getProductID());
				job.add("naam", p.getProductNaam());
				job.add("artiest", p.getArtiest());
				job.add("prijs", p.getProductPrijs());
				job.add("categorie", p.getMijnCategory());
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
			job.add("categorie", p.getMijnCategory());
			job.add("uitgavejaar", p.getUitgavejaar());
			job.add("beschrijving", p.getProductBeschrijving());
//			job.add("cover", p.getCover());
//			job.add("aanbieding", p.getMijnAanbieding());
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
		PDao.deleteProduct(id);
		return Response.ok().build();

	}

//	Posten van product
	@POST
	@RolesAllowed("admin")
	@Produces("application/json")
	public Response addProduct(@FormParam("id") int id, @FormParam("naam") String naam,
			@FormParam("artiest") String artiest, @FormParam("prijs") double prijs,
			@FormParam("categorie") String categorie, @FormParam("uitgavejaar") int uitgavejaar,
			@FormParam("beschrijving") String beschrijving, @FormParam("cover") String cover) throws SQLException {

		Boolean product = PDao.addProduct(id, naam, artiest, prijs, categorie, uitgavejaar, beschrijving, cover);
		return Response.ok().build();
	}

//	Updaten van product
	@PUT
	@RolesAllowed("admin")
	@Path("{id}")
	@Produces("application/json")
	public Response updateProduct(@FormParam("id") int id, @FormParam("naam") String naam,
			@FormParam("artiest") String artiest, @FormParam("prijs") double prijs,
			@FormParam("categorie") String categorie, @FormParam("uitgavejaar") int uitgavejaar,
			@FormParam("beschrijving") String beschrijving, @FormParam("cover") String cover) throws SQLException {
		PDao.updateProduct(id, naam, artiest, prijs, categorie, uitgavejaar, beschrijving, cover);
		return Response.ok().build();
	}

//	Getten van alle categorien
	@GET
	@Produces("application/json")
	@Path("/categorien")
	public Response getAllCategorien() throws SQLException {

		JsonArrayBuilder jab = Json.createArrayBuilder();
		CategoryDao ctgD = new CategoryDaoOracleImplementatie();
		for (Category c : ctgD.geefAlleCategorien()) {
			System.out.println(c.getNaam());
			JsonObjectBuilder job = Json.createObjectBuilder();
			job.add("naam", c.getNaam());
			jab.add(job);
		}
		JsonArray array = jab.build();
		return Response.status(200).entity(array.toString()).build();
	}

//	Getten van specifieke categorie
	@GET
	@Produces("application/json")
	@Path("/categorien/{param}")
	public Response getCategorie(@PathParam("param") String msg) throws SQLException {

		JsonArrayBuilder jab = Json.createArrayBuilder();
		CategoryDao ctgD = new CategoryDaoOracleImplementatie();
		List<Product> CPL = PDao.geefAlleProductenMetCategorie(msg);
		for (Product p : CPL) {
			JsonObjectBuilder job = Json.createObjectBuilder();
			job.add("id", p.getProductID());
			job.add("naam", p.getProductNaam());
			job.add("artiest", p.getArtiest());
			job.add("prijs", p.getProductPrijs());
			job.add("categorie", p.getMijnCategory());
			job.add("uitgavejaar", p.getUitgavejaar());
			job.add("beschrijving", p.getProductBeschrijving());
//			job.add("cover", p.getCover());
//			job.add("aanbieding", p.getMijnAanbieding());
			jab.add(job);
		}

		JsonArray array = jab.build();
		return Response.status(200).entity(array.toString()).build();
	}

//	Getten van alle aanbiedingen
	@GET
	@Produces("application/json")
	@Path("aanbiedingen")
	public Response getAanbiedingen() throws SQLException {

		JsonArrayBuilder jab = Json.createArrayBuilder();
		AanbiedingDao aanD = new AanbiedingDaoOracleImplementatie();
		for (Aanbieding a : aanD.geefAlleAanbiedingen()) {

			JsonObjectBuilder job = Json.createObjectBuilder();
			job.add("aanbiedingid", a.getId());
			job.add("startdatum", a.getVanDatum().toString());
			job.add("einddatum", a.getTotDatum().toString());
			job.add("productid", a.getMijnProduct());
			job.add("kortingspercentage", a.getKortingsPercentage());
			jab.add(job);
		}

		JsonArray array = jab.build();
		return Response.status(200).entity(array.toString()).build();
	}

//	Getten van specifieke aanbieding
	@GET
	@Produces("application/json")
	@Path("/aanbiedingen/{param}")
	public Response getAanbieding(@PathParam("param") int msg) throws SQLException {

		Product p = PDao.geefEenProduct(msg);
		JsonArrayBuilder jab = Json.createArrayBuilder();
		Aanbieding a = ADao.geefMijnAanbiedingen(msg);
		if (a.getId() == msg) {
			JsonObjectBuilder job = Json.createObjectBuilder();
			job.add("aanbiedingid", a.getId());
			job.add("startdatum", a.getVanDatum().toString());
			job.add("einddatum", a.getTotDatum().toString());
			job.add("productid", a.getMijnProduct());
			job.add("kortingspercentage", a.getKortingsPercentage());
			jab.add(job);
		}

		JsonArray array = jab.build();
		return Response.status(200).entity(array.toString()).build();
	}

//	Getten van alle producten in de aanbieding
	@GET
	@Produces("application/json")
	@Path("aanbiedingen/producten")
	public Response getProductAanbiedingen() throws SQLException {

		ProductDao prdD = new ProductDaoOracleImplementatie();
		AanbiedingDao aanD = new AanbiedingDaoOracleImplementatie();
		JsonArrayBuilder jab = Json.createArrayBuilder();
		for (Aanbieding a : aanD.geefAlleAanbiedingen()) {
			for (Product p : prdD.geefAlleProducten()) {
				if (p.getProductID() == a.getMijnProduct()) {
					System.out.println("naam:" + p.getProductNaam() + "  categorie:" + p.getMijnCategory() + "  korting:" + a.getKortingsPercentage());
					JsonObjectBuilder job = Json.createObjectBuilder();
					job.add("id", p.getProductID());
					job.add("naam", p.getProductNaam());
					job.add("artiest", p.getArtiest());
					job.add("prijs", p.getProductPrijs());
					job.add("categorie", p.getMijnCategory());
					job.add("uitgavejaar", p.getUitgavejaar());
					job.add("beschrijving", p.getProductBeschrijving());
//					job.add("cover", p.getCover());
//					job.add("aanbieding", p.getMijnAanbieding());
					job.add("kortingspercentage", a.getKortingsPercentage());
					jab.add(job);
				}
			}
		}

		JsonArray array = jab.build();
		return Response.status(200).entity(array.toString()).build();
	}

//	Posten van bestelling
//	@POST
//	@RolesAllowed("klant")
//	@Produces("application/json")
//	@Consumes("application/json")
//	public Response addBestelling(@FormParam("id") int id, @FormParam("naam") String naam,
//			@FormParam("artiest") String artiest, @FormParam("prijs") double prijs,
//			@FormParam("categorie") String categorie, @FormParam("uitgavejaar") int uitgavejaar,
//			@FormParam("beschrijving") String beschrijving, @FormParam("cover") String cover) throws SQLException {
//
//		Boolean product = PDao.addProduct(id, naam, artiest, prijs, categorie, uitgavejaar, beschrijving, cover);
//		return Response.ok().build();
//	}
}
