package restTests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import TestDataFiles.Payload;
import io.restassured.RestAssured;

public class UpdatePlace {
	@Test
	public void updatePlace(ITestContext context) {

		RestAssured.baseURI = "https://rahulshettyacademy.com";
		// to bypass ssl certificate(PKIX error can't avoided)
		RestAssured.useRelaxedHTTPSValidation();
		String place_id = (String) context.getAttribute("placeId");
		System.out.println("place idklklklk: " + place_id);
		
		System.out.println("Starting Update place.....................");

		// update
		String newAddress = "70 winter walk, USA";
		given().queryParam("place_id", place_id).header("Content-Type", "application/json")
				.body(Payload.updatePlace(place_id, newAddress)).when().put("maps/api/place/update/json").then()
				.assertThat().statusCode(200).body("msg", equalTo("Address successfully updated"));
		System.out.println("Completing Update place.....................");
	}

}
