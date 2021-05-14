package com.cybercom.gustafbratt.kalender;

import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import io.restassured.module.mockmvc.response.MockMvcResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.*;


@AutoConfigureMockMvc
@ActiveProfiles("apitest")
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class KalenderApplicationTests {

	@Autowired
	protected WebApplicationContext wac;

	@BeforeEach
	public void setUp(){
		webAppContextSetup(wac);
	}

	@Test
	public void enHelgdag() {
		MockMvcResponse response = RestAssuredMockMvc.given()
				.queryParam("start", "2021-05-12")
				.queryParam("dagar", 1)
				.contentType(ContentType.JSON)
				.when()
				.get("/api/v1/kalender/framtidadatum")
				.then()
				.extract().response();

		System.out.println("=======");
		System.out.println(response.asString());
		Assertions.assertEquals(200, response.statusCode());
		Assertions.assertTrue(response.asString().contains("2021-05-14"));
	}

	@Test
	public void ogiltigtDatum() {
		MockMvcResponse response = RestAssuredMockMvc.given()
				.queryParam("start", "rappakalja")
				.queryParam("dagar", 1)
				.contentType(ContentType.JSON)
				.when()
				.get("/api/v1/kalender/framtidadatum")
				.then()
				.extract().response();

		System.out.println("=======");
		System.out.println(response.asString());
		Assertions.assertEquals(400, response.statusCode());
	}

}
