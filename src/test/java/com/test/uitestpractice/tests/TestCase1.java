package com.test.uitestpractice.tests;

import com.test.uitestpractice.pages.SelectPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class TestCase1 extends TestBaseUITestPractice {
 /*
    CASE 1
    Navigate to
    "http://uitestpractice.com/Students/Select#"
    Validate India is selected by default on drop down
    box
    Validate the size of the Drop down box is 4
    Validate the values for Drop down box are :
    India
    United States of America
    China
    England
    Select the China with index number
    Select the England with value
    Select the United States with visible text
*/
    @Test
    public void testCase1() throws InterruptedException {

        SelectPage selectPage = new SelectPage(driver);
        selectPage.indiaIsSelectedValidation("India");
        selectPage.dropdownSizeValidation(driver);
        selectPage.dropdownsCountryValidation("India", "United states of America", "China", "England");
        selectPage.selectFuncValidation();
    }

/*   Navigate to Navigate to
    "http://uitestpractice.com/Students/Select#"
    Validate the values for Multiple Select are :
    India
    United States of America
    China
            England
    Select China and England
    Validate "China England" is displayed
    Deselect all the countries
    Select All the countries
    Validate "India United states of America China
    England" is
    displayed
    Deselect the China with index number
    Deselect the England with value
*/

    @Test
    public void testCase2() throws InterruptedException {
        SelectPage selectPage = new SelectPage(driver);
        selectPage.multiSelectValidation("India", "United states of America", "China", "England");
        selectPage.selectChinaAndEngland();
        selectPage.deselectAllCountries();
        selectPage.selectAllCountriesAndValidateIfDisplayed();
        selectPage.deselectChinaAndEngland();

    }

}
