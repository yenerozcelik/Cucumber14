package com.test.products.stepdefinitions;

import com.test.products.pages.ProductLoginPage;
import com.test.products.pages.ProductMainPage;
import com.test.products.pages.ProductOrderPage;
import com.test.products.pages.ProductViewOrderPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

import java.util.List;
import java.util.Map;

public class ProductCreationStepDef {

    WebDriver driver= DriverHelper.getDriver();

    ProductLoginPage productLoginPage=new ProductLoginPage(driver);

    ProductMainPage productMainPage=new ProductMainPage(driver);

    ProductOrderPage productOrderPage=new ProductOrderPage(driver);

    ProductViewOrderPage productViewOrderPage=new ProductViewOrderPage(driver);

    @Given("User navigates to product homepage and click order Button")
    public void user_navigates_to_product_homepage_and_click_order_button() {
        productLoginPage.login(ConfigReader.readProperty("productusername"),ConfigReader.readProperty("productpassword"));
        productMainPage.clickOrderButton();
    }
    @When("User enters the product information {string} and {string}")
    public void user_enters_the_product_information_and(String productname, String quantity) {
        productOrderPage.sendProductInformation(productname,quantity);

    }
    @When("User enters the address information {string},{string},{string} ,{string}")
    public void user_enters_the_address_information(String name, String street, String city, String zip) {
    productOrderPage.sendAddressInformation(name,street,city,zip);
    }
    @When("User enters the payment information {string} ,{string},{string} and click process button")
    public void user_enters_the_payment_information_and_click_process_button(String cardtype, String cardnumber, String expiredate) {
        productOrderPage.sendPaymentInformation(cardtype,cardnumber,expiredate);
    }
    @Then("User validates the message {string}")
    public void user_validates_the_message(String message) {
        Assert.assertEquals(message,productOrderPage.validateMessage());

    }

//    @Then("User validate new order")
//    public void user_validate_new_order() {
//        productOrderPage.valitadeneworder();
//    }

    @Then("User validates all the information {string},{string},{string},{string},{string},{string},{string},{string},{string}")
    public void user_validates_all_the_information(String name, String product, String quantity, String street, String city, String zip, String cardtype, String cardnumber, String expiredate) {
       productMainPage.clickviewallordersbutton();
        productViewOrderPage.validateInformation(name,product,quantity,street,city,zip,cardtype,cardnumber,expiredate);
    }

    @When("User enters the product information Product and Quantity")
    public void user_enters_the_product_information_product_and_quantity(DataTable dataTable) {
       Map<String,String> productInformation= dataTable.asMap(); //product=Mymoney ,Quantity=4
       productOrderPage.sendProductInformation(productInformation.get("product"),productInformation.get("quantity"));
    }
    @When("User enters the address information name,street,city ,zip")
    public void user_enters_the_address_information_name_street_city_zip(DataTable dataTable) {
        Map<String,String> adressInformation= dataTable.asMap();
        productOrderPage.sendAddressInformation(adressInformation.get("name"),adressInformation.get("street"),adressInformation.get("city"),adressInformation.get("zip"));

    }
    @When("User enters the payment information cardType ,cardnumber,expireDate and click process button")
    public void user_enters_the_payment_information_card_type_cardnumber_expire_date_and_click_process_button(DataTable dataTable) {
        Map<String,String> paymentInformation= dataTable.asMap();
        productOrderPage.sendPaymentInformation(paymentInformation.get("cardType"),paymentInformation.get("cardnumber"),paymentInformation.get("expireDate"));
    }
    @Then("User validates the message message")
    public void user_validates_the_message_message(io.cucumber.datatable.DataTable dataTable) {
       List<String> expectedmessage=dataTable.asList();
       Assert.assertEquals(expectedmessage.get(0),productOrderPage.validateMessage());
    }
}
