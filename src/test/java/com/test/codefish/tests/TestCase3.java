package com.test.codefish.tests;

import com.test.codefish.pages.LaboratoryPage;
import com.test.codefish.pages.LoginPage;
import com.test.codefish.pages.RegisterPatientPage;
import org.testng.annotations.Test;

public class TestCase3 extends TestBaseCodefish {

    /*
    Navigate to "http://codefish.ninja/openmrs/login.htm"
    username:admin -- password: Admin123
Select Labratory location and login
Validate your location is Laboratory
Validate "Logged in as Super User (admin) at
Laboratory."
Change location to Pharmacy and click to OPENMRS
logo
Validate "Logged in as Super User (admin) "location
change to Pharmacy ."
Select Find patient record
Find the John johns patient and validate his identifieris unic
     */
    @Test
    public void testCase3() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin","Admin123");  //username:admin -- password: Admin123
        LaboratoryPage laboratoryPage = new LaboratoryPage(driver);
        laboratoryPage.laboratoryPageValidation();
        laboratoryPage.switchToPharmacy();
        laboratoryPage.johnJohnsSearch("John Johns");
    }

    @Test
    public void testCase3_1() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin","Admin123");  //username:admin -- password: Admin123
        RegisterPatientPage registerPatientPage = new RegisterPatientPage(driver);
        registerPatientPage.registerPatient("Artur","Mng", "M", "1" ,"1993", "2200 E Devon ave" ,"Des Plains" ,"IL","cook", "60018","996 52 18 0592", "delete", "Reason cannot be empty");
    }
}
