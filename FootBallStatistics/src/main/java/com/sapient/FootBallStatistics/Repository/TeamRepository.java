package com.sapient.FootBallStatistics.Repository;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.sapient.FootBallStatistics.model.Team;


@Repository
public class TeamRepository {
	
	@Value("${api-host}")
	private String footballApiHost;

	@Value("${api-key}")
	private String apiKey;

	public Team getTeamByName(String teamName, Integer leagueId) {
		RestTemplate restTemplate = new RestTemplate();
		String uri = footballApiHost + "?action=get_teams&league_id=" + leagueId + "&APIkey=" + apiKey;
		Team[] teams = restTemplate.getForObject(uri, Team[].class);
		return Arrays.stream(teams).filter(team -> team.getTeamName().equalsIgnoreCase(teamName)).findFirst().get();
	}

}
