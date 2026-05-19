package com.spring.ProjectCountries.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.ProjectCountries.dto.ProjectCountriesDto;
import com.spring.ProjectCountries.model.Country;
import com.spring.ProjectCountries.service.ProjectCountriesService;

@RestController
public class ProjectCountriesController {
	
	@Autowired
	private ProjectCountriesService projectCountriesService;

//	@GetMapping("/countries")
	@GetMapping(path="/countries", produces = "application/json")       // Content Negotiation. Negotiating that Data will comes only in json format
	public ResponseEntity<List<Country>> getAllProduct() {
		return ResponseEntity.ok().body(projectCountriesService.getAllCountries());
	}

	@GetMapping("/countries/{id}")
	public ResponseEntity<Country> getProductById(@PathVariable long id) {
		return ResponseEntity.ok().body(projectCountriesService.getCountryById(id));
	}

	@PostMapping("/countries")
//	@PostMapping(path="/countries")
	public ResponseEntity<ProjectCountriesDto> createProduct(@RequestBody ProjectCountriesDto country) {
		return ResponseEntity.ok().body(this.projectCountriesService.createCountry(country));
	}

	@PutMapping("/countries/{id}")
	public ResponseEntity<ProjectCountriesDto> updateProduct(@PathVariable long id, @RequestBody ProjectCountriesDto country) {
		country.setId(id);
		return ResponseEntity.ok().body(this.projectCountriesService.updateCountry(country));
	}

	@DeleteMapping("/countries/{id}")
	public HttpStatus deleteProduct(@PathVariable long id) {
		this.projectCountriesService.deleteCountry(id);
		return HttpStatus.OK;
	}


}
