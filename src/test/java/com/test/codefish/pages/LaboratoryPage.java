package com.test.codefish.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

public class LaboratoryPage {
    WebDriver driver;


    public LaboratoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(tagName = "h4")
    WebElement Header;

    @FindBy(xpath = "//span[.='Laboratory']")
    WebElement laboratoryLocation;

    @FindBy(xpath = "//li[.='Pharmacy']")
    WebElement pharmacyLocation;


    public void laboratoryPageValidation() { //Logged in as Super User (admin) at Laboratory.
        Assert.assertTrue(BrowserUtils.getText(laboratoryLocation).equals("Laboratory"));
        Assert.assertEquals(BrowserUtils.getText(Header), ("Logged in as Super User (admin) at Laboratory."));
    }

    public void switchToPharmacy (){
        Actions actions= new Actions(driver);
        actions.moveToElement(laboratoryLocation).click().moveToElement(pharmacyLocation).click().perform();
        driver.navigate().refresh();
        Assert.assertEquals(BrowserUtils.getText(Header), ("Logged in as Super User (admin) at Pharmacy."));
    }
}
