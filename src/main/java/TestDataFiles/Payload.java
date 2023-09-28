package TestDataFiles;

public class Payload {
	
	public static String addPlacePayload(String address, String language) {
		return "{\r\n"
				+ "    	\"location\":{\r\n"
				+ "    	\"lat\" : -38.383498,\r\n"
				+ "    	\"lng\" : 33.427362\r\n"
				+ "    	},\r\n"
				+ "    	\"accuracy\":50,\r\n"
				+ "    	\"name\":\"Siva house\",\r\n"
				+ "    	\"phone_number\":\"(+91) 985 803 3887\",\r\n"
				+ "    	\"address\" : \"29, side layout, cohen 09\",\r\n"
				+ "    	\"types\": [\"shoe park\",\"shop\"],\r\n"
				+ "    	\"website\" : \"http://google.com\",\r\n"
				+ "    	\"language\" : \"English-IN\"\r\n"
				+ "}\r\n"
				+ "";
	}
	public static String updatePlace(String place_id,String address) {
		return "{\r\n"
				+ "\"place_id\":\""+place_id+"\",\r\n"
				+ "\"address\":\""+address+"\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}\r\n"
				+ "";	
	}
	public static String coursePrice() {
		return "{\r\n"
				+ "\"dashboard\": {\r\n"
				+ "\"purchaseAmount\": 910,\r\n"
				+ "\"website\": \"rahulshettyacademy.com\"\r\n"
				+ "},\r\n"
				+ "\"courses\": [\r\n"
				+ "{\r\n"
				+ "\"title\": \"Selenium Python\",\r\n"
				+ "\"price\": 50,\r\n"
				+ "\"copies\": 6\r\n"
				+ "},\r\n"
				+ "{\r\n"
				+ "\"title\": \"Cypress\",\r\n"
				+ "\"price\": 40,\r\n"
				+ "\"copies\": 4\r\n"
				+ "},\r\n"
				+ "{\r\n"
				+ "\"title\": \"RPA\",\r\n"
				+ "\"price\": 45,\r\n"
				+ "\"copies\": 10\r\n"
				+ "}\r\n"
				+ "]\r\n"
				+ "}";
	}
	
	

}
