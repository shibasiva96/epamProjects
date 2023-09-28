package ApiHomeTask1;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import Model.Place;
import TestDataFiles.Payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class AddPet {
	
	@Test
	public void addPet() {

		RestAssured.baseURI = "https://petstore.swagger.io/v2";
		// to bypass ssl certificate(PKIX error can be avoided)
		RestAssured.useRelaxedHTTPSValidation();
		// add
		given().log().all().header("Content-Type", "application/json")
				.body("{\r\n"
						+ "  \"id\": 12345,\r\n"
						+ "  \"category\": {\r\n"
						+ "    \"id\": 1,\r\n"
						+ "    \"name\": \"dog\"\r\n"
						+ "  },\r\n"
						+ "  \"name\": \"snoopie\",\r\n"
						+ "  \"photoUrls\": [\r\n"
						+ "    \"string\"\r\n"
						+ "  ],\r\n"
						+ "  \"tags\": [\r\n"
						+ "    {\r\n"
						+ "      \"id\": 0,\r\n"
						+ "      \"name\": \"string\"\r\n"
						+ "    }\r\n"
						+ "  ],\r\n"
						+ "  \"status\": \"pending\"\r\n"
						+ "}\r\n"
						+ "").when().post("/pet").then()
				.assertThat().statusCode(200);
	
		Response response=given().log().all().when().get("/pet/12345");
		Assert.assertEquals(response.statusCode(), 200);
		Assert.assertEquals(response.contentType(), "application/json");
		Assert.assertEquals(response.path("category.name"), "dog");
		Assert.assertEquals(response.path("name"), "snoopie");
		Assert.assertEquals(response.path("status"), "pending");
		
		
		
	}

}
