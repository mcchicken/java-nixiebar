package com.gibson.untappd.rest.impl;

import javax.inject.Inject;

import com.gibson.untappd.rest.client.UntappdNixieBarClientImpl;
import com.gibson.untappd.rest.domain.Token;
import com.gibson.untappd.rest.resource.UntappdAuthentication;

public class UntappdNixieBarAuthentication implements UntappdAuthentication {
	private UntappdNixieBarClientImpl client;
	
	@Inject
	public UntappdNixieBarAuthentication(UntappdNixieBarClientImpl client) {
		this.client = client;
	}
	
	@Override
	public Token authorize(String code) {
		return client.getAccessToken(code);
	}
}
