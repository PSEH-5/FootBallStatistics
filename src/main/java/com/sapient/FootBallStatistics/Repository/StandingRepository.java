package com.sapient.FootBallStatistics.Repository;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.sapient.FootBallStatistics.model.Standing;


@Repository
public class StandingRepository {
	
	@Value("${api-host}")
	private String footballApiHost;
	
	@Value("${api-key}")
	private String apiKey;
	
	public Standing getStanding(Integer leagueId, Integer teamId){
		RestTemplate restTemplate = new RestTemplate();
		String uri = footballApiHost+ "?action=get_standings&league_id="+ leagueId+ "&APIkey="+apiKey;
		Standing[] standings = restTemplate.getForObject(uri, Standing[].class);
        return Arrays.stream(standings).filter(standing -> standing.getTeamId().equals(teamId)).findFirst().get();
	}

}
