package com.gibson.untappd.rest.impl;

import javax.inject.Inject;

import com.gibson.untappd.rest.client.UntappdNixieBarClientImpl;
import com.gibson.untappd.rest.resource.UntappdBarDisplayable;

public class UntappdNixieBarDisplay implements UntappdBarDisplayable {
	private final UntappdNixieBarClientImpl client;
	
	@Inject
	public UntappdNixieBarDisplay(UntappdNixieBarClientImpl client) {
		this.client = client;
	}
	
	@Override
	public int totalUniqueCheckinsFor(String username) {
		return client.getTotalUniqueCheckinsFor(username);
	}

	@Override
	public int totalCheckinsFor(String username) {
		// TODO Auto-generated method stub
		return 0;
	}

}