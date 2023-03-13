package com.test.uitestpractice.pages;

import com.test.uitestpractice.tests.TestBaseUITestPractice;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utils.BrowserUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SelectPage extends TestBaseUITestPractice {
    WebDriver driver;
    public SelectPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    // declare Select method from select class here to DO NOT create object every time to save memory

    @FindBy(xpath = "//select[@id='countriesSingle']")
    WebElement dropDown;
    //select[@id='countriesSingle']//option

    @FindBy(xpath = "//select[@id='countriesMultiple']")
    WebElement countryMultipleSelect;



    public void indiaIsSelectedValidation(String expectedCountry) {
        Select select = new Select(dropDown);
        Assert.assertEquals(select.getFirstSelectedOption().getText(), expectedCountry);
    }

    public void dropdownSizeValidation(WebDriver driver) {
        Select select = new Select(dropDown);
        Assert.assertEquals(select.getOptions().size(), 4);
    }

    public void dropdownsCountryValidation(String country1, String country2, String country3, String country4) {
        Select select = new Select(dropDown);
        List<String> countriesExpected = Arrays.asList(country1, country2, country3, country4);
        List<String> countriesActual = new ArrayList<>();
        List<WebElement> countriesWebElements = select.getOptions();

        for (WebElement country : countriesWebElements) {
            countriesActual.add(BrowserUtils.getText(country));
        }

        Collections.sort(countriesExpected);
        Collections.sort(countriesActual);

        for (int i = 0; i < countriesActual.size(); i++) {
            Assert.assertEquals(countriesActual.get(i), countriesExpected.get(i));
        }

        // had to do 2 lists in case user input counties not in order!
    }

    public void selectFuncValidation() throws InterruptedException {
        Select select = new Select(dropDown);
        select.selectByIndex(2);
        select.selectByValue("england");
        select.selectByVisibleText("United states of America");
    }

    public void multiSelectValidation (){

    }


}
