package com.essentier.opstool;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OpsToolApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpsToolApiApplication.class, args);
	}

	@Bean
    public ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();
        return mapper;
    }
}
