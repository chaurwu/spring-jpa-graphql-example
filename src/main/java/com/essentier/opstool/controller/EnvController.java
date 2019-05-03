package com.essentier.opstool.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.essentier.opstool.dao.EnvRepository;
import com.essentier.opstool.dao.ServiceRepository;
import com.essentier.opstool.dto.EnvDto;
import com.essentier.opstool.model.Env;
import com.essentier.opstool.model.Service;

import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;

@GraphQLApi
@RestController
public class EnvController {
	public static final String ENVS_URI = "/envs";
	private final EnvRepository envRepository;
	private final ServiceRepository svcRepository;
	
	EnvController(EnvRepository envRepository, ServiceRepository svcRepository) {
		this.envRepository = envRepository;
		this.svcRepository = svcRepository;
	}
	
	@GraphQLQuery(name="env")
	public EnvDto getEnvServices(Long id) {
		Optional<Env> optionalEnv = envRepository.findById(id);
		if (!optionalEnv.isPresent()) {
			return null;
		}
		
		List<Service> services = svcRepository.findByEnvId(id);
		return new EnvDto(optionalEnv.get(), services);
	}
	
	@GetMapping(ENVS_URI)
	List<Env> getAll() {
		return envRepository.findAll();
	}

	@PostMapping(ENVS_URI)
	Env create(@RequestBody Env newEnv) {
		return envRepository.save(newEnv);
	}
	
	@DeleteMapping(ENVS_URI + "/{id}")
	void delete(@PathVariable Long id) {
		envRepository.deleteById(id);
	}
}
