package com.browserstack;

import com.app.flipkart.pages.HomePage;
import com.app.flipkart.pages.LandingPage;
import com.app.flipkart.pages.SearchResultsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SingleTest extends BrowserStackTestNGTest {

    @Test
    public void testFlipkartSearchFilters() throws Exception {
        new LandingPage(driver).dismissLoginPopup();
        new HomePage(driver).searchForItem("Samsung Galaxy S21");
        SearchResultsPage page = new SearchResultsPage(driver);
        page.waitForSearchResultsToAppear();
        page.checkFlipkartAssured();
        page.checkFilter("Brand", "SAMSUNG");
        page.sortEntriesByPrice();
        page.displaySearchResults();
        Thread.sleep(5000);
    }
}
