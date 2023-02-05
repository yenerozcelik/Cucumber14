package com.mentoringwithAhmet.automationexercise.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AutomationMainPage {

    public AutomationMainPage(WebDriver driver){

        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[@href='/login']")
    WebElement loginButton;

    @FindBy(xpath = "//h2[.='New User Signup!']")
    WebElement signupTitle;

    @FindBy(linkText = "Logout")
    WebElement logoutbutton;


    public void login(){
        loginButton.click();
    }

    public void logout(){
        logoutbutton.click();
    }

}
