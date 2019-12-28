package com.sapient.FootBallStatistics.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.sapient.FootBallStatistics.model.Country;
import com.sapient.FootBallStatistics.model.League;
import com.sapient.FootBallStatistics.model.Standing;
import com.sapient.FootBallStatistics.model.Team;
import com.sapient.FootBallStatistics.service.StatisticsService;

@RestController
public class FootBallStatisticsController {
	
	@Autowired
	StatisticsService statisticsService;
	
	@GetMapping(value="/country/{name}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Country getCountry(@PathVariable("name") String name) {
		return statisticsService.getCountry(name);
	}
	
	@GetMapping(value="/league",produces=MediaType.APPLICATION_JSON_VALUE)
	public League getLeague(@RequestParam("league_name") String name, @RequestParam("country_id") Integer id) {
		return statisticsService.getLeague(name, id);
	}
	
	@GetMapping(value="/team",produces=MediaType.APPLICATION_JSON_VALUE)
	public Team getTeam(@RequestParam("team_name") String name, @RequestParam("league_id") Integer id) {
		return statisticsService.getTeam(name, id);
	}
	
	@GetMapping(value="/standing",produces=MediaType.APPLICATION_JSON_VALUE)
	public Standing getStanding(@RequestParam("country_name") String countryName,
            @RequestParam("league_name") String leagueName,
            @RequestParam("team_name") String teamName) {

				return statisticsService.getStanding(countryName, leagueName, teamName);
	}			
}

