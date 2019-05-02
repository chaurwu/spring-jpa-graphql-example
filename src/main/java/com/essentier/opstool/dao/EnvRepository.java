package com.essentier.opstool.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.essentier.opstool.model.Env;

public interface EnvRepository extends JpaRepository<Env, Long> {
}