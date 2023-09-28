package restTests;

import static io.restassured.RestAssured.DEFAULT_SESSION_ID_VALUE;
import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static TestDataFiles.Payload.addPlacePayload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class AddPlace {

	@Test(dataProvider = "PlaceData")
	public void addPlace(String addressOfPlace, String language, ITestContext context) {

		RestAssured.baseURI = "https://rahulshettyacademy.com";
		// to bypass ssl certificate(PKIX error can be avoided)
		RestAssured.useRelaxedHTTPSValidation();
		System.out.println("Starting Add place.....................");
		// add
		Map<String, Object> headerMap= new HashMap<String,Object>();
		headerMap.put("Content-Type", "application/json");
		headerMap.put("Connection", "keep-alive");
		String response = given().queryParam("key", "qaclick123").headers(headerMap)
				.body(addPlacePayload(addressOfPlace, language)).when().post("maps/api/place/add/json").then().log().all()
				.assertThat().statusCode(200).extract().asString();
		
		//body("scope", equalTo("APP"))
		//.header("server", equalTo("Apache/2.4.41 (Ubuntu)"))
		System.out.println(response);
		JsonPath js = new JsonPath(response);
		String place_id = js.getString("place_id");
		System.out.println(place_id);
		context.setAttribute("placeId", place_id);
		//context.setAttribute("place_id", place_id);
		System.out.println(context.getAttribute("placeId"));
		System.out.println("completing Add place...........");
	}

	@DataProvider(name = "PlaceData")
	public Object[][] getData() {
		return new Object[][] { { "29, side layout, cohen 09", "French-IN" }
				//{ "41, First Street, cohen 09", "Tamil-IN" }
		};
	}
}
