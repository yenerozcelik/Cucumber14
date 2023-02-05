package com.test.products.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductMainPage {

   public ProductMainPage(WebDriver driver){
       PageFactory.initElements(driver,this);
   }

   @FindBy(xpath = "//a[.='Order']")
    WebElement orderButton;

    @FindBy(linkText = "View all orders")
    WebElement allordersButton;

   public void clickOrderButton(){
       orderButton.click();
   }

   public void  clickviewallordersbutton(){

       allordersButton.click();
   }
}
