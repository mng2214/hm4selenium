package com.test.codefish.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//input[@id='username']")
    WebElement login;

    @FindBy (xpath = "//input[@id='password']")
    WebElement password;

    @FindBy (xpath = "//input[@id='loginButton']")
    WebElement loginButton;

    @FindBy (css = "#Laboratory")
    WebElement laboratoryButton;


    public void login (String login, String password){
        this.login.sendKeys(login);
        this.password.sendKeys(password);
        laboratoryButton.click();
        loginButton.click();

    }


}
