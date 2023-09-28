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

public class BasicAuthExample {
	@Test
	public void baseAuthTest() {
		
		BasicAuthScheme basicAuthScheme = new BasicAuthScheme();
		basicAuthScheme.setUserName("postman");
		basicAuthScheme.setPassword("password");
		
		RestAssured.requestSpecification=new RequestSpecBuilder()
				.setBaseUri("https://postman-echo.com")
				.setRelaxedHTTPSValidation()
				.setAuth(basicAuthScheme)
				.build();
		when().get("/basic-auth").then().statusCode(200);		
	}
	@Test
	public void baseAuthTest1() {
		RestAssured.baseURI ="https://postman-echo.com";
		RestAssured.useRelaxedHTTPSValidation();
		given().auth().preemptive().basic("postman", "password").when().get("/basic-auth").then().assertThat().statusCode(200);	
	}
	

	
}

