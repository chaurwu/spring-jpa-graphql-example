package com.essentier.opstool.dto;

import java.util.List;

import com.essentier.opstool.model.Env;
import com.essentier.opstool.model.Service;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
public class EnvDto {
	
	private Env env;
	private List<Service> services;
	
	public EnvDto(Env env, List<Service> services) {
		this.env = env;
		this.services = services;
	}

}
