package com.webservices;

import java.security.Key;
import java.sql.SQLException;
import java.util.AbstractMap.SimpleEntry;
import java.util.Calendar;

import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;
import webshop.persistency.dao.AccountDao;
import webshop.persistency.daoImplementatie.AccountDaoOracleImplementatie;

@Path("/authentication")
@Produces("application/json")
public class AuthenticationResource {
	final static public Key key = MacProvider.generateKey();

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response authenticateUser(@FormParam("username") String username, @FormParam("password") String password)
			throws SQLException {
		try {
			// Waarmerk de gebruiker tegenover de database
			AccountDao dao = new AccountDaoOracleImplementatie();
			String role = dao.findRoleForAccount(username, password);

			JsonObjectBuilder job = Json.createObjectBuilder();
			JsonArrayBuilder jab = Json.createArrayBuilder();

			if (role == null) {
				throw new IllegalArgumentException("No user found!");
			}

			String token = createToken(username, role);

			SimpleEntry<String, String> JWT = new SimpleEntry<String, String>("JWT", token);
			job.add("role", role);
			job.add("token", token);
			job.add("username", username);
			jab.add(job);
			JsonArray array = jab.build();

			return Response.ok(array.toString()).build();

		} catch (JwtException | IllegalArgumentException e) {
			return Response.status(Response.Status.UNAUTHORIZED).build();
		}
	}

	// Token aanmaken
	private String createToken(String username, String role) throws JwtException {
		Calendar expiration = Calendar.getInstance();
		expiration.add(Calendar.MINUTE, 30);

		return Jwts.builder().setSubject(username).setExpiration(expiration.getTime()).claim("role", role)
				.signWith(SignatureAlgorithm.HS512, key).compact();
	}
}