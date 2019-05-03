package com.essentier.opstool.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.essentier.opstool.model.Service;

public interface ServiceRepository extends JpaRepository<Service, Long> {

	List<Service> findByEnvId(Long envId);
}