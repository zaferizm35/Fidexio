package com.fidexio.step_definitions;

import com.fidexio.pages.FidexioLogInPage;
import com.fidexio.pages.HomePage;
import com.fidexio.utilities.ConfigurationReader;
import com.fidexio.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LogInTestPage {
    FidexioLogInPage fidexioLogInPage = new FidexioLogInPage();
    HomePage homePage = new HomePage();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @When("user enters  username {string}")
    public void user_enters_username(String string) {
        fidexioLogInPage.UserNameInput.sendKeys(string);
    }

    @When("user enters  password {string}")
    public void user_enters_password(String string) {
        fidexioLogInPage.passwordInput.sendKeys(string);
    }

    @When("user clicks to login button")
    public void user_clicks_to_login_button() {
        fidexioLogInPage.LoginButton.click();
    }

    @Then("user sees {string} in the title")
    public void user_sees_in_the_title(String string) {
        Assert.assertTrue(homePage.topBar.getText().equalsIgnoreCase(string));
    }

    @Then("user sees Wrong login\\/password  message")
    public void userSeesWrongLoginPasswordMessage() {
        Assert.assertTrue(fidexioLogInPage.AlertMessage.getText().equalsIgnoreCase("Wrong login/password"));
    }


    @When("user enters empty username")
    public void userEntersEmptyUsername() {

        fidexioLogInPage.UserNameInput.sendKeys("   ");
    }

    @And("user enters empty password")
    public void userEntersEmptyPassword() {
        fidexioLogInPage.passwordInput.sendKeys("     ");
    }

    @Then("user sees Please fill out this field message")
    public void userSeesPleaseFillOutThisFieldMessage() {
        Assert.assertTrue(fidexioLogInPage.UserNameInput.getAttribute("validationMessage:").equalsIgnoreCase("Lütfen bu alanı doldurun."));
    }
}