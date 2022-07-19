package resources;

/**
 * enum is special class in java which has collection of constants and methods
 * 
 * Note: we can handle it using class by declaring String for all resources
 * 		and after that write a getter methods for all resources
 *
 */
public enum APIresources {
	
	addPlaceAPI("/maps/api/place/add/json"),
	getPlaceAPI("/maps/api/place/get/json"),
	updatePlaceAPI("/maps/api/place/update/json"),
	deletePlaceAPI("/maps/api/place/delete/json");
	
	
	private String resource;

	private APIresources(String resource) {
		this.resource = resource;
	}

	public String getResource() {
		return resource;
	}

}
