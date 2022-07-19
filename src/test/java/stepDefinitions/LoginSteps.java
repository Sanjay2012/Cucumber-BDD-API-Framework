package stepDefinitions;

import org.junit.runner.RunWith;

import io.cucumber.java.en.*;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
public class LoginSteps {

	@Given("user on applications login page")
	public void user_on_applications_login_page() {
	  System.out.println("User on login page"); 
	}
	@When("user entered valid username and password")
	public void user_entered_valid_username_and_password() {
		System.out.println("User entered valid credentials");
	}
	@When("click on login button")
	public void click_on_login_button() {
		System.out.println("User click on login button");
	}
	@Then("user should be land on user dashboard page")
	public void user_should_be_land_on_user_dashboard_page() {
		System.out.println("User land on profile page");
	}

	@Then("user can see his card status as {string}")
	public void user_can_see_his_card_status_as(String string) {
	    System.out.println("User can see card status");
	}

	@When("user entered valid username as {string} and password as {string}")
	public void user_entered_valid_username_as_and_password_as(String string, String string2) {
	    System.out.println("User entered valod username and password");
	}










}
