package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlace;
import pojo.Location;

public class TestDataBuild {
	
	public AddPlace addPlacePayload() {
		AddPlace place = new AddPlace();

		place.setAccuracy(50);
		place.setName("Frontline house");
		place.setPhone_number("(+91) 983 893 3937");
		place.setAddress("70 winter walk, USA");
		place.setWebsite("http://google.com");
		place.setLanguage("French-IN");

		List<String> myList = new ArrayList<String>();
		myList.add("shoe park");
		myList.add("shop");
		place.setTypes(myList);

		Location l = new Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);

		place.setLocation(l);
		
		return place;
	}
	
	
	public AddPlace addPlaceBody(String name, String phone, String address, String site, String language, String type1, String type2, double lat, double lng) {
		AddPlace place = new AddPlace();

		place.setAccuracy(50);
		place.setName(name);
		place.setPhone_number(phone);
		place.setAddress(address);
		place.setWebsite(site);
		place.setLanguage(language);

		List<String> myList = new ArrayList<String>();
		myList.add(type1);
		myList.add(type2);
		place.setTypes(myList);

		Location l = new Location();
		l.setLat(lat);
		l.setLng(lng);

		place.setLocation(l);
		
		return place;
	}
	
	
	
	public String deletePayload(String placeId) {
		
	return("{\r\n"
			+ "\r\n"
			+ "    \"place_id\":\""+placeId+"\"\r\n"
			+ "}");
	}
	
	public String updatePayload(String placeId) {
		return("{\r\n"
				+ "\"place_id\":\""+placeId+"\",\r\n"
				+ "\"address\":\"White House, USA\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}");
	
	}

}
