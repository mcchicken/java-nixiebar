package com.gibson.untappd.rest.impl;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gibson.untappd.rest.adapter.TokenGsonAdapter;
import com.gibson.untappd.rest.domain.Client;
import com.gibson.untappd.rest.domain.Token;
import com.gibson.untappd.rest.domain.User;
import com.gibson.untappd.rest.provider.GsonProvider;
import com.gibson.untappd.rest.resource.UntappdAuthenticationHandler;
import com.gibson.untappd.rest.resource.UntappdUserStats;
import com.google.common.base.Preconditions;

public class UntappdNixieBarClientImpl {
	private static final Logger logger = LoggerFactory.getLogger(UntappdNixieBarClientImpl.class);
	private static final String CLIENT_ID = "D5F54706652DD942DCF1C6AC855B7C22CF810FAE";
	private static final String CLIENT_SECRET = "D5F54706652DD942DCF1C6AC855B7C22CF810FAE";
	private static final String REDIRECT_URL = "http://nixiebar.com:8080/untappd-jaxrs-server-resteasy-impl/rest/oauth";
	
	private final UntappdAuthenticationHandler authenticationHandler;
	private final UntappdUserStats userStatsRetriever;
	
	public UntappdNixieBarClientImpl() {
		this.authenticationHandler = createOAuthHandler();
		this.userStatsRetriever = createUserStatsRetriever();
	}

	public Client getClientInfo() {
		return new Client(CLIENT_ID, CLIENT_SECRET, REDIRECT_URL);
	}
	
	public Token getAccessToken(String code) {
		logger.debug("Retrieving access token using code {}", code);
		Preconditions.checkNotNull(code, "Can't retrieve access token without code");
		
		return authenticationHandler.getAccessTokenFromRedirect(CLIENT_ID, CLIENT_SECRET
				, REDIRECT_URL, code);
	}
	
	public int getTotalUniqueCheckinsFor(String username) {
		logger.debug("Retrieving total beer checkins for {}", username);
		User user = userStatsRetriever.getUserStats(username);
		return user.getStats().getTotal_beers();
	}
	
	private UntappdAuthenticationHandler createOAuthHandler() {
		logger.debug("Building proxy client for OAuth authentication...");
		WebTarget target = ClientBuilder
						.newClient()
						.register(GsonProvider.class)
						.register(TokenGsonAdapter.class)
						.target(UntappdAuthenticationHandler.OAUTH_ACCESS_TOKEN_URL);
		ResteasyWebTarget resteasyTarget = (ResteasyWebTarget)target;
		return resteasyTarget.proxy(UntappdAuthenticationHandler.class);
	}

	private UntappdUserStats createUserStatsRetriever() {
		logger.debug("Building proxy client for user stats...");
		WebTarget target = ClientBuilder
						.newClient()
						.target(UntappdUserStats.USER_STATS_URL);
		ResteasyWebTarget resteasyTarget = (ResteasyWebTarget)target;
		resteasyTarget.register(GsonProvider.class);
		return resteasyTarget.proxy(UntappdUserStats.class);
	}
}