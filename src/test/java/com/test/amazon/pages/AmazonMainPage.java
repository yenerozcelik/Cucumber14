package com.test.amazon.pages;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import javax.sql.rowset.BaseRowSet;
import java.util.List;

public class AmazonMainPage {

    public AmazonMainPage(WebDriver driver){

        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "twotabsearchtextbox")
    WebElement searchbox;

    @FindBy(xpath = "//span[contains(text(),'results for')]")
    WebElement result;

    @FindBy(xpath = "//h2//a")
    List<WebElement> alltitles;


    public void search(String word){
        searchbox.sendKeys(word, Keys.ENTER);

    }

    public boolean resultNumber(int number){
        return BrowserUtils.getText(result).replace(",","").
                contains(String.valueOf(number));  ////about ....20000 results
    }

    public  void validateAllTitle(String expectedWord){

        for (WebElement alltitle: alltitles){
            if (!BrowserUtils.getText(alltitle).equals("")) {
                Assert.assertTrue(BrowserUtils.getText(alltitle).toLowerCase().contains(expectedWord));

            }
        }
    }






}

