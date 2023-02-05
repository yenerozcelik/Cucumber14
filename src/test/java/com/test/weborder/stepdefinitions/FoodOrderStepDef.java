package com.test.weborder.stepdefinitions;

import com.test.weborder.pages.WebOrderLogin;
import com.test.weborder.pages.WebOrderOrderPage;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.BrowserUtils;
import utils.ConfigReader;
import utils.DriverHelper;

public class FoodOrderStepDef {

    WebDriver driver= DriverHelper.getDriver();

    WebOrderLogin loginpage=new WebOrderLogin(driver);

    WebOrderOrderPage orderOrderPage=new WebOrderOrderPage(driver);

    @Given("User navigates to Weborder  and login succesfully")
    public void user_navigates_to_weborder_and_login_succesfully() {
        loginpage.login(ConfigReader.readProperty("weborderusername"),ConfigReader.readProperty("weborderpassword"));
    }
    @Given("User validate the title {string} ORDER DETAILS from orderpage")
    public void user_validate_the_title_order_details_from_orderpage(String expectedResult) {
        Assert.assertEquals(expectedResult,driver.getTitle().trim());

    }
    @When("User Clicks Group Order box and Click Next button")
    public void user_clicks_group_order_box_and_click_next_button() {

        orderOrderPage.clickGroupOrderBox();
        orderOrderPage.clickNextButton();

    }
    @When("User Send the word {string} for note to Invitees section")
    public void user_send_the_word_for_note_to_invitees_section(String note) {
        orderOrderPage.sendingNote(note);

    }
    @When("User sends e-mail address which are {string} and {string} to invite list")
    public void user_sends_e_mail_address_which_are_and_to_invite_list(String email1, String email2) {
        orderOrderPage.sendinginvitelist(email1,email2);


    }
    @When("User chooses the  delivery adress {string} and validates the adress {string}")
    public void user_chooses_the_delivery_adress_and_validates_the_adress(String option, String expectedAdress) {
        orderOrderPage.chooseDeliveryOption(option,expectedAdress);
    }
    @When("user clicks the create Group Order button")
    public void user_clicks_the_create_group_order_button() {
        orderOrderPage.clickorderbutton();

    }
    @Then("User validates the header of page is {string}")
    public void user_validates_the_header_of_page_is(String expectedHeader) throws InterruptedException {
       Thread.sleep(1000); Assert.assertTrue(orderOrderPage.validateHeader(expectedHeader));

    }
}
