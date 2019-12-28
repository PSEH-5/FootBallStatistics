package com.sapient.FootBallStatistics.Repository;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.sapient.FootBallStatistics.model.Country;

@Repository
public class CountryRepository {
	@Value("${api-host}")
	private String footballApiHost;
	
	@Value("${api-key}")
	private String apiKey;
	
	public Country getCountryByName(String name) {
		RestTemplate restTemplate = new RestTemplate();
		String uri = footballApiHost+ "?action=get_countries&APIkey="+apiKey;
	    Country[] countryList= restTemplate.getForObject(uri, Country[].class);
	    return Arrays.stream(countryList).filter(coutnry -> coutnry.getName().equalsIgnoreCase(name)).findFirst().get();
	}
}
