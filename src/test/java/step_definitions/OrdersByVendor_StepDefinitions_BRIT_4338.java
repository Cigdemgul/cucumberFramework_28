package step_definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.LoginPage;
import pages.LunchHomePage;
import pages.MainPage;
import pages.OrdersByVendorPage;
import utilities.Driver;

import static org.junit.Assert.assertTrue;

public class OrdersByVendor_StepDefinitions_BRIT_4338 {

    OrdersByVendorPage ordersByVendorPage = new OrdersByVendorPage();
    MainPage mainPage = new MainPage();
    LoginPage loginPage = new LoginPage();
    LunchHomePage lunchHomePage = new LunchHomePage();

    @Given("manager user is on the Orders By Vendor Page")
    public void manager_user_is_on_the_Orders_By_Vendor_Page() throws InterruptedException {
        lunchHomePage.ordersByVendorButton.click();
        ordersByVendorPage.firstVendor.click();
        ordersByVendorPage.firstVendorDate.click();
        ordersByVendorPage.firstCheckbox.click();
        Thread.sleep(2000);

    }

    @When("manager user clicks on the Print button")
    public void manager_user_clicks_on_the_Print_button() {

       ordersByVendorPage.printButton.click();
    }

    @Then("manager user should be able to click to Lunch Order option")
    public void manager_user_should_be_able_to_click_to_Lunch_Order_option() {
       ordersByVendorPage.lunchOrderButton.click();
    }

    @Then("manager user should be able to get the pdf file")
    public void manager_user_should_be_able_to_get_the_pdf_file() {
       assertTrue(Driver.getDriver().getCurrentUrl().equals("http://54.148.96.210/web?#view_type=list&model=lunch.order.line&menu_id=102&action=101"));
    }


}
