package step_definitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.LoginPage;
import pages.LunchHomePage;
import utilities.Driver;

import static org.junit.Assert.assertEquals;

public class LunchHomeStep_Definitions {
    LoginPage lpObj = new LoginPage();
    LoginStep_Definitions loginPage = new LoginStep_Definitions();
    LunchHomePage lunchHomePage = new LunchHomePage();







    @When("user should be able to click the ok button")
    public void user_should_be_able_to_click_the_ok_button() {
       lunchHomePage.clickOkError();
    }

    @Then("user is on Lunch Page and the title should be New Order - Odoo")
    public void user_is_on_Lunch_Page_and_the_title_should_be_New_Order_Odoo() {
        assertEquals("New Order - Odoo" , Driver.getDriver().getTitle());
    }


    @When("manager should be able to click the ok button")
    public void manager_should_be_able_to_click_the_ok_button() {
       lunchHomePage.clickOkError();
    }

    @Then("the title should be New Order - Odoo")
    public void the_title_should_be_New_Order_Odoo() {
        assertEquals("New Order - Odoo", Driver.getDriver().getTitle());
    }

}
