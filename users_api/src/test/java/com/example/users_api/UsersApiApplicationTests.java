package com.example.users_api;

import static org.hamcrest.Matchers.containsString;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
class UsersApiApplicationTests {

	@Autowired
	private UserController controller;
	
	@Autowired
	private MockMvc mockMvc;

	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}

	@Test
	void testGetUsers() throws Exception {
		this.mockMvc
			.perform(get("/api/v1/user/?name=Sevak"))
			.andDo(print())
			.andExpect(status().isOk());

		this.mockMvc
			.perform(get("/api/v1/user/?name=Sevak&page=0"))
			.andDo(print())
			.andExpect(status().isOk());
		
		this.mockMvc
			.perform(get("/api/v1/user/?name=Sevak&page=0&count=2"))
			.andDo(print())
			.andExpect(status().isOk());
	}

	@Test
	void testPostUsers() throws Exception {
		this.mockMvc
			.perform(post("{\"name\":\"Alice\", \"age\" :14 }"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().string(containsString("{\"name\":\"Alice\", \"age\" :14 }")));
	}
}
