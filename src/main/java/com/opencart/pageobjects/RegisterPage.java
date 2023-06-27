package com.opencart.pageobjects;

import com.opencart.managers.ScrollManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends Page{
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='input-firstname']")
    private WebElement firstNameImput;
    @FindBy(xpath = "//input[@id='input-lastname']")
    private WebElement lastNameInput;
    @FindBy(xpath = "//input[@id='input-email']")
    private WebElement emailInput;
    @FindBy(xpath = "//input[@id='input-password']")
    private WebElement passwordInput;
    @FindBy(xpath = "//input[@name='agree']")
    private WebElement privacyPolacy;
    @FindBy(xpath = "//button[normalize-space()='Continue']")
    private WebElement continueButton;

    public void fillInTheRegisterForm(String firstName, String lastName, String email, String password) {
        firstNameImput.sendKeys(firstName);
        System.out.println("The entered first name is: " + firstName);
        lastNameInput.sendKeys(lastName);
        System.out.println("The entered last name is: " + lastName);
        emailInput.sendKeys(email);
        System.out.println("The entered email is:" + email);
        passwordInput.sendKeys(password);
        System.out.println("The entered password is:" + password);
    }

    public void switchOnThePrivacyPolacy(WebDriver driver) throws InterruptedException {
        ScrollManager.scrollToElement(driver, privacyPolacy);
        privacyPolacy.click();
    }

    public void clickOnContinueButton() {
        continueButton.click();
    }
}
