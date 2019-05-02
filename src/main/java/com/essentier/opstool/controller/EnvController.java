package com.essentier.opstool.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.essentier.opstool.dao.EnvRepository;
import com.essentier.opstool.model.Env;

@RestController
public class EnvController {
	public static final String ENVS_URI = "/envs";
	private final EnvRepository repository;
	
	EnvController(EnvRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping(ENVS_URI)
	List<Env> getAll() {
		return repository.findAll();
	}

	@PostMapping(ENVS_URI)
	Env create(@RequestBody Env newEnv) {
		return repository.save(newEnv);
	}
	
	@DeleteMapping(ENVS_URI + "/{id}")
	void delete(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
