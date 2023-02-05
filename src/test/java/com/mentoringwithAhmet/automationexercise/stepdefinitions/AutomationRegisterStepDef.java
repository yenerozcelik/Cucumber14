package com.mentoringwithAhmet.automationexercise.stepdefinitions;

import com.mentoringwithAhmet.automationexercise.pages.AutomationLoginPage;
import com.mentoringwithAhmet.automationexercise.pages.AutomationMainPage;
import com.mentoringwithAhmet.automationexercise.pages.AutomationSignUpPage;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

public class AutomationRegisterStepDef {

    WebDriver driver = DriverHelper.getDriver();

    AutomationMainPage automationMainPage=new AutomationMainPage(driver);

    AutomationLoginPage automationLoginPage=new AutomationLoginPage(driver);

    AutomationSignUpPage automationSignUpPage=new AutomationSignUpPage(driver);

    @Given("User navigates to AutomationExercise and validates title {string}")
    public void user_navigates_to_automation_exercise_and_validates_title(String expectedTitle) {
        driver.get(ConfigReader.readProperty("automationexercise"));
        Assert.assertEquals(expectedTitle,driver.getTitle().trim());

    }
    @When("User click sign up button and validates the {string} is visible")
    public void user_click_sign_up_button_and_validates_the_is_visible(String expectedHeader) {
        automationMainPage.login();
       // automationLoginPage.validateTitle(expectedHeader);


    }
    @When("User provides username {string} and email adress {string} and click sign up button")
    public void user_provides_username_and_email_adress_and_click_sign_up_button(String name, String email) {
            automationLoginPage.newsignup(name,email);
    }
    @When("User verify {string} message is visible")
    public void user_verify_message_is_visible(String expectedTitle) {
       automationSignUpPage.validatetitleAccount(expectedTitle);
    }

    @When("User provides name ,email  , password {string} , Date of birth {string} , month {string}, year {string}")
    public void user_provides_name_email_password_date_of_birth_month_year(String password, String date, String month, String year) {

        automationSignUpPage.signupFirstStep(password,date,month,year);
    }

    @When("User selects Sign up for  our newsletter! and Receive special offers from our partners!")
    public void user_selects_sign_up_for_our_newsletter_and_receive_special_offers_from_our_partners() {
        automationSignUpPage.signupstep2();

    }

    @When("User provides {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string} , {string}, {string}")
    public void user_provides(String firstname, String lastname, String company, String Address,
                              String Address2, String Country, String State, String City, String Zipcode, String Number) {
        automationSignUpPage.signupstep3(firstname,lastname,company,Address,Address2,Country,State,City,Zipcode,Number);

    }

    @Then("User clicks Create Account button and validates {string}")
    public void user_clicks_create_account_button_and_validates(String expectedTitle) {
        automationSignUpPage.signupstep5();
        automationSignUpPage.validateTitle(expectedTitle);

    }

    @Then("User clicks Continue Button and validate Logged in as  username {string}")
    public void user_clicks_continue_button_and_validate_logged_in_as_username(String username) throws InterruptedException {
       automationSignUpPage.validateLoginname(username,driver);
    }

    @Then("User clicks Delete Account button and validates {string} is visible")
    public void user_clicks_delete_account_button_and_validates_is_visible(String header) throws InterruptedException {
        automationSignUpPage.deleteAccount(header);

    }

    @Then("User clicks continue button")
    public void user_clicks_continue_button()  {
        automationSignUpPage.clickContinue();
    }

    @When("User provides username {string} and email adress {string} for login")
    public void user_provides_username_and_email_adress_for_login(String email, String password) {
        automationLoginPage.login(email,password);
    }

    @Then("User clicks login button and validates  {string} is visible")
    public void user_clicks_login_button_and_validates_is_visible(String expectedmessage) {
        automationLoginPage.clickloginbutton(expectedmessage);
    }

    @Then("User click logout button")
    public void user_click_logout_button() {
        automationMainPage.logout();
    }

}
