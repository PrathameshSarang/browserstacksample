package com.app.flipkart.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class FlipkartSearch {
    WebDriver driver;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/binaries/chromedriver");
        driver = new ChromeDriver();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void basicTest() throws InterruptedException {
        // Navigate to Flipkart (Landing Page)
        driver.get("https://www.flipkart.com/");
        Assert.assertNotNull(driver.findElement(By.xpath("//span[text()='Login']")), "Login popup did not load");
        driver.findElement(By.xpath("//button[text()='✕']")).click();

        // Search for Device (Home Screen)
        WebElement searchField = driver.findElement(By.xpath("//input[@title='Search for products, brands and more']"));
        searchField.sendKeys("Samsung Galaxy S21");
        searchField.sendKeys(Keys.ENTER);


        // Print all search results (Search Results Page)
        // Wait for the search results to load
        new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@data-id]")));
        // Apply filters
        // Brand Samsung. //TODO: Pass filter criterion and text as a paremeter
        driver.findElement(By.xpath("//section//div[text()='Brand']//ancestor::section//div//input[@type='checkbox']/following-sibling::div[text()='SAMSUNG']")).click();
        Thread.sleep(500);     // TODO: Wait for loading icon or event to ensure this action has completed
        // Select Flipkart assured.
        driver.findElement(By.xpath("//section//input[@type='checkbox']/following-sibling::div//img")).click();
        Thread.sleep(500);     // TODO: Wait for loading icon or event to ensure this action has completed
        // 3.Sort the entries with Price -> High to Low. //TODO: Use enum for price
        driver.findElement(By.xpath("//span[text()='Sort By']/following-sibling::div[text()='Price -- High to Low']")).click();
        Thread.sleep(500);    // TODO: Wait for loading icon or event to ensure this action has completed
        List<WebElement> serarchResults = driver.findElements(By.xpath("//div[@data-id]"));
        System.out.println("Total Results: " + serarchResults.size());
        for (WebElement result : serarchResults) {
            System.out.println("===========================================================================================================================================================");
            System.out.println("Prodcut Name: " + result.findElement(By.xpath("//div[@data-id]//span[contains(@id,'productRating')]/parent::div/preceding-sibling::div")).getText());
            System.out.println("Displayed Price: " + result.findElement(By.xpath("//div[@data-id]//div[contains(text(),'₹') and contains(@class,'WHN1')]")).getText());
            System.out.println("Link to Product Details Page: " + result.findElement(By.xpath("//div[@data-id]//a")).getAttribute("href"));
        }
    }
}
