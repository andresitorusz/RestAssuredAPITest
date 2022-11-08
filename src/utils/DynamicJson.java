package utils;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;

public class DynamicJson {
	
	private static String code = "AS";

	@Test(dataProvider = "Data")
	public static void addBook(String isbn, String aisle) {
		RestAssured.baseURI = "http://216.10.245.166";

		given().log().all().header("Content-Type", "application/json")
			.body(Payload.AddBook("Learning API Testing", code, isbn, aisle)).when().post("Library/Addbook.php")
			.then().log().all().assertThat().statusCode(200)
			.extract().response().asString();
	}
	
	@DataProvider(name="Data")
	public Object[][] getData() {
		// Array = collection of elements
		// Multidimensional array = collection of arrays
		return new Object[][] {{"XXXX","9090"}, {"YYYY","8080"}, {"ZZZZ","7070"}};
	}
}
