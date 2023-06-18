package com.opencart;

import com.opencart.managers.DataFakeManager;
import com.opencart.managers.DriverManager;
import com.opencart.managers.ScrollManager;
import org.openqa.selenium.*;

public class TestRunner {
    public static void main(String[] args) throws InterruptedException {
        // Define a driver object that will be used for future actions.
        WebDriver driver = DriverManager.getInstance().getDriver();
        driver.get("https://www.google.com/");
        String currentWindowName = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.TAB);

        driver.get("https://andreisecuqa.host/");

        WebElement accountICon = driver.findElement(By.xpath("//i[@class='fa-solid fa-user']"));
        accountICon.click();

        WebElement registerBtn = driver.findElement(By.xpath("//a[normalize-space()='Register']"));
        registerBtn.click();

        String firstName = DataFakeManager.getRandomName();
        System.out.println("The generated first name is: " + firstName);

        String randomEmail = DataFakeManager.getRandomEmail();
        System.out.println("The generated email is: " + randomEmail);

        String lastName = DataFakeManager.getRandomName();
        System.out.println("The generated last name is: " + lastName);

        String randomPassword = DataFakeManager.getRandomPassword(20, 25);
        System.out.println("The generated password is: " + randomPassword);

        WebElement firstNameInput = driver.findElement(By.xpath("//input[@id='input-firstname']"));
        firstNameInput.sendKeys(firstName);

        WebElement lastNameInput = driver.findElement(By.xpath("//input[@id='input-lastname']"));
        lastNameInput.sendKeys(lastName);

        WebElement emailInput = driver.findElement(By.xpath("//input[@id='input-email']"));
        emailInput.sendKeys(randomEmail);

        WebElement passwordInput = driver.findElement(By.xpath("//input[@id='input-password']"));
        passwordInput.sendKeys(randomPassword);
        Thread.sleep(500);

        WebElement privacyCheckBox = driver.findElement(By.xpath("//input[@name='agree']"));
        ScrollManager.scrollToElement(driver, privacyCheckBox);
        privacyCheckBox.click();

        WebElement continueButton = driver.findElement(By.xpath("//button[normalize-space()='Continue']"));
        continueButton.click();
        Thread.sleep(1000);

        WebElement continueNavigate = driver.findElement(By.xpath("//a[normalize-space()='Continue']"));
        continueNavigate.click();
        Thread.sleep(1000);

        WebElement accountIconLogOut = driver.findElement(By.xpath("//i[@class='fa-solid fa-user']"));
        accountIconLogOut.click();

        WebElement logOutField = driver.findElement(By.xpath("//a[@class='dropdown-item'][normalize-space()='Logout']"));
        logOutField.click();

        WebElement logInButton = driver.findElement(By.xpath("//a[@class='list-group-item'][normalize-space()='Login']"));
        logInButton.click();

        WebElement emailLogIn = driver.findElement(By.xpath("//input[@id='input-email']"));
        emailLogIn.sendKeys(randomEmail);

        WebElement passwordLogIn = driver.findElement(By.xpath(" //input[@id='input-password']"));
        passwordLogIn.sendKeys(randomPassword);
        Thread.sleep(5000);

        //Created a button to log in to an existing customer.
        WebElement loginButton = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
        loginButton.click();
        Thread.sleep(5000);

        System.out.println(driver.getCurrentUrl());
        driver.close();
        driver.switchTo().window(currentWindowName);
        driver.get("https://andreisecuqa.host/");
        driver.quit();
        System.out.println("The execution was finished");
    }
}