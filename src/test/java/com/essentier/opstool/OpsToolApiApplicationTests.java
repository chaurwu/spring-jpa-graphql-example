package com.essentier.opstool;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.essentier.opstool.controller.EnvController;
import com.essentier.opstool.model.Env;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class OpsToolApiApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void envsCRUD() {
		ResponseEntity<? extends List> getResponse = restTemplate.getForEntity(EnvController.ENVS_URI, List.class);
		assertThat(getResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(getResponse.getBody().size()).isEqualTo(0);
		
		ResponseEntity<Env> postResponse = restTemplate.postForEntity(EnvController.ENVS_URI, new Env("staging"), Env.class);
		assertThat(postResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
		Env savedEnv = postResponse.getBody();
		assertThat(savedEnv.getName()).isEqualTo("staging");
		
		restTemplate.delete(EnvController.ENVS_URI + "/" + savedEnv.getId());
	}

}
