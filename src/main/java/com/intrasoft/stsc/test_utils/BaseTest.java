package com.intrasoft.stsc.test_utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;

public class BaseTest {

    public static WebDriver driver;
    public static Wait wait;
    public static Page page;

    @BeforeTest
    public void beforeTest() {
        //OPEN BROWSER AND APPLICATION URL
        try {
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.chrome());
        } catch (MalformedURLException e) {
            e.printStackTrace();
            System.setProperty("webdriver.chrome.driver", getResourcesPath() + "/chromedriver.exe");
            driver = new ChromeDriver();
        }

        // define a global wait variable (e.g. 10 seconds until test fail)
        wait = new WebDriverWait(driver, 10);

        page = new Page();

        // navigate to web application
        driver.get("http://www.wikipedia.org/");

    }

    @AfterTest
    public void afterTest() {
        //CLOSE BROWSER
        driver.quit();
    }

    public static String getResourcesPath() {
        String filePathString = getAbsolutePath() + "/src/main/resources";
        File f = new File(filePathString);
        if (!f.exists())
            filePathString = getAbsolutePath();
        return filePathString;
    }

    private static String getAbsolutePath() {
        String absPath = Paths.get(".").toAbsolutePath().normalize().toString();
        return absPath.replace("\\", "/");
    }

    /**
     * This is method is used for dynamic waits until the page is loaded
     */
    public void waitForLoad() {
        ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
                    }
                };
        try {
            Thread.sleep(500);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }

    /**
     * This is a method that return if an element exists or not
     *
     * @param by is the element locator
     * @return true when an element exists, false for the opposite
     */
    public Boolean isElementPresent(By by) {
        if (driver.findElements(by).size() > 0)
            return true;
        else
            return false;
    }

    /**
     * This method instantiates the Page Object Elements
     */
    protected void initPageFactory() {
        PageFactory.initElements(driver, this);
    }

}
