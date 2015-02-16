package com.gibson.untappd.rest.impl;

import javax.inject.Inject;

import com.gibson.untappd.rest.domain.Client;
import com.gibson.untappd.rest.domain.Token;
import com.gibson.untappd.rest.impl.UntappdNixieBarClientImpl;
import com.gibson.untappd.rest.resource.UntappdAuthentication;

public class UntappdNixieBarAuthentication implements UntappdAuthentication {
	private UntappdNixieBarClientImpl client;
	
	public UntappdNixieBarAuthentication() {}
	
	@Inject
	public UntappdNixieBarAuthentication(UntappdNixieBarClientImpl client) {
		this.client = client;
	}
	
	@Override
	public Token authorize(String code) {
		Token token = client.getAccessToken(code);
		System.out.println("ACCESS TOKEN: " + token.getResponse().getAccess_Token());
		return token;
	}

	@Override
	public Client clientId() {
		return client.getClientInfo();
	}
}
