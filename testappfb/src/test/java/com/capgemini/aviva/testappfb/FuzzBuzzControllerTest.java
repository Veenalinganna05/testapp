package com.capgemini.aviva.testappfb;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import static com.github.tomakehurst.wiremock.client.WireMock.*;

@SpringBootTest(classes = FizzBuzzController.class)
@RunWith(SpringRunner.class)
public class FuzzBuzzControllerTest {

	TestRestTemplate restTemplate;

	@Rule
	public WireMockRule wireMockRule = new WireMockRule(8089);

	@Before

	public void setup() throws Exception {

		restTemplate = new TestRestTemplate();
		stubFor(get(urlEqualTo("/fizzbuzz/8"))
			
				                .willReturn(aResponse()
				
				                        .withStatus(HttpStatus.OK.value())));


	}

	@Test
	    public void getFizzBuzz() {
		
	  ResponseEntity response = restTemplate.getForEntity("http://localhost:8080/fizzbuzz/8", String.class);
	
	        assertTrue("Verify Status Code", response.getStatusCode().equals(HttpStatus.OK));

	    }

	 

}
