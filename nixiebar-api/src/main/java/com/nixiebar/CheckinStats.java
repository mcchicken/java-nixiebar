package com.nixiebar;

public interface CheckinStats {
    Integer totalUniqueCheckinsFor(String username);
    Integer totalCheckinsFor(String username);
}