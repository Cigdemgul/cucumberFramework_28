package step_definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.LoginPage;
import pages.LunchHomePage;
import pages.MainPage;
import pages.OrdersByVendorPage;
import utilities.ConfigurationReader;
import utilities.Driver;

import static org.junit.Assert.*;

public class OrdersByVendor_StepDefinitions_BRIT_4259 {

    OrdersByVendorPage ordersByVendorPage = new OrdersByVendorPage();
    MainPage mainPage = new MainPage();
    LoginPage loginPage = new LoginPage();
    LunchHomePage lunchHomePage = new LunchHomePage();


    @Given("user is at the lunch home page")
    public void user_is_at_the_lunch_home_page() throws InterruptedException {

       assertTrue(Driver.getDriver().getTitle().equals("New Order - Odoo"));
    }

    @When("user clicks the Orders by Vendor button")
    public void user_clicks_the_Orders_by_Vendor_button() throws InterruptedException {
      lunchHomePage.ordersByVendorButton.click();
      Thread.sleep(2000);
    }

    @Then("user clicks the firstVendor button")
    public void user_clicks_the_firstVendor_button() throws InterruptedException {
        ordersByVendorPage.firstVendor.click();
        Thread.sleep(2000);
    }

    @Then("user should be able to click the month")
    public void user_should_be_able_to_click_the_month() {
        ordersByVendorPage.firstVendorDate.click();
    }

    @Then("user should be able to click the day check box")
    public void user_should_be_able_to_click_the_day_check_box() {
       ordersByVendorPage.firstCheckbox.click();
    }

    @Then("user should be able to see the print and action buttons")
    public void user_should_be_able_to_see_the_print_and_action_buttons() {
        assertTrue(ordersByVendorPage.printAndActionButtons.isDisplayed());



    }


}
