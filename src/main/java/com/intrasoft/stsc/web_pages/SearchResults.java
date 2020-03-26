package com.intrasoft.stsc.web_pages;

import com.intrasoft.stsc.test_utils.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class SearchResults extends BaseTest {

    @FindBy(id = "firstHeading")
    WebElement heading;

    public SearchResults() {
        initPageFactory();
        waitForLoad();
    }

    public SearchResults verifySearchResultsOpens() {
        Assert.assertTrue(heading.getText().contains("Search results"));
        return this;
    }

    public SearchResults verifySearchResultsContent(String keyword) {
        int total = driver.findElements(By.xpath("//li[@class='mw-search-result']")).size();
        for (int i = 1; i <= total; i++) {
            Assert.assertTrue(
                    driver.findElement(
                            By.xpath("(//li[@class='mw-search-result'])[" + i + "]"))
                            .getAttribute("innerHTML").toLowerCase()
                            .contains(keyword.toLowerCase()));
            System.out.println(i);
        }
        return this;
    }


}
