package com.essentier.opstool.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class ServiceTest {

	@Test
	public void testToString() {
		Env env1 = new Env("env1");
		Service service1 = new Service("service1", env1);
		assertThat(service1.toString()).doesNotContain("env");
	}
}
