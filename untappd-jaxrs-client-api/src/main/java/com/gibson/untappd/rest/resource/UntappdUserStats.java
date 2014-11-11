package com.gibson.untappd.rest.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.gibson.untappd.rest.domain.User;

@Path("/v4/user/")
public interface UntappdUserStats {
	String USER_STATS_URL = "https://api.untappd.com/v4/user/info/";
	
	@GET
	@Path("/info/{username}")
	public User getUserStats(@PathParam("username") String username);
}
