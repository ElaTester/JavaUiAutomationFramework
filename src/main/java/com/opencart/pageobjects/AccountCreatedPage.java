package com.opencart.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountCreatedPage extends Page{
    public AccountCreatedPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//i[@class='fa-solid fa-user']")
    private WebElement logOutOption;

    public void setLogOutFromTheAccount() {
        myAccountButton.click();
        logOutOption.click();
        System.out.println("The user is logged out ");
    }
}
