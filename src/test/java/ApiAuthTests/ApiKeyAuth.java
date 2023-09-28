package ApiAuthTests;

import static io.restassured.RestAssured.when;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import Model.Place;
import io.restassured.RestAssured;
import io.restassured.authentication.BasicAuthScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ApiKeyAuth {
	@Test
	public void baseAuthTest() {	
		RestAssured.requestSpecification=new RequestSpecBuilder()
				.setBaseUri("https://api.football-data.org/")
				.setBasePath("v4/competitions/CL")
				.setRelaxedHTTPSValidation()
				.addHeader("X-Auth-Token", "4d0aefb5e2f8459a9a561fce907defb9")
				.build();
		when().get("/matches").then().log().all().statusCode(200);		
	}
	
}

