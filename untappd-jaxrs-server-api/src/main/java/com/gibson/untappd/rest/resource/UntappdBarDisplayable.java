package com.gibson.untappd.rest.resource;

public interface UntappdBarDisplayable {
    int totalUniqueCheckinsFor(String username);
    int totalCheckinsFor(String username);
}