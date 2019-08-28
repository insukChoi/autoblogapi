package com.bengaluru.autoblogapi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AutoblogapiApplicationTests {


	private static RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();

	@Test
	public void contextLoads() {

		assertNotNull(restTemplateBuilder.build());
	}

}
