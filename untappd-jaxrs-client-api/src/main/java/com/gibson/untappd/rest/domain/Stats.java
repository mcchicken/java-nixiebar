package com.gibson.untappd.rest.domain;

public class Stats {
	private int total_badges;
    private int total_friends;
    private int total_checkins;
    private int total_beers;
    private int total_created_beers;
 
    public Stats(int total_badges, int total_friends
    		, int total_checkins, int total_beers
    		, int total_created_beers) {
    	this.total_badges = total_badges;
    	this.total_friends = total_friends;
    	this.total_checkins = total_checkins;
    	this.total_beers = total_beers;
    	this.total_created_beers = total_created_beers;
    }

	public int getTotal_badges() {
		return total_badges;
	}

	public int getTotal_friends() {
		return total_friends;
	}

	public int getTotal_checkins() {
		return total_checkins;
	}

	public int getTotal_beers() {
		return total_beers;
	}

	public int getTotal_created_beers() {
		return total_created_beers;
	}
}
