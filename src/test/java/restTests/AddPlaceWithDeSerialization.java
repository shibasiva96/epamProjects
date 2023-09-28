package restTests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Model.Location;
import Model.Place;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class AddPlaceWithDeSerialization {

	@Test(dataProvider = "PlaceData")
	public void addPlace(String addressOfPlace, String language, ITestContext context) {

		RestAssured.baseURI = "https://rahulshettyacademy.com";
		// to bypass ssl certificate(PKIX error can't avoided)
		RestAssured.useRelaxedHTTPSValidation();

		Location location = new Location("-38.383494", "33.427362");
		Place place = new Place(location, "Frontline house", addressOfPlace, language,
				new String[] { "shoe park", "shop" }, "50", "(+91) 983 893 3937", "http://google.com");

		// add
		String response = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
				.body(place).when().post("maps/api/place/add/json").then().assertThat().statusCode(200)
				.body("scope", equalTo("APP"),"status",equalTo("OK")).header("server", equalTo("Apache/2.4.41 (Ubuntu)")).extract().asString();
		System.out.println(response);
		JsonPath js = new JsonPath(response);
		String place_id = js.getString("place_id");
		context.setAttribute("place_id", place_id);
	}

	@DataProvider(name = "PlaceData")
	public Object[][] getData() {
		return new Object[][] { { "29, side layout, cohen 09", "French-IN" },
				{ "41, First Street, cohen 09", "Tamil-IN" } };
	}
}
