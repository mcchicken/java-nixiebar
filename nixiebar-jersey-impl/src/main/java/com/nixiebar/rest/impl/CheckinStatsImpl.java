package com.nixiebar.rest.impl;

import com.untappd.rest.domain.UntappdUser;
import com.nixiebar.AuthenticationHandler;
import com.nixiebar.CheckinStats;
import com.untappd.rest.client.impl.UntappdRestClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

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
    public CheckinStatsImpl(AuthenticationHandler authenticationHandler) {
        this.client = new UntappdRestClient();
        this.authenticationHandler = authenticationHandler;
    }

    @GET
    @Path("/total")
    @ApiOperation(value = "Fetch total number of checkins for a user", response = Integer.class)
    @Override
    public Integer totalCheckinsFor(@QueryParam("username") String username) {
        String token = authenticationHandler.fetchUser(username);
        UntappdUser untappdUser = client.getUserStatsService().getUserStats(token, username);
        return untappdUser.getStats().getTotal_checkins();
    }

    @GET
    @Path("/unique")
    @ApiOperation(value = "Fetch total number of unique checkins for a user", response = Integer.class)
    @Override
    public Integer totalUniqueCheckinsFor(@QueryParam("username") String username) {
        String token = authenticationHandler.fetchUser(username);
        UntappdUser untappdUser = client.getUserStatsService().getUserStats(token, username);
        return untappdUser.getStats().getTotal_beers();
    }
}