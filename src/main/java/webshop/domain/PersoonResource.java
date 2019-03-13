package webshop.domain;

import java.util.Map;

import javax.json.*;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/personen")
public class PersoonResource {
	PersoonService service = ServiceProvider.getPersoonService();
	//john
	@GET
	@Produces("application/json")
	public String geefPersonen() {
		PersoonService service = ServiceProvider.getPersoonService();
		JsonArrayBuilder jab = Json.createArrayBuilder();

		for (Persoon p : service.geefAllePersonen()) {
			JsonObjectBuilder job = Json.createObjectBuilder();
			job.add("voornaam", p.getVoornaam());
			job.add("achternaam", p.getAchternaam());
			job.add("leeftijd", p.getLeeftijd());
			jab.add(job);
		}
		JsonArray array = jab.build();
		return array.toString();
	}
	
	@DELETE
	@Produces("application/json")
	public Response deletePersoon(@FormParam("firstname") String voornaam,
			@FormParam("lastname") String achternaam,
			@FormParam("age") int leeftijd) {
		if (!service.deletePersoon(voornaam)) {
			return Response.status(404).build();
		} else {
			return null;
		}
		
		
	}
	
	@POST
	@Produces("application/json")
	public Response addPersoon(@FormParam("firstname") String voornaam,
								@FormParam("lastname") String achternaam,
								@FormParam("age") int leeftijd){
			service.addPersoon(voornaam, achternaam, leeftijd);
			return Response.ok().build();
	}
	
	@PUT
	@Produces("application/json")
	public Response updatePersoon(@FormParam("firstname") String voornaam,
								@FormParam("lastname") String achternaam,
								@FormParam("age") int leeftijd){
		
			service.updatePersoon(voornaam, achternaam, leeftijd);
			return Response.ok().build();
	}
}