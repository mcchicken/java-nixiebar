package com.gibson.untappd.rest.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import com.gibson.untappd.rest.domain.Token;

@Path("oauth")
public interface UntappdAuthentication {
	@GET
	public Token authorize(@QueryParam("code") String code);
}
