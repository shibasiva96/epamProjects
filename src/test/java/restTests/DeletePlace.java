package restTests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import io.restassured.RestAssured;

public class DeletePlace {
	@Test
	public void deletePlace(ITestContext context) {

		RestAssured.baseURI = "https://rahulshettyacademy.com";
		// to bypass ssl certificate(PKIX error can't avoided)
		RestAssured.useRelaxedHTTPSValidation();
		String place_id = (String) context.getAttribute("placeId");
		System.out.println("place idklklklk: " + place_id);

		System.out.println("Starting Deleting place.....................");
		// delete
		given().log().all().queryParam("key", "qaclick123").headers("Content_Type", "application/json")
				.body("{\r\n" + "    \"place_id\":\"" + place_id + "\"\r\n" + "}\r\n" + "").when()
				.post("maps/api/place/delete/json").then().assertThat().statusCode(200).body("status", equalTo("OK"));
		
		System.out.println("Completing delete place.....................");
	}

}
