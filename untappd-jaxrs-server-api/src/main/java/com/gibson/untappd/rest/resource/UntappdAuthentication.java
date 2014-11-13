package com.gibson.untappd.rest.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.gibson.untappd.rest.domain.Token;

@Path("/oauth")
@Produces(MediaType.APPLICATION_JSON)
public interface UntappdAuthentication {
	@GET
	public Token authorize(@QueryParam("code") String code);
}
