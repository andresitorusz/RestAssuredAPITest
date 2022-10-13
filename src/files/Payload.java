package files;

public class Payload {
	
	public static String AddPlace() {
		return "{\n"
				+ "    \"location\": {\n"
				+ "        \"lat\": -38.123456,\n"
				+ "        \"lng\": 33.123456\n"
				+ "    },\n"
				+ "    \"accuracy\": 50,\n"
				+ "    \"name\": \"Location Unknown\",\n"
				+ "    \"phone_number\": \"+(62) 821 7272 8267\",\n"
				+ "    \"address\": \"30, Side Layout, Cohen 09\",\n"
				+ "    \"types\": [\n"
				+ "        \"home\"\n"
				+ "    ],\n"
				+ "    \"website\": \"http://location-u.com\",\n"
				+ "    \"language\": \"Eng-IN\"\n"
				+ "}";
	}
	
	public static String UpdatePlace(String placeId, String newAddress) {
		return "{\n"
				+ "    \"place_id\": \"" + placeId + "\",\n"
				+ "    \"address\": \"" + newAddress + "\",\n"
				+ "    \"key\": \"qaclick123\"\n"
				+ "}";
	}

}
