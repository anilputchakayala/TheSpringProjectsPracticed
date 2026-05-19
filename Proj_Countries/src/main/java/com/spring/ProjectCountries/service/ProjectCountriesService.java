package com.spring.ProjectCountries.service;

import java.util.List;


import com.spring.ProjectCountries.dto.ProjectCountriesDto;
import com.spring.ProjectCountries.model.Country;

public interface ProjectCountriesService {
	
	ProjectCountriesDto createCountry(ProjectCountriesDto country);
	
	ProjectCountriesDto updateCountry(ProjectCountriesDto country);
	
	List<Country> getAllCountries();
	
	Country getCountryById(long countryId);
	
	void deleteCountry(long countryId);

}
