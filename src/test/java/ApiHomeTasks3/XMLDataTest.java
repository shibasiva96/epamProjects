package ApiHomeTasks3;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static org.hamcrest.Matchers.equalTo;
//for xml schema validation
import static io.restassured.matcher.RestAssuredMatchers.matchesXsdInClasspath;
import static io.restassured.matcher.RestAssuredMatchers.matchesDtd;

public class XMLDataTest {
	
	
	@Test
	public void verifyName()
	{
	
	RestAssured.baseURI = "https://petstore.swagger.io/v2";
	// to bypass ssl certificate(PKIX error can't avoided)
	RestAssured.useRelaxedHTTPSValidation();
   //get
	given().log().all().accept("application/xml").when()
				.get("/pet/1234").then().log().all().assertThat().statusCode(200)
				.body("Pet.name", equalTo("doggie")).body(matchesXsdInClasspath("xsdValidation.xsd"));
	}
	@Test
	public void verifyNameXml()
	{
	
	RestAssured.baseURI = "https://petstore.swagger.io/v2";
	// to bypass ssl certificate(PKIX error can't avoided)
	RestAssured.useRelaxedHTTPSValidation();
   //get
	given().log().all().accept("application/json").when()
				.get("/pet/1234").then().log().all().assertThat().statusCode(200)
				.body("name", equalTo("doggie")).body(matchesDtd(""));
	}
	}
