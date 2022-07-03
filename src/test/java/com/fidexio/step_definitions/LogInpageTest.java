package com.fidexio.step_definitions;

import com.fidexio.pages.FidexioLogInPage;
import com.fidexio.utilities.ConfigurationReader;
import com.fidexio.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LogInpageTest {

    FidexioLogInPage logInPage = new FidexioLogInPage();
    @Given("user is on the login page")
    public void userIsOnTheLoginPage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @When("user enters valid username {string}")
    public void user_enters_valid_username(String string) {

    }
    @When("user enters valid password {string}")
    public void user_enters_valid_password(String string) {

    }
    @When("user clicks to login button")
    public void user_clicks_to_login_button() {

    }
    @Then("user sees {string} in the title")
    public void user_sees_in_the_title(String string) {

    }



}
