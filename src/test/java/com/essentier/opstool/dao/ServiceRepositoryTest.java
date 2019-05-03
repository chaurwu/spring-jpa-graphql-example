package com.essentier.opstool.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.essentier.opstool.model.Env;
import com.essentier.opstool.model.Service;

@DataJpaTest
@RunWith(SpringRunner.class)
public class ServiceRepositoryTest {

	@Autowired
	private ServiceRepository svcRepository;
	
	@Autowired
	private EnvRepository envRepository;
	
	@Test
	public void findByEnvId() {
		Env env = this.envRepository.saveAndFlush(new Env("env1"));
		this.svcRepository.saveAndFlush(new Service("service1", env));
		
		List<Service> services = this.svcRepository.findByEnvId(env.getId());
		assertThat(services.size()).isEqualTo(1);
		Service foundService = services.get(0);
		assertThat(foundService.getName()).isEqualTo("service1");

	}
}
