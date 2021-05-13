package com.cybercom.gustafbratt.kalender;

import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import io.restassured.module.mockmvc.response.MockMvcResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class KalenderApplicationTests {

	@Autowired
	private MockMvc mvc;

	@Test
	public void getRequest() {
		RestAssuredMockMvc.mockMvc(mvc);

		MockMvcResponse response = RestAssuredMockMvc.given()
				.contentType(ContentType.JSON)
				.when()
				.get("/hello")
				.then()
				.extract().response();

		Assertions.assertEquals(200, response.statusCode());
		Assertions.assertTrue(response.asString().contains("2021-05-13"));
	}
}
