package com.test.products.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import utils.BrowserUtils;
import utils.ConfigReader;
import utils.DriverHelper;

public class ProductsHook {

     WebDriver driver= DriverHelper.getDriver();

    @Before
    public void setup(){

        driver.get(ConfigReader.readProperty("productsurl"));
    }

    @After
    public void  teardown(Scenario scenario){
        BrowserUtils.getScreenShotForCucumber(driver,scenario);
       //driver.quit();
    }
}

