package step_definitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.LunchHomePage;
import utilities.Driver;

import static org.junit.Assert.*;

public class TodaysOrderStep_Definitions_BRIT_4004 {
    LunchHomePage lunchHomePage = new LunchHomePage();

    @When("manager clicks the Today's Orders Button on Lunch Home Page")
    public void manager_clicks_the_Today_s_Orders_Button_on_Lunch_Home_Page() {
        lunchHomePage.todaysOrdersButton.click();
    }

    @Then("manager should be able to see Today option button is selected")
    public void manager_should_be_able_to_see_Today_option_button_is_selected() {
        lunchHomePage.todaysOrdersButton.isDisplayed();
    }

    @Then("the title should be Orders by Vendor - Odoo")
    public void the_title_should_be_Orders_by_Vendor_Odoo() {
        assertEquals("New Order - Odoo" , Driver.getDriver().getTitle());

    }


}
