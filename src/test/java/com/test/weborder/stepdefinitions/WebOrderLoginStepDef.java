package com.test.weborder.stepdefinitions;

import com.test.weborder.pages.WebOrderLogin;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

public class WebOrderLoginStepDef {

    WebDriver driver= DriverHelper.getDriver();
    WebOrderLogin loginPage=new WebOrderLogin(driver);

    @Given("User navigates to Weborder Page")
    public void user_navigates_to_weborder_page() {
        driver.get(ConfigReader.readProperty("weborderurl"));
    }
    @When("user provides username {string} and password {string} for Weborder")
    public void user_provides_username_and_password_for_weborder(String username, String password) {
        loginPage.login(username,password);
    }
    @Then("User validates the title {string} from homepage")
    public void user_validates_the_title_from_homepage(String expectedTitle) {
        Assert.assertEquals(expectedTitle,driver.getTitle().trim());
        driver.quit();

    }

    @Then("User validates the error message {string}")
    public void user_validates_the_error_message(String expectedErrorMessage) {
        Assert.assertEquals(expectedErrorMessage,loginPage.validateErrorMessage());
    }
}
