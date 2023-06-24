package com.opencart;

import com.opencart.managers.DataFakeManager;
import com.opencart.managers.DriverManager;
import com.opencart.pageobjects.HomePage;
import com.opencart.pageobjects.RegisterPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

public class TestRegistrationFlowWithJunit {
    static WebDriver driver;
    HomePage homePage;
    RegisterPage registerPage;

    @BeforeAll
    public static void beforAll() {
        System.out.println("The execution starts");
    }

    @BeforeEach
    public void beforEach() {
        driver = DriverManager.getInstance().getDriver();
        driver.get("https://andreisecuqa.host/");
        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
    }

    @Test
    @DisplayName("The registration of a new user with valid data is successfull")
    public void registerUserWithValidData() throws InterruptedException {
        driver = DriverManager.getInstance().getDriver();
        homePage.navigateToRegisterPage();

        String firstName = DataFakeManager.getRandomName();
        String lastName = DataFakeManager.getRandomName();
        String randomEmail = DataFakeManager.getRandomEmail();
        String randomPassword = DataFakeManager.getRandomPassword(20, 25);
        registerPage.fillInTheRegisterForm(firstName, lastName, randomEmail, randomPassword);
        registerPage.switchOnThePrivacyPolacy(driver);
        registerPage.clickOnContinueButton();
        Thread.sleep(2000);

        boolean urlContainsSuccessKeyWord = driver.getCurrentUrl().contains("success");
        Assertions.assertTrue(urlContainsSuccessKeyWord, "The Url contains Success within it");
    }

    @Test
    @DisplayName("User remains on the register page whe he/she uses invalid password for register flow")
    public void registerUserWithInvalidPassword() throws InterruptedException {
        driver = DriverManager.getInstance().getDriver();
        homePage.navigateToRegisterPage();

        String firstName = DataFakeManager.getRandomName();
        String lastName = DataFakeManager.getRandomName();
        String randomEmail = DataFakeManager.getRandomEmail();
        String randomPassword = DataFakeManager.getRandomPassword(20, 25);
        registerPage.fillInTheRegisterForm(firstName, lastName, randomEmail, randomPassword);
        registerPage.switchOnThePrivacyPolacy(driver);
        registerPage.clickOnContinueButton();
        Thread.sleep(2000);

        boolean urlContainsSuccessKeyWord = driver.getCurrentUrl().contains("success");
        Assertions.assertTrue(urlContainsSuccessKeyWord, "The Url doesn't contains Success within it");
    }

    @AfterEach
    public void afterEachTestExecution() {
        DriverManager.getInstance().quiteTheDriver();
        System.out.println("The test case is finished");
    }

    @AfterAll
    public static void afterExecution() {
        System.out.println("The execution is finished");
    }
}
