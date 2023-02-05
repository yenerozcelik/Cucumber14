package com.test.etsy.stepdefinition;

import com.test.etsy.pages.EtsyMainPage;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class EtsyHomePage {

    WebDriver driver= DriverHelper.getDriver();

    EtsyMainPage etsyMainPage=new EtsyMainPage(driver);


    @Given("User navigates to {string}")
    public void user_navigates_to(String url) {
        driver.get(url);

    }
    @When("User searches for {string} in Etsy webpage")
    public void user_searches_for_in_etsy_webpage(String word) {
        etsyMainPage.searchKeys(word);

    }
    @Then("User validates the title {string} from Etsy homepage")
    public void user_validates_the_title_from_etsy_homepage(String expectedTitle) {
        Assert.assertEquals(expectedTitle,driver.getTitle().trim());

    }

}
