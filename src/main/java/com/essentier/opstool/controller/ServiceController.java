package com.essentier.opstool.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.essentier.opstool.dao.ServiceRepository;
import com.essentier.opstool.model.Service;

@RestController
public class ServiceController {
	public static final String SERVICES_URI = "/services";
	private final ServiceRepository repository;
	
	ServiceController(ServiceRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping(SERVICES_URI)
	List<Service> getServicesOfEnv(@RequestParam Long envId) {
		return repository.findByEnvId(envId);
	}

	@PostMapping(SERVICES_URI)
	Service create(@RequestBody Service newService) {
		return repository.save(newService);
	}
}
