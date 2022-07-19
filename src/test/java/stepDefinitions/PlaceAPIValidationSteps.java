package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIresources;
import resources.TestDataBuild;
import resources.Utils;

public class PlaceAPIValidationSteps extends Utils {

	RequestSpecification request;
	ResponseSpecification res;
	Response response;
	static String placeId;

	TestDataBuild data = new TestDataBuild();
	
	@Given("add place paylod")
	public void add_place_paylod() {

		request = given().spec(requestSpecification()).
				body(data.addPlacePayload());

	}

	@When("user calls {string} with {string} http request")
	public void user_calls_with_http_request(String resource, String method) {
		
		APIresources APIresource = APIresources.valueOf(resource);
		
		res = new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();

		if(method.equalsIgnoreCase("POST"))
		response = request.when().post(APIresource.getResource());
		else if(method.equalsIgnoreCase("GET"))
			response = request.when().get(APIresource.getResource());
		else if(method.equalsIgnoreCase("PUT"))
			response = request.when().put(APIresource.getResource());
		else if(method.equalsIgnoreCase("DELETE"))
			response = request.when().delete(APIresource.getResource());
	
	}

	@Then("verify the status code as {int}")
	public void verify_the_status_code_as(Integer int1) {

		assertEquals(response.getStatusCode(), int1);
	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String key, String value) {
		
		assertEquals(getJsonPath(response, key), value);
	}

	@Given("add place paylod with {string} {string} {string} {string} {string} {string} {string} {double} {double}")
	public void add_place_paylod_with(String name, String phone, String address, String site, String language,
			String type1, String type2, double lat, double lng) {

		request = given().spec(requestSpecification())
				.body(data.addPlaceBody(name, phone, address, site, language, type1, type2, lat, lng));
	}
	

	@Then("validate place_Id created maps to {string} using {string}")
	public void validate_place_id_created_maps_to_using(String expectedName, String resource) {
	    
		placeId = getJsonPath(response, "place_id");
		
		request = given().spec(requestSpecification()).
				queryParam("place_id", placeId);
		System.out.println(request);
		
		user_calls_with_http_request(resource, "GET");
		
		String actualName = getJsonPath(response, "name");
		
		assertEquals(actualName,expectedName);
	}

	
	@Then("validate place_Id created in get request response")
	public void validate_place_id_created_in_get_request_response() {
		
		placeId = getJsonPath(response, "place_id");
		request = given().spec(requestSpecification()).
				queryParam("place_id", placeId);
		
		System.out.println(request);
		
		response = request.when().get("/maps/api/place/get/json");
		String actualName = getJsonPath(response, "name");
		assertEquals(actualName,"Frontline house");
		
	}

	@Given("deletePlace payload")
	public void delete_place_payload() {
		request = given().spec(requestSpecification()).
				body(data.deletePayload(placeId));
		
	}

	@Given("updatePlace payload")
	public void update_place_payload() {
		request = given().spec(requestSpecification()).
				body(data.updatePayload(placeId));
		
	}









}
