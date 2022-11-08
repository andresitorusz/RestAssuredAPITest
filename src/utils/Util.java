package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import io.restassured.path.json.JsonPath;

public class Util {
	
	public static JsonPath RawToJson(String response) {
		JsonPath jsonPath = new JsonPath(response);
		return jsonPath;
	}
	
	public static String GenerateStringFromFile(String path) throws IOException {
		return new String(Files.readAllBytes(Paths.get(path)));
	}

}
