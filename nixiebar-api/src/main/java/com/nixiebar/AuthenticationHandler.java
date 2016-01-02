package com.nixiebar;

import com.nixiebar.domain.NixieUser;

public interface AuthenticationHandler {
	boolean storeUser(NixieUser nixieUser);
	NixieUser fetchUser(String username);
}