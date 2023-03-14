package com.test.codefish.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

import java.util.ArrayList;
import java.util.List;

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

    @FindBy(xpath = "//div[@id='apps']//a[1]")
    WebElement findPatientRecordButton;

    @FindBy(xpath = "//input[@id='patient-search']")
    WebElement searchBar;

    @FindBy(xpath = "//tr//td[2]")
    List<WebElement> namesListBySearch;


    public void laboratoryPageValidation() { //Logged in as Super User (admin) at Laboratory.
        Assert.assertTrue(BrowserUtils.getText(laboratoryLocation).equals("Laboratory"));
        Assert.assertEquals(BrowserUtils.getText(Header), ("Logged in as Super User (admin) at Laboratory."));
    }

    public void switchToPharmacy() throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(laboratoryLocation).click().moveToElement(pharmacyLocation).click().perform();
        Thread.sleep(2000);
        driver.navigate().refresh();
        Thread.sleep(2000);
        Assert.assertEquals(BrowserUtils.getText(Header), ("Logged in as Super User (admin) at Pharmacy."));
    }

    public void johnJohnsSearch(String searchByIDorName) {

        findPatientRecordButton.click();
        searchBar.sendKeys(searchByIDorName);
        int count = 0;
        String nameJohn = "";
        for (WebElement name : namesListBySearch) {
            if (BrowserUtils.getText(name).equals(searchByIDorName)) {
                count++;
                nameJohn = BrowserUtils.getText(name);
            }
        }
        Assert.assertTrue(count == 1 && nameJohn.equals(searchByIDorName));


    }
}
