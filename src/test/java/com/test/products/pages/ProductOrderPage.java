package com.test.products.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.Arrays;
import java.util.List;

public class ProductOrderPage {

    public ProductOrderPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "#ctl00_MainContent_fmwOrder_ddlProduct")
    WebElement product;
    @FindBy(css = "#ctl00_MainContent_fmwOrder_txtQuantity")
    WebElement Quantity;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_txtName")
    WebElement name;
    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox2")
    WebElement Street;
    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox3")
    WebElement City;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox5")
    WebElement Zip;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_cardList_0")
    WebElement visaCard;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_cardList_1")
    WebElement masterCard;
    @FindBy(css = "#ctl00_MainContent_fmwOrder_cardList_2")
    WebElement AmexCard;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox6")
    WebElement CardNUMBERr;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox1")
    WebElement Expiredate;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_InsertButton")
    WebElement processButton;

    @FindBy(xpath = "//strong")
    WebElement message;

    @FindBy(linkText = "View all orders")
    WebElement allordersButton;

    @FindBy(xpath = "//tr[2]//td")
    List<WebElement> newproductinfo;

    public void sendProductInformation(String productName,String Quantity){
        BrowserUtils.selectBy(product,productName,"text");
        this.Quantity.clear();
        this.Quantity.sendKeys(Quantity);
    }

    public void sendAddressInformation(String name,String street,String city,String zip){
        this.name.sendKeys(name);
        this.Street.sendKeys(street);
        this.City.sendKeys(city);
        this.Zip.sendKeys(zip);
    }

    public void sendPaymentInformation(String cardtype,String cardnumber,String expiredate){

        selectCard(cardtype);
        this.CardNUMBERr.sendKeys(cardnumber);
        this.Expiredate.sendKeys(expiredate);

        processButton.click();

    }

    public void selectCard(String cardtype){
        cardtype=cardtype.toUpperCase();

        switch (cardtype){


            case "VISA":
                visaCard.click();
                break;
            case  "MASTERCARD":
                masterCard.click();
                break;
            case "AMERICAN EXPRESS":
                AmexCard.click();
                break;
            default:
                System.out.println("Card type is incorrect.Please check it");

        }




    }

    public String validateMessage(){
        return BrowserUtils.getText(message);
    }

    public void valitadeneworder(){
        allordersButton.click();

       List<String>newproexpected= Arrays.asList("","Ahmet","MyMoney","4","12/28/2022","Mount Prospect","Chicago",
               "","60123","Visa","1265889","12/21");

        for (int i = 0; i < newproductinfo.size()-1 ; i++) {

            Assert.assertEquals(newproexpected.get(i),BrowserUtils.getText(newproductinfo.get(i)));

        }
    }


}
