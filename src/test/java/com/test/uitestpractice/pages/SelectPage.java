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

    public SelectPage() {
        PageFactory.initElements(driver, this);
    }


    // declare Select method from select class here to DO NOT create object every time to save memory

    @FindBy(css = "#countriesSingle")
    WebElement dropDownButton;

    public void indiaIsSelectedValidation(String expectedCountry) {
        Select select = new Select(dropDownButton);
        Assert.assertEquals(select.getFirstSelectedOption().getText(), expectedCountry);
    }

    public void dropdownSizeValidation(WebDriver driver) {
        Select select = new Select(dropDownButton);
        Assert.assertEquals(select.getOptions().size(), 4);
    }

    public void dropdownsCountryValidation(String country1, String country2, String country3, String country4) {
        Select select = new Select(dropDownButton);
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
        Select select = new Select(dropDownButton);
        select.selectByIndex(2);
        Thread.sleep(500);
        select.selectByValue("england");
        Thread.sleep(500);
        select.selectByVisibleText("United states of America");
        Thread.sleep(500);
    }


}
