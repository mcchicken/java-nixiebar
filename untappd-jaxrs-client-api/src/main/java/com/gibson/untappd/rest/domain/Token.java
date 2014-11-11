package com.gibson.untappd.rest.domain;

public class Token {
	private final Meta meta;
	private final Response response;
	
	public Token(Meta meta, Response response) {
		this.meta = meta;
		this.response = response;
	}
	
	public Meta getMeta() {
		return meta;
	}
	
	public Response getResponse() {
		return response;
	}
}
