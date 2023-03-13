package com.test.uitestpractice.tests;

import com.test.uitestpractice.pages.SelectPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class TestCase1 extends TestBaseUITestPractice {
    //CASE 1
    //Navigate to
    //"http://uitestpractice.com/Students/Select#"
    //Validate India is selected by default on drop down
    //box
    //Validate the size of the Drop down box is 4
    //Validate the values for Drop down box are :
    //India
    //United States of America
    //China
    //England
    //Select the China with index number
    //Select the England with value
    //Select the United States with visible text

    @Test
    public void testCase1() throws InterruptedException {

        SelectPage selectPage = new SelectPage(driver);
        selectPage.indiaIsSelectedValidation("India");
        selectPage.dropdownSizeValidation(driver);
        selectPage.dropdownsCountryValidation("India", "United states of America", "China", "England");
        selectPage.selectFuncValidation();
    }

    @Test
    public void testCase2(){
        SelectPage selectPage = new SelectPage(driver);

    }

}
