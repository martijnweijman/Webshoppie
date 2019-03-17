package com.jersey;

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

import com.artikel.Artikel;
import com.artikel.ServiceProvider;

@Path("msg")
public class OpvangResource {

	@GET
	@Produces("application/json")
	@Path("/jersey/{param}")
	public Response getMsg(@PathParam("param") int msg) {
		
//		ArtikelService service = ServiceProvider.getArtikelService();
//		JsonArrayBuilder jab = Json.createArrayBuilder();
//		for (Artikel a : service.geefAlleArtikelen()) {
//			if (a.getId() == msg) {
//				JsonObjectBuilder job = Json.createObjectBuilder();
//				job.add("id", a.getId());
//				job.add("naam", a.getNaam());
//				job.add("artiest", a.getArtiest());
//				job.add("prijs", a.getPrijs());
//				job.add("categorie", a.getCategorie());
//				job.add("uitgavejaar", a.getUitgavejaar());
//				job.add("beschrijving", a.getBeschrijving());
//				job.add("cover", a.getCover());
//				jab.add(job);
//			} break;
//		}
		
		JsonArrayBuilder jab = Json.createArrayBuilder();
		JsonArray array = jab.build();
		
		return Response.status(200).entity(array.toString()).build();

	}

}
