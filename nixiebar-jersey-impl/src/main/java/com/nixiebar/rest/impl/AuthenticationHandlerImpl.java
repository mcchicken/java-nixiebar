package com.nixiebar.rest.impl;

import com.nixiebar.AuthenticationHandler;
import com.nixiebar.domain.NixieUser;
import com.wordnik.swagger.annotations.Api;

import javax.ws.rs.Path;

@Path("untappd/oauth")
@Api(tags = {"untappd", "oauth"})
public class AuthenticationHandlerImpl implements AuthenticationHandler {

    @Override
    public boolean storeUser(NixieUser nixieUser) {
        return false;
    }

    @Override
    public NixieUser fetchUser(String username) {
        return null;
    }
}
