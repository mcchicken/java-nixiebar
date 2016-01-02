package com.nixiebar.rest.impl;

import com.untappd.rest.domain.UntappdUser;
import com.nixiebar.AuthenticationHandler;
import com.nixiebar.CheckinStats;
import com.nixiebar.domain.NixieUser;
import com.untappd.rest.client.impl.UntappdRestClient;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("/untappd/checkins")
@Api(tags = {"untappd", "checkins"})
public class CheckinStatsImpl implements CheckinStats {
    private final UntappdRestClient client;
    private final AuthenticationHandler authenticationHandler;

    @Inject
    public CheckinStatsImpl(UntappdRestClient client, AuthenticationHandler authenticationHandler) {
        this.client = client;
        this.authenticationHandler = authenticationHandler;
    }

    @GET
    @Path("/total")
    @ApiOperation(value = "Fetch total number of checkins for a user", response = Integer.class)
    @Override
    public Integer totalCheckinsFor(@QueryParam("username") String username) {
        NixieUser authenticatedUser = authenticationHandler.fetchUser(username);
        UntappdUser untappdUser = client.getUserStatsService().getUserStats(username,
                authenticatedUser.getAccessToken());
        return untappdUser.getStats().getTotal_checkins();
    }

    @GET
    @Path("/unique")
    @ApiOperation(value = "Fetch total number of unique checkins for a user", response = Integer.class)
    @Override
    public Integer totalUniqueCheckinsFor(@QueryParam("username") String username) {
        NixieUser authenticatedUser = authenticationHandler.fetchUser(username);
        UntappdUser untappdUser = client.getUserStatsService().getUserStats(username,
                authenticatedUser.getAccessToken());
        return untappdUser.getStats().getTotal_beers();
    }
}