package com.essentier.opstool.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.essentier.opstool.model.Service;

public interface ServiceRepository extends JpaRepository<Service, Long> {
}