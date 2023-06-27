package com.opencart;

import com.opencart.managers.DataFakeManager;
import com.opencart.managers.DriverManager;
import com.opencart.managers.ScrollManager;
import com.opencart.pageobjects.AccountCreatedPage;
import com.opencart.pageobjects.HomePage;
import com.opencart.pageobjects.RegisterPage;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestRunner {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverManager.getInstance().getDriver();
        driver.get("https://andreisecuqa.host/");

        HomePage homePage = new HomePage(driver);
        homePage.navigateToRegisterPage();


        String firstName = DataFakeManager.getRandomName();
        String lastName = DataFakeManager.getRandomName();
        String randomEmail = DataFakeManager.getRandomEmail();
        String randomPassword = DataFakeManager.getRandomPassword(20, 25);

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.fillInTheRegisterForm(firstName, lastName, randomEmail, randomPassword);
        registerPage.switchOnThePrivacyPolacy(driver);
        registerPage.clickOnContinueButton();
        Thread.sleep(1500);
        System.out.println(driver.getCurrentUrl());

        AccountCreatedPage accountCreatedPage = new AccountCreatedPage(driver);
        accountCreatedPage.setLogOutFromTheAccount();
        Thread.sleep(2000);
        System.out.println(driver.getCurrentUrl());

        driver.quit();
        System.out.println("The execution was finished");
    }
}