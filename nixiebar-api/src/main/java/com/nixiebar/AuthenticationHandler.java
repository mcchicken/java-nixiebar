package com.nixiebar;

public interface AuthenticationHandler {
	boolean storeUser(String token, String username);
	String fetchUser(String username);
}