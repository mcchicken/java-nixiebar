package com.gibson.untappd.rest.domain;

public class Client {
	private final String clientId;
	private final String clientSecret;
	private final String redirectUrl;
	
	public Client(String clientId, String clientSecret, String redirectUrl) {
		this.clientId = clientId;
		this.clientSecret = clientSecret;
		this.redirectUrl = redirectUrl;
	}
	
	public String getClientId() {
		return clientId;
	}
	
	public String getClientSecret() {
		return clientSecret;
	}
	
	public String getRedirectUrl() {
		return redirectUrl;
	}
}
