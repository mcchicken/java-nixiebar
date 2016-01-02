package com.untappd.rest.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

import com.untappd.rest.domain.UntappdUser;

@Path("/user/")
public interface UntappdUserStats {
	@GET
	@Path("/info/{username}")
	UntappdUser getUserStats(@PathParam("username") String username, @QueryParam("access_token") String token);
}
