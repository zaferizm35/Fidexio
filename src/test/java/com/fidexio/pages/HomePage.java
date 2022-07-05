package com.fidexio.pages;

import com.fidexio.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    public HomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[@class='oe_topbar_name']")
   public WebElement topBar;

    @FindBy(xpath = "//a[@data-menu='logout']") public WebElement logoutButton;

    @FindBy(xpath = "//span[@class='oe_topbar_name']")
    public WebElement UserIdButton;

    @FindBy(tagName = "h4") public WebElement AlertMessageOddo;
}