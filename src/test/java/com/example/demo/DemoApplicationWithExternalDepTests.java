package com.example.demo;

import com.example.demo.controller.HelloWorldController;
import com.example.demo.service.GreetingService;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SuppressWarnings("removal")
@SpringBootTest
@AutoConfigureMockMvc
class DemoApplicationWithExternalDepTests {
	@Autowired
	private HelloWorldController controller;

	@Autowired
	private MockMvc mockMvc;
	@Test
	public void contextLoadsWithControllerSuccess(){
		assertThat(controller).isNotNull();
	}

	//unit testing with dependencies (integration testing )
	@Test
	public void sayHelloShouldReturnDefaultMessage() throws Exception {
		// call /hello and check the actual and expected message
		this.mockMvc.perform(get("/hello"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string(CoreMatchers.containsString("Hello from")));
	}

}
