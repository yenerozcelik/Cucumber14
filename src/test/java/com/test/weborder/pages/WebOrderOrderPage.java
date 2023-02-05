package com.test.weborder.pages;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class WebOrderOrderPage {

    public WebOrderOrderPage(WebDriver driver){

        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//h1")
    WebElement title;

    @FindBy(xpath = "//label[@class='custom-control-label']")
    WebElement CheckBoxGroupOrder;

    @FindBy(id = "getAddressNextButton")
    WebElement NextButton;

    @FindBy(id = "InviteNote")
    WebElement invitenote;

    @FindBy(id = "InviteList")
    WebElement invitelist;

    @FindBy(id = "ConfirmAddressID")
    WebElement location;

    @FindBy(id = "addressPreview")
    WebElement adress;

    @FindBy(id = "createGroupOrder")
    WebElement creategrouporderbutton;

    @FindBy(tagName = "h1")
    WebElement header;

   public void clickGroupOrderBox(){

       CheckBoxGroupOrder.click();
   }

   public void clickNextButton(){

       NextButton.click();
   }

   public void chooseDeliveryOption(String option,String expectedAdress){
       BrowserUtils.selectBy(location,option,"text");
       Assert.assertTrue(BrowserUtils.getText(adress).contains(expectedAdress));

   }

   public void sendingNote(String invitenote){
       this.invitenote.sendKeys(invitenote);
   }

   public void sendinginvitelist(String e_mail1,String e_mail2){
       invitelist.sendKeys(e_mail1+" , "+e_mail2);

   }

   public void clickorderbutton(){
       creategrouporderbutton.click();
   }
   public boolean validateHeader(String expectedHeader){
       return BrowserUtils.getText(header).equals(expectedHeader);
   }

}
