package com.gibson.untappd.rest.filter;

import java.io.IOException;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;

import com.gibson.untappd.rest.domain.Token;
import com.google.common.base.Preconditions;

public class AccessTokenRequestFilter implements ClientRequestFilter {
	private final String access;
	private final Token token;

	public AccessTokenRequestFilter(String access, Token token) {
		this.access = Preconditions.checkNotNull(access, "Access header must not be null.");
		this.token = Preconditions.checkNotNull(token, "Token must not be null.");
	}
	
	@Override
	public void filter(ClientRequestContext requestContext) throws IOException {
		requestContext.getHeaders().putSingle(access, token);
	}
}
