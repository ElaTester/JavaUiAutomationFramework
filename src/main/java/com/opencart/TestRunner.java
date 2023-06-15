package com.opencart;

import com.opencart.managers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

public class TestRunner {
    public static void main(String[] args) throws InterruptedException {
        // Define a driver object that will be used for future actions.
        WebDriver driver = DriverManager.getInstance().getDriver();

        driver.get("https://mvnrepository.com/");

        String currentWindowName = driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.TAB);

        driver.get("https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-chrome-driver");

        driver.close();

        driver.switchTo().window(currentWindowName);

        driver.get("https://diez.md/");

        driver.quit();

        System.out.println("The execution was finished");
    }
}