package com.sapient.FootBallStatistics.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class League {
	@JsonProperty("league_id")
	private Integer id;
	@JsonProperty("league_name")
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
