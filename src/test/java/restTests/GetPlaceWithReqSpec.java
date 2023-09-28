package restTests;

import static io.restassured.RestAssured.*;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import java.util.HashMap;
import java.util.Map;

import Model.Place;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetPlaceWithReqSpec {

	@BeforeTest
	public void setUp() {
		RestAssured.requestSpecification = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.setBasePath("/maps/api/place").addPathParam("getResource1", "get").addPathParam("getResource2", "json")
				.setContentType("application/json").setRelaxedHTTPSValidation().addQueryParam("key", "qaclick123")
				.addQueryParam("place_id", "619b45349c9ddbfc6d9dd414b4d03344").build();
		RestAssured.responseSpecification = new ResponseSpecBuilder().expectStatusCode(200)
				.expectContentType("application/json").
				 expectBody(matchesJsonSchemaInClasspath("PlaceSchema.json"))
				.expectBody("address",equalTo("70 winter walk, USA"))
				// .expectResponseTime(lessThan(2000L))
				.build();
	}

	@Test
	@JsonDeserialize(builder = Place.class)
	public void verifyAddress(ITestContext context) {
		// get
		Place place = when().get("/{getResource1}/{getResource2}").as(Place.class);
		String address = place.getAddress();
		Assert.assertEquals(address, "70 winter walk, USA");
	}

	@Test
	public void verifyLanguageDetails() {
		// get
		
		Response getResponse = when().get("/{getResource1}/{getResource2}");
		 when().get("/{getResource1}/{getResource2}").then().assertThat().header("server","Apache/2.4.41 (Ubuntu)");
		String language = getResponse.path("language");
		Assert.assertEquals(language, "French-IN");
	}

	@Test
	public void verifyName() {
		// get
		String getResponse = when().get("/{getResource1}/{getResource2}").then().extract().asString();
		JsonPath js1 = new JsonPath(getResponse);
		String name = js1.getString("name");
		Assert.assertEquals(name, "Frontline house");
	}

}
