package com.spring.ProjectCountries.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.ProjectCountries.model.Country;

public interface ProjectCountriesRepository extends JpaRepository<Country, Long>{

}
