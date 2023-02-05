package com.mentoringwithAhmet.automationexercise.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class AutomationLoginPage {

    public AutomationLoginPage(WebDriver driver){

        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//h2[.='New User Signup!']")
    WebElement signupTitle;

    @FindBy(xpath = "//h2[.='Login to your account']")
    WebElement loginTitle;

    @FindBy(xpath = "//input[@data-qa='signup-name']")
    WebElement name;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    WebElement email;

    @FindBy(xpath = "//button[@data-qa='signup-button']")
    WebElement signButton;

    @FindBy(xpath = "//input[@data-qa='login-email']")
    WebElement emailadresslogin;

    @FindBy(xpath = "//input[@data-qa='login-password']")
    WebElement passwordlogin;

    @FindBy(xpath = "//button[@data-qa='login-button']")
    WebElement loginbutton;

    public void validateTitle(String expectedHeader){
        Assert.assertEquals(expectedHeader,BrowserUtils.getText(signupTitle).trim());
    }
    public void newsignup(String name, String email){

        this.name.sendKeys(name);
        this.email.sendKeys(email);
        signButton.click();
    }

    public void login(String email, String password){

        emailadresslogin.sendKeys(email);
        passwordlogin.sendKeys(password);
    }
    public void clickloginbutton(String expectedmessage){
        loginbutton.click();
      //  Assert.assertEquals(expectedmessage,BrowserUtils.getText(loginTitle));



    }



}
