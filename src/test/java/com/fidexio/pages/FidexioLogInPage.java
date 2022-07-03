package com.fidexio.pages;

import com.fidexio.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FidexioLogInPage {

    public FidexioLogInPage(){
        PageFactory.initElements(Driver.getDriver(), this);

    }



    @FindBy(xpath = "//input[@id='login']")  WebElement UserNameInput;

    @FindBy(id = "password") WebElement passwordInput;


    @FindBy(xpath = "//button[contains(text(),'Log in')]") WebElement LoginButton;

    @FindBy(xpath = "//*[text() = 'Reset Password']")  WebElement ResetPasswordButton;



    @FindBy (xpath = "//p")
    public static WebElement AlertMessage;



    @FindBy(xpath = "//span[@class=\'oe_topbar_name\']")
    public WebElement UserIdButton;

    @FindBy(xpath = "//a[text()='Log out']")
    public WebElement LogOutButton;

    @FindBy (xpath = "//h4[@class='modal-title']")
    public WebElement SignOut_ThanInAlertMessage;




}
