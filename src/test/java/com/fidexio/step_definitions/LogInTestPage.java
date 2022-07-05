package com.fidexio.step_definitions;

import com.fidexio.pages.FidexioLogInPage;
import com.fidexio.pages.HomePage;
import com.fidexio.pages.ResetPasswordPage;
import com.fidexio.utilities.ConfigurationReader;
import com.fidexio.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LogInTestPage {
    FidexioLogInPage fidexioLogInPage = new FidexioLogInPage();
    HomePage homePage = new HomePage();

    ResetPasswordPage resetPasswordPage = new ResetPasswordPage();

    WebDriverWait wait= new WebDriverWait(Driver.getDriver(),5);

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
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

        fidexioLogInPage.UserNameInput.sendKeys("");
    }

    @And("user enters empty password")
    public void userEntersEmptyPassword() {
        fidexioLogInPage.passwordInput.sendKeys("");
    }

    @Then("user sees Please fill out this field message")
    public void userSeesPleaseFillOutThisFieldMessage() {

    }


    @When("user user click the reset password link")
    public void userUserClickTheResetPasswordLink() {
        fidexioLogInPage.ResetPasswordButton.click();
    }

    @Then("user land on the reset password page")
    public void userLandOnTheResetPasswordPage() {
        wait.until(ExpectedConditions.visibilityOf(resetPasswordPage.backToLogin));
        Assert.assertTrue(resetPasswordPage.backToLogin.isDisplayed());
    }

    @When("user enters username")
    public void userEntersUsername() {
        fidexioLogInPage.UserNameInput.sendKeys(ConfigurationReader.getProperty("username1"));
    }

    @And("user enters password")
    public void userEntersPassword() {
        fidexioLogInPage.passwordInput.sendKeys(ConfigurationReader.getProperty("password1"));
    }

    @And("user clicks to enter button")
    public void userClicksToEnterButton() {
        fidexioLogInPage.passwordInput.sendKeys(Keys.ENTER);
    }

    @Then("user goes to the home page")
    public void userGoesToTheHomePage() {
        Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
       Assert.assertTrue(homePage.topBar.getText().equalsIgnoreCase("Salesmanager35"));
    }

    @When("user enters username {string}")
    public void userEntersUsername(String arg0) {
        fidexioLogInPage.UserNameInput.sendKeys(arg0);
    }

    @And("user enters password {string}")
    public void userEntersPassword(String arg0) {
        fidexioLogInPage.passwordInput.sendKeys(arg0);
    }

    @Then("user see Please fill out this field message")
    public void user_see_please_fill_out_this_field_message() {
        Assert.assertTrue(fidexioLogInPage.UserNameInput.getAttribute("validationMessage").equalsIgnoreCase("Lütfen bu alanı doldurun."));
    }
    @Then("user sees Warning  message")
    public void userSeesWarningMessage() {
        Assert.assertTrue(fidexioLogInPage.AlertMessage.getText().equalsIgnoreCase("Wrong login/password"));
    }
}