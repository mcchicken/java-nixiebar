package com.untappd.rest.client.domain;

public class UntappdProperties {
    private final String clientId;
    private final String clientSecret;
    private final String oauthUrl;
    private final String redirectUrl;

    public UntappdProperties(String clientId, String clientSecret, String oauthUrl, String redirectUrl) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.oauthUrl = oauthUrl;
        this.redirectUrl = redirectUrl;
    }

    public String getClientId() {
        return clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public String getOauthUrl() {
        return oauthUrl;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }
}
