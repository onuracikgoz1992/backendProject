package com.example.project;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.nio.charset.Charset;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {ProjectApplication.class})
@AutoConfigureMockMvc
@ContextConfiguration(classes = {User.class})
public class ProjectApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	private ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
	@Test
	public void contextLoads() throws Exception {

		this.mockMvc.perform(post("/test")).andDo(print()).andExpect(status().isOk());
//				.andExpect((ResultMatcher) content().string(containsString("onur")));

//		mockMvc.perform(post("/employees")
//				.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
//				.content(ow.writeValueAsString("onur")))
//				.andDo(print())
//				.andExpect(status().is(HttpStatus.CREATED.value()));
	}

}
