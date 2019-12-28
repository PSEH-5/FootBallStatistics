package com.sapient.FootBallStatistics.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Team {
	@JsonProperty("team_key")
	private Integer teamId;
	@JsonProperty("team_name")
	private String teamName;
	public Integer getTeamId() {
		return teamId;
	}
	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
}
