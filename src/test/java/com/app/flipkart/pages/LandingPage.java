package com.app.flipkart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LandingPage extends BasePage{

    public LandingPage(WebDriver driver) {
        super(driver);
    }

    public void dismissLoginPopup(){
        driver.get("https://www.flipkart.com/");
        Assert.assertNotNull(driver.findElement(By.xpath("//span[text()='Login']")), "Login popup did not load");
        driver.findElement(By.xpath("//button[text()='✕']")).click();

    }
}
