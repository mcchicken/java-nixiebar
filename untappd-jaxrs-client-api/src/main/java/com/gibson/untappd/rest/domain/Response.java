package com.gibson.untappd.rest.domain;

public class Response {
	private final String access_token;
	
	public Response(String access_token) {
		this.access_token = access_token;
	}
	
	public String getAccess_Token() {
		return access_token;
	}
}
