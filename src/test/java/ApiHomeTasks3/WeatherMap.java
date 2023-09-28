package ApiHomeTasks3;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class WeatherMap {
	
	@Test
	public void getWeather() {

		RestAssured.baseURI = "http://api.openweathermap.org/data/2.5";
		RestAssured.useRelaxedHTTPSValidation();
	
		Response response=given().queryParam("appid","c84981ff665da480d28b0e559ecc32e6").queryParam("lon", "78.4744").queryParam("lat", "17.3753").log().all().when().get("/weather");
		Assert.assertEquals(response.statusCode(), 200);
		Assert.assertEquals(response.path("name"), "Hyderabad");
		Assert.assertEquals(response.path("sys.country"), "IN");
		Assert.assertTrue(Float.parseFloat(response.path("main.temp_min").toString())>0);
		Assert.assertTrue(Float.parseFloat(response.path("main.temp_max").toString())>0);
	
		
		
		
	}

}
