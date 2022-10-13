package files;

import io.restassured.path.json.JsonPath;

public class Util {
	
	public static JsonPath RawToJson(String response) {
		JsonPath jsonPath = new JsonPath(response);
		return jsonPath;
	}

}
