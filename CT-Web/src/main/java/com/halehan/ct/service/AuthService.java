package com.halehan.ct.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

@Path("/auth/")
@Produces({"application/json"})
public class AuthService {

	@GET
	@Path("{userId}/{password}")
	@Produces(MediaType.APPLICATION_JSON)
	public String login(@PathParam("userId") String userId,
			@PathParam("password") String password) {

		// Auth and return success or failure
		JSONObject json = new JSONObject();

		// put some value pairs into the JSON object .
		try {
			json.put("token", userId + "  " + password);
			json.put("result", "SUCCESS");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return json.toString();

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

}
