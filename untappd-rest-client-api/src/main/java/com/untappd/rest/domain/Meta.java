package com.untappd.rest.domain;

public class Meta {
	private final String http_code;

	public Meta(String http_code) {
		this.http_code = http_code;
	}
	
	public String getHttp_Code() {
		return http_code;
	}
}
