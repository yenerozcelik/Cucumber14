package com.test.products.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class ProductViewOrderPage {

    public ProductViewOrderPage(WebDriver driver){
        PageFactory.initElements(driver,this);

    }



    @FindBy(xpath = "//tr[2]//td")
    List<WebElement> newproductinfo;

    public void validateInformation(String name, String product, String quantity, String street, String city, String zip, String cardtype, String cardnumber, String expiredate){
//       Date date=new Date();
//        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("MM/dd/yyyy");
//        String currentDate=simpleDateFormat.format(date);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDateTime now = LocalDateTime.now();
        String currentTime = dtf.format(now);
        List<String> expectedValues= Arrays.asList("",name,product,quantity,currentTime,street,city,"",zip,cardtype,cardnumber,expiredate);

        for (int i = 1; i <expectedValues.size()-1 ; i++) {
            Assert.assertEquals(expectedValues.get(i), BrowserUtils.getText(newproductinfo.get(i)));

        }


    }

}
