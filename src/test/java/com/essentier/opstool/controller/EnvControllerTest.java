package com.essentier.opstool.controller;

import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.essentier.opstool.dao.EnvRepository;
import com.essentier.opstool.model.Env;

@RunWith(SpringRunner.class)
@WebMvcTest(EnvController.class)
public class EnvControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private EnvRepository envRepository;
	
	@Test
	public void getEnvs() throws Exception {
		when(envRepository.findAll()).thenReturn(Arrays.asList(new Env(1L, "staging", "")));
		mockMvc.perform(MockMvcRequestBuilders.get(EnvController.ENVS_URI))
			.andExpect(status().isOk())
			.andExpect(jsonPath("@.[0].id").value(1L))
			.andExpect(jsonPath("@.[0].name").value("staging"));
	}
}
