//package com.artikel;
//
//import java.util.Map;
//
//import javax.json.*;
//import javax.ws.rs.*;
//import javax.ws.rs.core.Response;
//
//import javax.ws.rs.GET;
//import javax.ws.rs.Path;
//import javax.ws.rs.PathParam;
//import javax.ws.rs.Produces;
//import javax.ws.rs.core.Response;
//
//@Path("/artikelen")
//public class ArtikelResource {
//	ArtikelService service = ServiceProvider.getArtikelService();
//
//	@GET
//	@Produces("application/json")
//	public String geefArtikelen() {
//		ArtikelService service = ServiceProvider.getArtikelService();
//		JsonArrayBuilder jab = Json.createArrayBuilder();
//
//		for (Artikel a : service.geefAlleArtikelen()) {
//			JsonObjectBuilder job = Json.createObjectBuilder();
//			job.add("id", a.getId());
//			job.add("naam", a.getNaam());
//			job.add("artiest", a.getArtiest());
//			job.add("prijs", a.getPrijs());
//			job.add("categorie", a.getCategorie());
//			job.add("uitgavejaar", a.getUitgavejaar());
//			job.add("beschrijving", a.getBeschrijving());
//			job.add("cover", a.getCover());
//			jab.add(job);
//		}
//		JsonArray array = jab.build();
//		return array.toString();
//	}
//
//	// Dit comment stuk zou moeten zijn voor de get doorpushen naar een andere
//	// pagina
//	// Pom en Web xml nog niet aangepast though, nog aan het testen
//
//	@GET
//	@Produces("application/json")
//	@Path("/jersey/{parmam}")
//	public Response getMsg(@PathParam("param") String msg) {
////		ArtikelService service = ServiceProvider.getArtikelService();
////		return Response.status(200).entity(service.geefArtikelMetId(msg)).build();
//
//		System.out.println("hier");
//		String output = "Jersey say : " + msg;
//		return Response.status(200).entity(output).build();
//	}
//
//	@DELETE
//	@Produces("application/json")
//	public Response deleteArtikel(@FormParam("id") int id, @FormParam("naam") String naam,
//			@FormParam("artiest") String artiest, @FormParam("prijs") double prijs,
//			@FormParam("categorie") String categorie, @FormParam("uitgavejaar") int uitgavejaar,
//			@FormParam("beschrijving") String beschrijving, @FormParam("cover") String cover) {
//		if (!service.deleteArtikel(id)) {
//			return Response.status(404).build();
//		} else {
//			return null;
//		}
//	}
//
//	@POST
//	@Produces("application/json")
//	public Response addArtikel(@FormParam("id") int id, @FormParam("naam") String naam,
//			@FormParam("artiest") String artiest, @FormParam("prijs") double prijs,
//			@FormParam("categorie") String categorie, @FormParam("uitgavejaar") int uitgavejaar,
//			@FormParam("beschrijving") String beschrijving, @FormParam("cover") String cover) {
//		service.addArtikel(id, naam, artiest, prijs, categorie, uitgavejaar, beschrijving, cover);
//		return Response.ok().build();
//	}
//
//	@PUT
//	@Produces("application/json")
//	public Response updateArtikel(@FormParam("id") int id, @FormParam("naam") String naam,
//			@FormParam("artiest") String artiest, @FormParam("prijs") double prijs,
//			@FormParam("categorie") String categorie, @FormParam("uitgavejaar") int uitgavejaar,
//			@FormParam("beschrijving") String beschrijving, @FormParam("cover") String cover) {
//		service.updateArtikel(id, naam, artiest, prijs, categorie, uitgavejaar, beschrijving, cover);
//		return Response.ok().build();
//	}
//
//}