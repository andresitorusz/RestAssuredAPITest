package main;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import static files.Const.*;
import static files.Payload.*;
import static files.Util.*;


public class Runner {

	public static void main(String[] args) {
		// BaseURI
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		// Validate if Add Place API is working as expected
		// Given - all input details
		// When - Submit the API
		// Then - Validate the response
		String postPlaceResponse = given().log().all().queryParam("key", Key()).header("Content-Type", "application/json")
			.body(AddPlace())
			.when().post("maps/api/place/add/json")
			.then().assertThat().statusCode(200).body("status", equalTo("OK")).body("scope", equalTo("APP"))
			.header("Server", "Apache/2.4.41 (Ubuntu)").extract().response().asString();
		
		JsonPath postResponseJson = RawToJson(postPlaceResponse);
		String placeId = postResponseJson.get("place_id");
		
		// Validate if Update Place API is working as expected
		// Given - all input details
		// When - Submit the API
		// Then - Validate the response
		String newAddress = "10, Side Layout, Bremen 77";

		given().log().all().queryParam("key", Key()).header("Content-Type", "application/json")
			.body(UpdatePlace(placeId, newAddress))
			.when().put("maps/api/place/update/json")
			.then().assertThat().log().all().statusCode(200).body("msg", equalTo(UpdateSuccessMessage()));
		
		// Validate if Get Place API is working as expected
		// Given - all input details
		// When - Submit the API
		// Then - Validate the response and the updated data above
		String getPlaceResponse = given().log().all().queryParam("key", Key())
			.queryParam("place_id", placeId)
			.when().get("maps/api/place/get/json")
			.then().assertThat().log().all().statusCode(200).extract().response().asString();
		
		JsonPath getResponseJson = RawToJson(getPlaceResponse);
		String actualAddress = getResponseJson.get("address");
		
		Assert.assertEquals(actualAddress, newAddress);
		
	}
}
