package com.test.uitestpractice.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.DriverHelper;


public class TestBaseUITestPractice {
    public WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = DriverHelper.getDriver();
        driver.get("http://uitestpractice.com/Students/Select#");
    }


    @AfterMethod
    public void tearDown()  {
        driver.quit();
    }

}
