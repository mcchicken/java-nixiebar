package com.untappd.rest.domain;

public class UntappdUser {
	private int untappdId; //TODO: add serialize to id when GSON dependency added
	private String user_name;
	private String first_name;
	private String last_name;
	private Stats stats;
	
	public int getUntappdId() {
		return untappdId;
	}
	
	public String getUser_name() {
		return user_name;
	}
	
	public String getFirst_name() {
		return first_name;
	}
	
	public String getLast_name() {
		return last_name;
	}
	
	public Stats getStats() {
		return stats;
	}
}