package com.test.amazon.stepdefinitions;

import com.test.amazon.pages.AmazonMainPage;
import com.test.google.pages.GoogleMainPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

public class AmazonSearchStepDef {

    WebDriver driver = DriverHelper.getDriver();
    AmazonMainPage amazonMainPage=new AmazonMainPage(driver);

    @Given("User navigates to the Amazon")
    public void user_navigates_to_the_amazon() {
        driver.get(ConfigReader.readProperty("amazonurl"));

    }

    @When("User searches for iphone {string} on Amazon")
    public void user_searches_for_iphone_on_amazon(String expectedWord) {
        amazonMainPage.search(expectedWord);
    }
    @Then("user validates the result is contain {int}")
    public void user_validates_the_result_is_contain(int expectedNumber) {
       Assert.assertTrue(amazonMainPage.resultNumber(expectedNumber));
    }
    @Then("user validates all headers contain {string}")
    public void user_validates_all_headers_contain(String expectedKey) {
       amazonMainPage.validateAllTitle(expectedKey);

    }
}
