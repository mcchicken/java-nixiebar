package com.gibson.untappd.rest.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import com.gibson.untappd.rest.domain.Token;

public interface UntappdAuthenticationHandler {
	String OAUTH_ACCESS_TOKEN_URL = "https://untappd.com/oauth/authorize?response_type=code";	
	String INITIAL_OAUTH_URL = "https://untappd.com/oauth/authenticate?response_type=code";
	
	@GET
	@Path(INITIAL_OAUTH_URL)
	public String getRedirectCode(@QueryParam("client_id") String clientId
			, @QueryParam("redirect_url") String redirectUrl);
	
	@GET
	@Path(OAUTH_ACCESS_TOKEN_URL)
	public Token getAccessTokenFromRedirect(@QueryParam("client_id") String clientId
			, @QueryParam("client_secret") String clientSecret
			, @QueryParam("redirect_url") String redirectUrl
			, @QueryParam("code") String code);
}
