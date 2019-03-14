package step_definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pages.*;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;
import utilities.DBUtils;
import utilities.Driver;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class Alert_mStepDefinitions {




    @Given("I am on the lunch page as a manager")
    public void i_am_on_the_lunch_page_as_a_manager() throws InterruptedException {
        MainPage mainPage = new MainPage();
        LoginPage loginPage = new LoginPage();
        LunchHomePage lunchHomePage = new LunchHomePage();
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        //mainPage.briteErpDemoButton.click();
        loginPage.emailInput.sendKeys(ConfigurationReader.getProperty("mailManager"));
        loginPage.passwordInput.sendKeys(ConfigurationReader.getProperty("passwordManager"));
        loginPage.loginButton.click();
        BrowserUtils.wait(2);
        loginPage.lunchButton.click();
        lunchHomePage.errorOkButton.click();

    }

    @Then("I go to alert page")
    public void i_go_to_alert_page() {
        LunchHomePage lunchHomePage = new LunchHomePage();
        lunchHomePage.alertsPageButton.click();
    }


    @When("I check all the buttons")
    public void i_check_all_the_buttons() {
        AlertsPage alertsPage = new AlertsPage();
        alertsPage.checkAllButton.click();

    }

    @Then("all buttons should be selected")
    public void all_buttons_should_be_selected() {
        AlertsPage alertsPage = new AlertsPage();
    assertEquals(alertsPage.checkAllSelected(),true);
    }

    @Then("I click on Action button")
    public void i_click_on_Action_button() {
        AlertsPage alertsPage = new AlertsPage();
            alertsPage.ActionButton.click();

    }

    @Then("it should export the file")
    public void it_should_export_the_file() {
        AlertsPage alertsPage = new AlertsPage();
        alertsPage.exportButton.click();
        alertsPage.activeField.click();
        alertsPage.setAddField();
        alertsPage.exportToFileButton.click();
    }
    @Then("the total number of alerts should be same as database records")
    public void the_total_number_of_alerts_should_be_same_as_database_records() throws InterruptedException {
       AlertsPage alertsPage = new AlertsPage();
        BrowserUtils.wait(2);
       int actual=Integer.parseInt(alertsPage.numberOfAlerts.getText());
       String query="select * from lunch_alert";

        List<String> list= DBUtils.executeQueryAndGetColumnValue(query,"id");

        int expected=list.size();

        assertEquals(expected,actual);
    }


    @Then("message {int}  should be same as database records")
    public void message_should_be_same_as_database_records(Integer messageNumber) throws InterruptedException {
        AlertsPage alertsPage = new AlertsPage();
        BrowserUtils.wait(2);
        String actualMessage=alertsPage.alertMessages.getText();

        String query="select * from lunch_alert where id=1";

        String expected=DBUtils.executeQueryAndGetColumnValue(query,"message").get(0);
        assertEquals(expected,actualMessage);


    }


    @Then("recurrence of {int}. alert  should be same as database records")
    public void recurrence_of_nd_alert_should_be_same_as_database_records(Integer int1) throws InterruptedException {
        AlertsPage alertsPage = new AlertsPage();
        BrowserUtils.wait(2);
        String actualMessage=alertsPage.recurrenceOfFirstItem.getText();

        String query="select * from lunch_alert where id=1";

        String expected=DBUtils.executeQueryAndGetColumnValue(query,"alert_type").get(0);
        assertEquals(expected,actualMessage);


        //here is a bug: Expected :week
        //Actual   :Every Week
    }

    @Then("name of products should be the same as database records")
    public void name_of_products_should_be_the_same_as_database_records() throws InterruptedException {
        ProductsPage productsPage = new ProductsPage();
        BrowserUtils.wait(2);
        String actualName=productsPage.firstProduct.getText();

        String query="select * from lunch_product where id=1";
        List<String> list=DBUtils.executeQueryAndGetColumnValue(query,"name");
      String expectedName=list.get(0);
       assertEquals(expectedName,actualName);


    }

    @Then("price of products should be the same as database records")
    public void price_of_products_should_be_the_same_as_database_records() throws InterruptedException {
        ProductsPage productsPage = new ProductsPage();
        BrowserUtils.wait(2);
        String actualPrice=productsPage.firstProductPrice.getText();

        String query="select * from lunch_product where id=1";
        List<String> list=DBUtils.executeQueryAndGetColumnValue(query,"price");
        String expectedPrice=list.get(0);
        System.out.println(expectedPrice+" "+actualPrice);
        assertEquals(expectedPrice,actualPrice);
    }

    @Then("category of products should be the same as database records")
    public void category_of_products_should_be_the_same_as_database_records() throws InterruptedException {
        ProductsPage productsPage = new ProductsPage();

        BrowserUtils.wait(2);
        String actualCategory=productsPage.firstProductCategory.getText();

        String query="select lp.name, lp.category_id, lpc.name as category\n" +
                "from lunch_product lp join lunch_product_category lpc\n" +
                "on lp.category_id=lpc.id where lp.category_id=1";

        List<Map<String,Object>> mapList=DBUtils.getQueryResultMap(query);
        String expectedCategory = mapList.get(0).get("category").toString();

        System.out.println(expectedCategory);
        System.out.println(actualCategory);

        assertEquals(expectedCategory,actualCategory);

    }



}
