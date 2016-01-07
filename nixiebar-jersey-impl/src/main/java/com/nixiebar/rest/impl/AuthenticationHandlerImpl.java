package com.nixiebar.rest.impl;

import com.nixiebar.AuthenticationHandler;
import com.wordnik.swagger.annotations.Api;

import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Path("untappd/users")
@Api(tags = {"untappd", "users"})
public class AuthenticationHandlerImpl implements AuthenticationHandler {
    private Map<String, String> usernameTokens = new ConcurrentHashMap<>();

    @PUT
    @Path("/{username}")
    @Override
    public boolean storeUser(String token, @PathParam("username") String username) {
        //TODO: store username and oauth access token in database
        usernameTokens.put(username, token);
        return true;
    }

    @Override
    public String fetchUser(String username) {
        //TODO: fetch oauth access token for username
        return usernameTokens.get(username);
    }
}
