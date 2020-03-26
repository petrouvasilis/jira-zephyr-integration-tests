package com.intrasoft.stsc.web_pages;

import com.intrasoft.stsc.test_utils.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class Home extends BaseTest {

    @FindBy(xpath = "//h1//*[contains(@class,'wordmark')]")
    WebElement wordmark;
    @FindBy(xpath = "//h1//*[contains(@class,'slogan')]")
    WebElement slogan;
    @FindBy(id = "searchInput")
    WebElement searchInput;
    @FindBy(xpath = "//i[text()='Search']/ancestor::button[@type='submit'][1]")
    WebElement searchButton;

    public Home() {
        initPageFactory();
        waitForLoad();
    }

    public Home verifyWorkmark(String expectedWordmark) {
        Assert.assertEquals(wordmark.getText(), expectedWordmark);
        return this;
    }

    public Home verifySlogan(String expectedSlogan) {
        Assert.assertEquals(slogan.getText(), expectedSlogan);
        return this;
    }

    public Home verifySearchInput() {
        Assert.assertTrue(isElementPresent(By.id("searchInput")));
        return this;
    }

    public Home search(String keyword) {
        searchInput.sendKeys(keyword);
        searchButton.click();
        waitForLoad();
        return this;
    }

}
