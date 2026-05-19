package com.spring.ProjectCountries.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.spring.ProjectCountries.Exception.ResourceNotFoundException;
import com.spring.ProjectCountries.dto.ProjectCountriesDto;
import com.spring.ProjectCountries.model.Country;
import com.spring.ProjectCountries.repository.ProjectCountriesRepository;

//import jakarta.transaction.Transactional;

@Service
//@Transactional
public class ProjectCountriesServiceImpl implements ProjectCountriesService {

	@Autowired
	private ProjectCountriesRepository projectCountriesRepository;

	@Override
	public ProjectCountriesDto createCountry(ProjectCountriesDto country) {
		Country countryUpdate = new Country();

		countryUpdate.setName(country.getName());
		countryUpdate.setCapital(country.getCapital());

		countryUpdate = projectCountriesRepository.save(countryUpdate);
		// old way
//		ProjectCountriesDto dto = new ProjectCountriesDto();
		country.setCapital(countryUpdate.getCapital());
		country.setName(countryUpdate.getName());
		country.setId(countryUpdate.getId());
		return country;
	}

	@Override
	public ProjectCountriesDto updateCountry(ProjectCountriesDto country) {
		Optional<Country> countryDb = this.projectCountriesRepository.findById(country.getId());

		if (countryDb.isPresent()) {
			Country countryUpdate = countryDb.get();
			countryUpdate.setId(country.getId());
			countryUpdate.setName(country.getName());
			countryUpdate.setCapital(country.getCapital());
			countryUpdate = projectCountriesRepository.save(countryUpdate);
			// new way
			BeanUtils.copyProperties(countryUpdate, country);

			return country;
		} else {
			throw new ResourceNotFoundException("Record not found with id: " + country.getId());
		}
	}

	@Override
	public List<Country> getAllCountries() {
		return this.projectCountriesRepository.findAll();
	}

//	@Override
//	public Country getCountryById(long countryId) {
//		Optional<Country> countryDb = this.projectCountriesRepository.findById(countryId);
//
//		if (countryDb.isPresent())
//			return countryDb.get();
//		else
//			throw new ResourceNotFoundException("Record not found with id: " + countryId);
//	}

	@Override
	public Country getCountryById(long countryId) {
		try {
			return this.projectCountriesRepository.findById(countryId)
					.orElseThrow(() -> new ResourceNotFoundException("Record not found with id: " + countryId));
		} catch (DataAccessException ex) {
			// DB crashed, connection failed, etc.
			// Wrap the root cause so it's not lost
			throw new ResourceNotFoundException("Failed to fetch country with id: " + countryId, ex);
		}
	}


	@Override
	public void deleteCountry(long countryId) {
		Optional<Country> countryDb = this.projectCountriesRepository.findById(countryId);

		if (countryDb.isPresent())
			this.projectCountriesRepository.delete(countryDb.get());
		else
			throw new ResourceNotFoundException("Record not found with exception: " + countryId);
	}

}
