package stepDefinitions;

import io.cucumber.java.Before;

public class Hooks {

	@Before("@updatePlaceAPI or @deletePlaceAPI")
	public void beforeScenario() {
		/**
		 * 
		 * execute when place id is null code to give place id
		 */

		PlaceAPIValidationSteps p = new PlaceAPIValidationSteps();
		
		if (PlaceAPIValidationSteps.placeId == null) {
			
			p.add_place_paylod_with("white house", "(+09) 589 563 7895", "USA", "www.madeeasy.com", "Latin",
					"Govt. residency", "President House", -35.235689, 32.231452);
			p.user_calls_with_http_request("addPlaceAPI", "POST");
			p.validate_place_id_created_maps_to_using("white house", "getPlaceAPI");

		}
	}

}
