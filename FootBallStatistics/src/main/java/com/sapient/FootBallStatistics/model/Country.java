package com.sapient.FootBallStatistics.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Country {
	@JsonProperty("country_id")
	private Integer id;
	@JsonProperty("country_name")
	private String name;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
