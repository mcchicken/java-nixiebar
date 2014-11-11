package com.gibson.untappd.cdi.producer;

import javax.enterprise.inject.Produces;

import com.gibson.untappd.rest.client.UntappdNixieBarClientImpl;

public class UntappdRestClientProducer {
	@Produces
	public UntappdNixieBarClientImpl getNixieBarClient() {
		return new UntappdNixieBarClientImpl();
	}
}
