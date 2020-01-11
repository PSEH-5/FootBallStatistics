package com.sapient.FootBallStatistics.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.FootBallStatistics.Repository.CountryRepository;
import com.sapient.FootBallStatistics.Repository.LeagueRepository;
import com.sapient.FootBallStatistics.Repository.StandingRepository;
import com.sapient.FootBallStatistics.Repository.TeamRepository;
import com.sapient.FootBallStatistics.model.Country;
import com.sapient.FootBallStatistics.model.League;
import com.sapient.FootBallStatistics.model.Standing;
import com.sapient.FootBallStatistics.model.Team;

@Service
public class StatisticsService {

	@Autowired
	private CountryRepository countryRepository;
    @Autowired
	private LeagueRepository leagueRepository;
    @Autowired
	private TeamRepository teamRepository;
	@Autowired
	private StandingRepository standingRepository;
	
	public Standing getStanding(String countryName, Integer leagueId, String teamName) {
		Integer teamId = teamRepository.getTeamByName(teamName, leagueId).getTeamId();
		return standingRepository.getStanding(leagueId, teamId);
	}
	
	public Country getCountry(String countryName) {
		return countryRepository.getCountryByName(countryName);
	}
	
	public Team getTeam(String teamName, Integer leagueId) {
		return teamRepository.getTeamByName(teamName, leagueId);
	}
	
	public League getLeague(String name, Integer countryId) {
		return leagueRepository.getLeagueByName(name, countryId);
	}
}
