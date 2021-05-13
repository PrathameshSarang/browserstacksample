package com.app.flipkart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void searchForItem(String item){
        WebElement searchField = driver.findElement(By.xpath("//input[@title='Search for products, brands and more']"));
        searchField.sendKeys(item);
        searchField.sendKeys(Keys.ENTER);
    }
}
