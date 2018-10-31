package org.cwie.blog.validation.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;

import org.cwie.blog.validation.Application;
import org.cwie.blog.validation.model.SimpleDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
//@WebMvcTest(controllers = SimpleDtoController.class)
public class SimpleDtoControllerTest {
//	@Autowired
//	private MockMvc mvc;
	
	@Autowired
    private WebApplicationContext webAppContext;
    private MockMvc mockMvc;
 
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.webAppContextSetup(webAppContext).build();
    }
     

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	public void testCreateSimpleDtoWithBadRequest() throws Exception { 
		final SimpleDto simpleDto = new SimpleDto();
		simpleDto.setId(1);
		simpleDto.setName("Test Name");
		simpleDto.setCategory("simple1");
		simpleDto.setActive(true);
		simpleDto.setOrder("asc");
		simpleDto.setCreatedDatetime(new Date());

		String body = objectMapper.writeValueAsString(simpleDto);

		mockMvc.perform(post("/simpledto")
				.contentType("application/json")
				.content(body))
		.andExpect(status().isBadRequest());
	}
	
	@Test
	public void testGetSimpleDto() throws Exception { 
		final SimpleDto simpleDto = new SimpleDto();
		simpleDto.setId(2);
		simpleDto.setName("Test Name");
		simpleDto.setCategory("simple");
		simpleDto.setActive(true);
		simpleDto.setOrder("asc");
		simpleDto.setCreatedDatetime(new Date());

		String body = objectMapper.writeValueAsString(simpleDto);

		mockMvc.perform(post("/simpledto")
				.contentType("application/json")
				.content(body));
		
		mockMvc.perform(get("/simpledto/2"))
				.andExpect(status().is2xxSuccessful());
		
		mockMvc.perform(get("/simpledto/1"))
				.andExpect(status().isNotFound());

		mockMvc.perform(get("/simpledto/-1"))
				.andExpect(status().isBadRequest());

		
	}

}
