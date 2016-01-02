package com.nixiebar.domain;

public class NixieUser {
    private final String accessToken;
    private final String username;

    public NixieUser(String accessToken, String username) {
        this.accessToken = accessToken;
        this.username = username;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getUsername() {
        return username;
    }
}
