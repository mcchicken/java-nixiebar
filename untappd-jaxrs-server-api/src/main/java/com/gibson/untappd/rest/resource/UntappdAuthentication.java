package com.gibson.untappd.rest.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("oauth")
public interface UntappdAuthentication {
	@GET
	public String authorize(@QueryParam("code") String code);
}
