package com.mentoringwithAhmet.automationexercise.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class AutomationSignUpPage {

    public AutomationSignUpPage (WebDriver driver){

        PageFactory.initElements(driver,this);
    }

        @FindBy(xpath = "//b[.='Enter Account Information']")
        WebElement headerInfo;

        @FindBy(id = "id_gender1")
        WebElement titleGender;

        @FindBy(id = "password")
        WebElement password;

        @FindBy(id = "days")
        WebElement daydateofbirth;

        @FindBy(id = "months")
        WebElement monthdatebirth;

        @FindBy(id = "years")
        WebElement yeardatebirth;

        @FindBy(id = "newsletter")
        WebElement checkboxnewsletter;

        @FindBy(id = "optin")
        WebElement checkboxoffers;

        @FindBy(id = "first_name")
        WebElement firstname;

        @FindBy(id = "last_name")
        WebElement lastname;

        @FindBy(id = "company")
        WebElement company;

        @FindBy(id = "address1")
        WebElement Address;

        @FindBy(id = "address2")
        WebElement Address2;

        @FindBy(id = "country")
        WebElement Country;

        @FindBy(id = "state")
        WebElement  State;

        @FindBy(id = "city")
        WebElement City;

        @FindBy(id = "zipcode")
        WebElement Zipcode;

        @FindBy(id = "mobile_number")
        WebElement MobileNumber;

        @FindBy(xpath = "//button[.='Create Account']")
        WebElement createButton;

        @FindBy(xpath = "//b[.='Account Created!']")
        WebElement createdHeader;

        @FindBy(linkText = "Continue")
        WebElement continueButton;

        @FindBy(tagName = "b")
        WebElement loginname;

        @FindBy(xpath = " //a[@href='/delete_account']")
        WebElement deleteButton;

        @FindBy(tagName = "b")
        WebElement deletedHeader;

        @FindBy(linkText = "Continue")
        WebElement Continue2button;





    public void validatetitleAccount(String expectedTitle){
        Assert.assertEquals(expectedTitle, BrowserUtils.getText(headerInfo).trim());
    }
    public void signupFirstStep(String password,String date,String month,String year){

        titleGender.click();
        this.password.sendKeys(password);
        BrowserUtils.selectBy(daydateofbirth,date,"text");
        BrowserUtils.selectBy(monthdatebirth,month,"text");
        BrowserUtils.selectBy(yeardatebirth,year,"text");

    }

    public void signupstep2(){
        checkboxnewsletter.click();
        checkboxoffers.click();
    }
    public void signupstep3(String firstname,String lastname,String company,String adress,
                            String address2,String country,String state,String city,String zipcode,String number){
        this.firstname.sendKeys(firstname);
        this.lastname.sendKeys(lastname);
        this.company.sendKeys(company);
        this.Address.sendKeys(adress);
        this.Address2.sendKeys(address2);
        this.Country.sendKeys(country);
        this.State.sendKeys(state);
        this.City.sendKeys(city);
        this.Zipcode.sendKeys(zipcode);
        this.MobileNumber.sendKeys(number);

    }

       public void signupstep5() {
        createButton.click();


       }
       public void validateTitle(String expectedTitle){
        Assert.assertEquals(expectedTitle,BrowserUtils.getText(createdHeader).trim());
       }

       public void validateLoginname(String username,WebDriver driver) throws InterruptedException {
           continueButton.click();
           driver.navigate().refresh();
           Thread.sleep(2000);
           continueButton.click();
        Assert.assertTrue(BrowserUtils.getText(loginname).contains(username));

       }
       public void deleteAccount(String expectedheader) throws InterruptedException {
        deleteButton.click();
        Thread.sleep(1000);

        Assert.assertEquals(expectedheader,BrowserUtils.getText(deletedHeader).trim());
       }

       public void clickContinue()  {
        Continue2button.click();


       }


}
