package com.essentier.opstool.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EnvJpaTest {

	@Autowired
	private TestEntityManager testEntityManager;
	
	@Test
	public void testJpa() {
		Env env = testEntityManager.persistFlushFind(new Env("staging"));
		assertThat(env.getId()).isGreaterThan(0);
		assertThat(env.getName()).isEqualTo("staging");
	}
}
