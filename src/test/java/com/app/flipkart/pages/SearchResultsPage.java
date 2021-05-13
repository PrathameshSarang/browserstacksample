package com.app.flipkart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchResultsPage extends BasePage{

    //TODO: Move identifiers here

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    //TODO: Maybe move this to constructor
    public void waitForSearchResultsToAppear(){
        new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@data-id]")));
    }

    public void checkFlipkartAssured() throws InterruptedException{
        driver.findElement(By.xpath("//section//input[@type='checkbox']/following-sibling::div//img")).click();
        Thread.sleep(500);     // TODO: Wait for loading icon or event to ensure this action has completed
    }

    public void checkFilter(String heading, String value)throws  InterruptedException{
        driver.findElement(By.xpath("//section//div[text()='"+heading+"']//ancestor::section//div//input[@type='checkbox']/following-sibling::div[text()='"+value+"']")).click();
        Thread.sleep(500);     // TODO: Wait for loading icon or event to ensure this action has completed
    }

    public void sortEntriesByPrice() throws InterruptedException{
        // 3.Sort the entries with Price -> High to Low. //TODO: Use enum for price
        driver.findElement(By.xpath("//span[text()='Sort By']/following-sibling::div[text()='Price -- High to Low']")).click();
        Thread.sleep(500);    // TODO: Wait for loading icon or event to ensure this action has completed
    }

    public void displaySearchResults(){
        List<WebElement> serarchResults = driver.findElements(By.xpath("//div[@data-id]"));
        System.out.println("Total Results: " + serarchResults.size());
        for (WebElement result : serarchResults) {
            System.out.println("======================================================================================================================================================");
            System.out.println("Prodcut Name: " + result.findElement(By.xpath("//div[@data-id]//span[contains(@id,'productRating')]/parent::div/preceding-sibling::div")).getText());
            System.out.println("Displayed Price: " + result.findElement(By.xpath("//div[@data-id]//div[contains(text(),'₹') and contains(@class,'WHN1')]")).getText());
            System.out.println("Link to Product Details Page: " + result.findElement(By.xpath("//div[@data-id]//a")).getAttribute("href"));
        }
    }
}
