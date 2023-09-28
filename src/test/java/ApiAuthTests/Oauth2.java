package ApiAuthTests;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import Model.Place;
import io.restassured.RestAssured;

public class Oauth2 {
		
	@Test
	public void test()
	{
		//RestAssured.baseURI = "https://api.github.com";
		RestAssured.useRelaxedHTTPSValidation();
		// get
		given().auth().oauth2("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").
				header("ContentType","application/json")
	    .when()
	    	//.get("https://api.github.com/users/shibasiva96").then().log().all().assertThat().statusCode(200);
	    .get("https://api.github.com/repos/shibasiva96/udemy").then().log().all().assertThat().statusCode(200);
		
		
		///orgs/{org}/repos

	}

}
