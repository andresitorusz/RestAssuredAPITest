package main;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import files.Payload;


public class Runner {

	public static void main(String[] args) {
		
		// Validate if Add Place API is working as expected
		// Given - all input details
		// When - Submit the API
		// Then - Validate the response
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String response = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
			.body(Payload.AddPlace())
			.when().post("maps/api/place/add/json")
			.then().assertThat().statusCode(200).body("status", equalTo("OK")).body("scope", equalTo("APP"))
			.header("Server", "Apache/2.4.41 (Ubuntu)").extract().response().asString();
		
		System.out.println(response);
		
		JsonPath responseJson = new JsonPath(response);
		String placeId = responseJson.get("place_id");
		
		System.out.println(placeId);
		
	}
}
