package com.fidexio.step_definitions;

import com.fidexio.pages.FidexioLogInPage;
import com.fidexio.pages.HomePage;
import com.fidexio.pages.ResetPasswordPage;
import com.fidexio.utilities.BrowserUtils;
import com.fidexio.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogOutPage {
    FidexioLogInPage fidexioLogInPage = new FidexioLogInPage();
    HomePage homePage = new HomePage();

    ResetPasswordPage resetPasswordPage = new ResetPasswordPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 5);

    @When("user is at the home page")
    public void user_is_at_the_home_page() {

        wait.until(ExpectedConditions.visibilityOf(homePage.topBar));
        Assert.assertTrue(homePage.topBar.isDisplayed());
    }

    @When("user click the logOut button")
    public void user_click_the_log_out_button() {
        homePage.UserIdButton.click();
        homePage.logoutButton.click();
    }

    @Then("user is at login page")
    public void user_is_at_login_page() {
        Driver.getDriver().get("https://qa.fidexio.com");
//        wait.until(ExpectedConditions.visibilityOf(fidexioLogInPage.ResetPasswordButton));
//        Assert.assertTrue(fidexioLogInPage.ResetPasswordButton.isDisplayed());
    }


    @And("user click the step back button")
    public void userClickTheStepBackButton() {
        Driver.getDriver().navigate().back();
    }

    @Then("user should see alert message")
    public void userShouldSeeAlertMessage() {
        Assert.assertTrue(homePage.AlertMessageOddo.isDisplayed());
    }
}