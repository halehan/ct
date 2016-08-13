package com.halehan.ct.service;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.security.PermitAll;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.commons.codec.binary.Base64;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.jose4j.jwk.JsonWebKey;
import org.jose4j.jwk.JsonWebKeySet;
import org.jose4j.jwk.RsaJsonWebKey;
import org.jose4j.jwk.RsaJwkGenerator;
import org.jose4j.jws.AlgorithmIdentifiers;
import org.jose4j.jws.JsonWebSignature;
import org.jose4j.jwt.JwtClaims;
import org.jose4j.jwt.consumer.InvalidJwtException;
import org.jose4j.jwt.consumer.JwtConsumer;
import org.jose4j.jwt.consumer.JwtConsumerBuilder;
import org.jose4j.lang.JoseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.stormpath.sdk.account.Account;
import com.stormpath.sdk.account.AccountList;
import com.stormpath.sdk.application.Application;
import com.stormpath.sdk.authc.AuthenticationRequest;
import com.stormpath.sdk.authc.AuthenticationResult;
import com.stormpath.sdk.authc.UsernamePasswordRequests;
import com.stormpath.sdk.client.Client;
import com.stormpath.sdk.client.Clients;
import com.stormpath.sdk.resource.ResourceException;

@Path("/security")
public class AuthService {
	static Logger logger = LoggerFactory
			.getLogger("com.halehan.ct.service.AuthService");

	static List<JsonWebKey> jwkList = null;

	static {
		logger.info("Inside static initializer...");
		jwkList = new LinkedList<>();
		for (int kid = 1; kid <= 3; kid++) {
			JsonWebKey jwk = null;
			try {
				jwk = RsaJwkGenerator.generateJwk(2048);
				logger.info("PUBLIC KEY (" + kid + "): " + jwk
						.toJson(JsonWebKey.OutputControlLevel.PUBLIC_ONLY));
			} catch (JoseException e) {
				e.printStackTrace();
			}
			jwk.setKeyId(String.valueOf(kid));
			jwkList.add(jwk);
		}
	}

	@POST
	@Path("/login")
	@PermitAll
	public AuthAccessElement flogin(@PathParam("username") String username,
			@PathParam("password") String password) {
		AuthAccessElement accessElement = new AuthAccessElement();
		// AuthAccessElement accessElement = authService.login(loginElement);
		/*
		 * if (accessElement != null) {
		 * request.getSession().setAttribute(AuthAccessElement.PARAM_AUTH_ID,
		 * accessElement.getAuthId()); request.getSession().setAttribute(
		 * AuthAccessElement.PARAM_AUTH_TOKEN, accessElement.getAuthToken()); }
		 */
		return accessElement;
	}

	@Path("/postTest")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response test(@HeaderParam("username") String userName,
			@HeaderParam("password") String password) {

		return Response.status(200).build();
	}

	/*
	 * @Path("/authenticate")
	 * 
	 * @POST
	 * 
	 * @Produces(MediaType.APPLICATION_JSON) public Response
	 * authenticateCredentials(
	 * 
	 * @HeaderParam("username") String username,
	 * 
	 * @HeaderParam("password") String password) throws JsonGenerationException,
	 * JsonMappingException, IOException {
	 */

	@Path("/authenticate")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response authenticateCredentials(@Context HttpHeaders headers)
			throws JsonGenerationException, JsonMappingException, IOException {

		logger.info("Authenticating User Credentials...");

		String authorization = headers.getRequestHeader("Authorization").get(0);

		String username = null;
		String password = null;

		if (authorization != null && authorization.startsWith("Basic")) {
			// Authorization: Basic base64credentials
			String base64Credentials = authorization.substring("Basic".length())
					.trim();
			String credentials = new String(
					Base64.decodeBase64(base64Credentials));
			// credentials = username:password
			final String[] values = credentials.split(":", 2);

			username = values[0];
			password = values[1];
		}

		if (!this.authenticateAccount(username, password)) {
			return Response.status(400).build();
		}

		logger.info("userName = " + username);
		logger.info("password = " + password);

		RsaJsonWebKey senderJwk = (RsaJsonWebKey) jwkList.get(0);

		senderJwk.setKeyId("1");
		logger.info("JWK (1) ===> " + senderJwk.toJson());

		// Create the Claims, which will be the content of the JWT
		JwtClaims claims = new JwtClaims();
		claims.setIssuer("halehan.com");
		claims.setExpirationTimeMinutesInTheFuture(15);
		claims.setGeneratedJwtId();
		claims.setIssuedAtToNow();
		claims.setNotBeforeMinutesInThePast(2);
		claims.setSubject("kdw0001");
		claims.setStringListClaim("roles", "user");

		JsonWebSignature jws = new JsonWebSignature();

		jws.setPayload(claims.toJson());

		jws.setKeyIdHeaderValue(senderJwk.getKeyId());
		jws.setKey(senderJwk.getPrivateKey());

		jws.setAlgorithmHeaderValue(AlgorithmIdentifiers.RSA_USING_SHA256);

		String jwt = null;
		try {
			jwt = jws.getCompactSerialization();
		} catch (JoseException e) {
			e.printStackTrace();
		}

		return Response.status(200).entity(jwt).build();

	}

	@Path("/findSomething")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findItemById(@HeaderParam("token") String token,
			@QueryParam("itemid") String item_id)
					throws JsonGenerationException, JsonMappingException,
					IOException {

		if (token == null) {
			return Response.status(Status.FORBIDDEN.getStatusCode()).build();
		}

		JsonWebKeySet jwks = new JsonWebKeySet(jwkList);
		JsonWebKey jwk = jwks.findJsonWebKey("1", null, null, null);
		logger.info("JWK (1) ===> " + jwk.toJson());

		// Validate Token's authenticity and check claims
		JwtConsumer jwtConsumer = new JwtConsumerBuilder()
				.setRequireExpirationTime().setAllowedClockSkewInSeconds(30)
				.setRequireSubject().setExpectedIssuer("halehan.com")
				.setVerificationKey(jwk.getKey()).build();

		try {
			// Validate the JWT and process it to the Claims
			JwtClaims jwtClaims = jwtConsumer.processToClaims(token);
			logger.info("JWT validation succeeded! " + jwtClaims);
		} catch (InvalidJwtException e) {
			logger.error("JWT is Invalid: " + e);

			return Response.status(Status.FORBIDDEN.getStatusCode())
					.entity("JWT is Invalid: ").build();
		}

		return Response.status(Status.OK.getStatusCode()).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response login(@HeaderParam("userId") String userId,
			@HeaderParam("password") String password) {

		// Auth and return success or failure
		// JSONObject json = new JSONObject();

		// put some value pairs into the JSON object .
		/*
		 * try { json.put("token", userId + "  " + password); json.put("result",
		 * "SUCCESS"); } catch (JSONException e) { // TODO Auto-generated catch
		 * block e.printStackTrace(); }
		 */
		// return json.toString();
		return Response.status(200).build();
	}

	private Date toDate(String date) {

		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Date convertedDate = null;
		try {
			convertedDate = sdf.parse(date);
			System.out.println(convertedDate);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			convertedDate = null;
		}

		return convertedDate;

	}

	private String toString(Date date) {

		String DATE_FORMAT = "MM/dd/yyyy";
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		System.out.println("Today is " + sdf.format(date));

		return sdf.format(date);

	}

	private Account findAccount(String userName) {

		Client client = Clients.builder().build();

		Application application = client.getResource(
				System.getenv("STORMPATH_APPLICATION_HREF"), Application.class);

		Map<String, Object> queryParams = new HashMap<String, Object>();
		queryParams.put("username", userName);
		AccountList accounts = application.getAccounts(queryParams);
		Account account = accounts.single();

		logger.info("Found Account: " + account.getHref() + ", "
				+ account.getEmail() + ", " + account.getFullName());

		for (Account acct : accounts) {
			logger.info("Found Account: " + acct.getHref() + ", "
					+ acct.getEmail());
		}

		return account;

	}

	public boolean authenticateAccount(String username, String password) {

		boolean authenticated = false;

		Client client = Clients.builder().build();

		Application application = client.getResource(
				System.getenv("STORMPATH_APPLICATION_HREF"), Application.class);

		Account account = null;

		AuthenticationRequest request = UsernamePasswordRequests.builder()
				.setUsernameOrEmail(username).setPassword(password).build();

		try {
			AuthenticationResult result = application
					.authenticateAccount(request);
			account = result.getAccount();
			authenticated = true;
			logger.info(account.getStatus().name());
			logger.info("Authenticated Account: " + account.getUsername()
					+ ", Email: " + account.getEmail());
		} catch (ResourceException ex) {
			logger.error(ex.getMessage());
		}
		return authenticated;
	}

}
