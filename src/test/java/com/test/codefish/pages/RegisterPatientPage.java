package com.test.codefish.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utils.BrowserUtils;

public class RegisterPatientPage {

    WebDriver driver;

    public RegisterPatientPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Register a patient")
    WebElement RegisterPatientButton;

    @FindBy(xpath = "//input[@name='givenName']")
    WebElement givenName;

    @FindBy(xpath = "//input[@name='familyName']")
    WebElement familyName;

    @FindBy(xpath = "//span[@id='genderLabel']")
    WebElement genderTab;

    @FindBy(xpath = "//select[@id='gender-field']")
    WebElement genderSelect;

    @FindBy(xpath = "//span[@id='birthdateLabel']")
    WebElement birthdateTab;

    @FindBy(xpath = "//input[@id='birthdateDay-field']")
    WebElement birthdayDay;

    @FindBy(xpath = "//select[@id='birthdateMonth-field']")
    WebElement birthdayMonth;

    @FindBy(xpath = "//input[@id='birthdateYear-field']")
    WebElement birthdayYear;

    @FindBy(xpath = "//span[.='Address']")
    WebElement addressTab;

    @FindBy(css = "#address1")
    WebElement addressField;

    @FindBy(css = "#cityVillage")
    WebElement city;

    @FindBy(css = "#stateProvince")
    WebElement state;

    @FindBy(css = "#country")
    WebElement county;

    @FindBy(css = "#postalCode")
    WebElement zip;

    @FindBy(xpath = "//span[.='Phone Number']")
    WebElement phoneNumberTab;

    @FindBy(xpath = "//input[@name='phoneNumber']")
    WebElement phoneNumberField;

    @FindBy(css = "#confirmation_label")
    WebElement confirmButton;

    @FindBy(css = "#submit")
    WebElement submitButton;

    @FindBy(xpath = "//em[.='Patient ID']//following-sibling::span")
    WebElement patientID;

    @FindBy(xpath = "//span[@class='PersonName-givenName']")
    WebElement firstNameValidation;

    @FindBy(xpath = "//span[@class='PersonName-familyName']")
    WebElement lastNameValidation;

    @FindBy(xpath = "//div[@class='logo']")
    WebElement homePageButton;

    @FindBy (linkText = "Find Patient Record")
    WebElement findPatientButton;

    @FindBy (xpath = "//input[@id='patient-search']")
    WebElement searchButton;

    @FindBy(xpath = "//tr[1]/td[1]")
    WebElement newPatientClickInSearch;

    @FindBy (id = "org.openmrs.module.coreapps.deletePatient")
    WebElement deleteButton;

    @FindBy (css = "#delete-reason")
    WebElement reasonDelete;

    @FindBy(xpath = "//div[@id='delete-patient-creation-dialog']//button[.='Confirm']")
    WebElement confirmDeleteButton;

    @FindBy(xpath = "//h6[@id='delete-reason-empty']")
    WebElement deleteErrorMessage;

    public void registerPatient(String givenName, String familyName, String Gender, String birthdayDay, String birthdayYear, String addressField, String city, String state, String county, String zip, String phoneNumberField, String reasonDelete, String expectedErrorMsg) throws InterruptedException {
        RegisterPatientButton.click();
        this.givenName.sendKeys(givenName);
        this.familyName.sendKeys(familyName);

        genderTab.click();
        Select select = new Select(genderSelect);
        select.selectByValue(Gender);

        birthdateTab.click();
        select = new Select(birthdayMonth);
        select.selectByVisibleText("November");
        this.birthdayDay.sendKeys(birthdayDay);
        this.birthdayYear.sendKeys(birthdayYear);

        addressTab.click();
        this.addressField.sendKeys(addressField);
        this.city.sendKeys(city);
        this.state.sendKeys(state);
        this.county.sendKeys(county);
        this.zip.sendKeys(zip);

        phoneNumberTab.click();
        this.phoneNumberField.sendKeys(phoneNumberField);

        confirmButton.click();
        submitButton.click();

        String ID = BrowserUtils.getText(patientID);

        Assert.assertEquals(BrowserUtils.getText(firstNameValidation), givenName);
        Assert.assertEquals(BrowserUtils.getText(lastNameValidation), familyName);

        homePageButton.click();
        findPatientButton.click();
        searchButton.sendKeys(givenName+" "+familyName);
        Thread.sleep(1000);
        Actions actions = new Actions(driver);
        actions.moveToElement(newPatientClickInSearch).doubleClick().perform();
        Thread.sleep(2000);

       actions.moveToElement(deleteButton).click().perform();
        Assert.assertTrue(BrowserUtils.getText(deleteErrorMessage).contains(expectedErrorMsg));

        this.reasonDelete.sendKeys(reasonDelete);
        confirmDeleteButton.click();







    }


}
