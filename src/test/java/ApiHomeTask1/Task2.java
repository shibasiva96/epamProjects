package ApiHomeTask1;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import Model.Location;
import Model.Place;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import userModel.User;

public class Task2 {
	
	@Test
	public void getUsers() {

		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
		RestAssured.useRelaxedHTTPSValidation();
	
		String response=given().log().all().when().get("/users").then().statusCode(200).extract().asString();
		JsonPath js = new JsonPath(response);
		int countOfUsers = js.getInt("id.size()");
		System.out.println("No. of users: "+countOfUsers);
		Assert.assertTrue(countOfUsers>3);
	}
	@Test
	public void verifyUserExistence() {

		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
		RestAssured.useRelaxedHTTPSValidation();
		String response=given().when().get("/users").then().log().all().statusCode(200).extract().asString();
		Assert.assertTrue(response.contains("Ervin Howell"));
		 JsonPath j = new JsonPath(response);

	      //get values of JSON array after getting array size
	      int s = j.getInt("id.size()");
	      boolean matchFound=false;  
	      
	      for(int i = 0; i < s; i++) {
	    	  String state = j.getString("["+i+"].name");
	    	  if(state.contains("Ervin Howell"))
	    	  {
	    		  matchFound=true;
	    		  break;
	    	  }
	      }
		Assert.assertTrue(matchFound);
		}
	@Test
	public void verifyUserExistenceWithJava8() {

		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
		RestAssured.useRelaxedHTTPSValidation();
		User[] userResponse=given().when().get("/users").then().log().all().statusCode(200).extract().as(User[].class);
		List<User> listOfUsers=Arrays.asList(userResponse);
		String matchFound=listOfUsers.stream().map(User::getName).filter(user->user.equals("Ervin Howell")).findAny().orElse(null);
	    boolean matchFound1=listOfUsers.stream().map(User::getName).anyMatch(user->user.equals("Ervin Howell"));
		Assert.assertEquals(matchFound, "Ervin Howell");
		Assert.assertTrue(matchFound1);
		Assert.assertTrue(listOfUsers.stream().map(User::getName).anyMatch(user->user.equals("Ervin Howell")));
	      //get values of JSON array after getting array size
		}
	@Test
	public void verifyUserExistenceWithObjectMapper() {

		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
		RestAssured.useRelaxedHTTPSValidation();
		ObjectMapper mapper=new ObjectMapper();
		String response=given().when().get("/users").then().log().all().statusCode(200).extract().asString();
		User[] userResponse =null;
		try {
			userResponse = mapper.readValue(response,User[].class);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assert userResponse != null;
		List<User> listOfUsers=Arrays.asList(userResponse);
		listOfUsers.forEach(System.out::println);
		String matchFound=listOfUsers.stream().map(user->user.getName()).filter(user->user.equals("Ervin Howell")).findAny().orElse(null);
	    boolean matchFound1=listOfUsers.stream().map(user->user.getName()).anyMatch(user->user.equals("Ervin Howell"));
		Assert.assertEquals(matchFound, "Ervin Howell");
		Assert.assertTrue(matchFound1);
		Assert.assertTrue(listOfUsers.stream().map(user->user.getName()).filter(user->user.equals("Ervin Howell")).findAny().isPresent());
	      //get values of JSON array after getting array size
		}
	@Test
	public void verifyUserExistenceWithObjectMapperList() throws JsonMappingException, JsonProcessingException {

		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
		RestAssured.useRelaxedHTTPSValidation();
		ObjectMapper mapper=new ObjectMapper();
		String response=given().when().get("/users").then().log().all().statusCode(200).extract().asString();
		List<User> listOfUsers = mapper.readValue(response, new TypeReference<List<User>>(){});
		String matchFound=listOfUsers.stream().map(user->user.getName()).filter(user->user.equals("Ervin Howell")).findAny().orElse(null);
	    Boolean matchFound1=listOfUsers.stream().map(user->user.getName()).anyMatch(user->user.equals("Ervin Howell"));
		Assert.assertEquals(matchFound, "Ervin Howell");
		Assert.assertTrue(matchFound1);
		
		Assert.assertTrue(listOfUsers.stream().map(user->user.getName()).filter(user->user.equals("Ervin Howell")).findAny().isPresent());
		//listOfUsers.entrySet().stream().sorted(Entry.comparingByKey(Comparator.reverseOrder())).forEach(System.out::println);
	      //get values of JSON array after getting array size
		}
	@Test
	 public void verifyUserExistenceWithObjectMapperMap() throws JsonMappingException, JsonProcessingException {

		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
		RestAssured.useRelaxedHTTPSValidation();
		ObjectMapper mapper=new ObjectMapper();
		String response=given().when().get("/users").then().statusCode(200).extract().asString();
	//	mapper.configure(
		//	    DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		@SuppressWarnings("unchecked")
	//	Map<String,Object>[] listOfUsers= mapper.readValue(response,HashMap[].class);
		List<Map<String,Object>> listOfUsers= mapper.readValue(response,ArrayList.class);
		
		for(Map map:listOfUsers)
		{
			System.out.println(map.get("name"));
		}
	//	System.out.println(listOfUsers[0].get("name"));
		
		//HashMap[] listOfUsers= mapper.readValue(response,HashMap[].class);
		//Map<String,Object> listOfUsers1 = mapper.readValue(response,
			//    new TypeReference<HashMap<String,Object>>(){});
		//System.out.println(listOfUsers1);
		
		//listOfUsers.entrySet().forEach(entry -> {
		  //  System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
		//}); 

		}
}
