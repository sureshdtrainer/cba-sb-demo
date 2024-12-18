package com.example.demo;

import com.example.demo.controller.HelloWorldController;
import static org.assertj.core.api.Assertions.*;

import com.example.demo.service.GreetingService;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SuppressWarnings("removal")
@SpringBootTest
@AutoConfigureMockMvc
class DemoApplicationTests {
	@Autowired
	private HelloWorldController controller;

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private GreetingService greetingService;

	@Test
	void contextLoads() {
	}

	@Test
	public void contextLoadsWithControllerSuccess(){
		assertThat(controller).isNotNull();
	}//unit testing by mocking dependencies and testing only controller(unit of work)

	@Test
	public void sayHelloShouldReturnMockedMessage() throws Exception {
		// call /hello and check the actual and expected message
		//Mock the behaviour the dependency
		Mockito.when(greetingService.greet()).thenReturn("Bye from Greeting Service");

		this.mockMvc.perform(get("/hello"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string(CoreMatchers.containsString("Bye from")));
	}


}
