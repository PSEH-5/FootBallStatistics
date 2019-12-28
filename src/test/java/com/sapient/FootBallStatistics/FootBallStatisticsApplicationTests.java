package com.sapient.FootBallStatistics;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import com.sapient.FootBallStatistics.Repository.CountryRepository;
import com.sapient.FootBallStatistics.Repository.LeagueRepository;
import com.sapient.FootBallStatistics.Repository.StandingRepository;
import com.sapient.FootBallStatistics.Repository.TeamRepository;
import com.sapient.FootBallStatistics.model.Country;
import com.sapient.FootBallStatistics.model.League;



@SpringBootTest
class FootBallStatisticsApplicationTests {
	
	@Autowired
	private CountryRepository countryRepository;
	
	@Autowired
	private LeagueRepository leagueRepository;
	
	@Autowired
	private TeamRepository teamRepository;
	
	@Autowired
	private StandingRepository standingRepository;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	public void testCountryRepositoryTest() {
		Country country = countryRepository.getCountryByName("France");
		assertTrue(46==country.getId());
	}
	
	@Test
	public void testLeagueRepositoryTest() {
		League league = leagueRepository.getLeagueByName("Championship", 41);
		assertTrue(149==league.getId());
	}
	
	@Test
	public void testTeamRepo() {
		assertTrue(2611==teamRepository.getTeamByName("Leicester", 148).getTeamId());
	}
	
	@Test
	public void testStandingRepositoryTest() {
		assertTrue(0==standingRepository.getStanding(148, 2621).getOverallLeagueDrawn());
	}
	

}
