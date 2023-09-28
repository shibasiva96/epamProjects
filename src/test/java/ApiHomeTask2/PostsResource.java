package ApiHomeTask2;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class PostsResource {
	
	
	@Test
	public void addPosts() {

		RestAssured.baseURI = "https://jsonplaceholder.typicode.com/posts";
		// to bypass ssl certificate(PKIX error can be avoided)
		RestAssured.useRelaxedHTTPSValidation();
		// add
		//only getting id while calling post method but in postman getting different response
		given()//.header("Content-Type", "application/json")
				.body("  {\r\n"
						+ "        \"userId\": 20,\r\n"
						+ "        \"id\": 101,\r\n"
						+ "        \"title\": \"api test\",\r\n"
						+ "        \"body\": \"api test4567\"\r\n"
						+ "    }").when().post().then().log().everything();
	
		/*Assert.assertEquals(response.statusCode(), 201);
		//Assert.assertEquals(response.path("userId"), 20);
		Assert.assertEquals(response.path("id"), 101);
		Assert.assertEquals(response.path("title"), "api test");
		Assert.assertEquals(response.path("body"), "api test4567");*/
	}
	@Test
	public void getPosts() {

		RestAssured.baseURI = "https://jsonplaceholder.typicode.com/posts";
		// to bypass ssl certificate(PKIX error can be avoided)
		RestAssured.useRelaxedHTTPSValidation();
		
		Response response1=given().when().get();
		
		//could see only 10 users in postman
		JsonPath js = new JsonPath(response1.asString());
		int countOfUsers = js.getInt("size()");
		System.out.println("No. of users: "+countOfUsers);
		Assert.assertEquals(countOfUsers,100);
		
		
		Response response=given().when().get("/1");
		//Assert.assertEquals(given().when().get("/1").path("userId"),1);
		// add
	
		Assert.assertEquals(response.statusCode(), 200);
		Assert.assertEquals(response.path("userId"), "1");
		Assert.assertEquals(response.path("id"), "1");
		Assert.assertEquals(response.path("title"), "sunt aut facere repellat provident occaecati excepturi optio reprehenderit");
		Assert.assertEquals(response.path("body"), "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto");
	}
	@Test
	public void deletePosts() {

		RestAssured.baseURI = "https://jsonplaceholder.typicode.com/posts";
		// to bypass ssl certificate(PKIX error can be avoided)
		RestAssured.useRelaxedHTTPSValidation();
		
	
		Response response=given().when().delete("/101");
		// add
	
		Assert.assertEquals(response.statusCode(), 200);

	}
	

}
