package com.untappd.rest.client.impl;

import com.untappd.rest.resource.UntappdUserStats;
import org.glassfish.jersey.client.proxy.WebResourceFactory;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import java.util.Optional;

public class UntappdRestClient {
    private final WebTarget target;

    private Optional<UntappdUserStats> userStatsService;

    public UntappdRestClient() {
        this.target = ClientBuilder.newClient().target("https://api.untappd.com/v4/");
    }

    public UntappdUserStats getUserStatsService() {
        if(!userStatsService.isPresent()) {
            userStatsService = Optional.of(addServiceInstance(UntappdUserStats.class));
        }
        return userStatsService.get();
    }

    private <T> T addServiceInstance(Class<T> clazz) {
        return WebResourceFactory.newResource(clazz, target);
    }
}