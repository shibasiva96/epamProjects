package restTests;

import static io.restassured.RestAssured.*;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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

public class GetPlace {

	@Test
	@JsonDeserialize(builder = Place.class)
	public void verifyAddress(ITestContext context) {
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String place_id = (String) context.getAttribute("placeId");
		// get
		Place place = given().queryParams("key", "qaclick123","place_id",place_id).
				header("ContentType","application/json").log().all().when().get("maps/api/place/get/json").as(Place.class);
		String address = place.getAddress();
		System.out.println("Address: "+address);
		Assert.assertEquals(address, "70 winter walk, USA");
	}

	

}
