package step_definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pages.AlertsPage;
import pages.LoginPage;
import pages.LunchHomePage;
import pages.MainPage;
import utilities.ConfigurationReader;
import utilities.DBUtils;
import utilities.Driver;

import java.sql.ResultSet;
import java.util.List;

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
        Thread.sleep(3000);
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
       Thread.sleep(2000);
       int actual=Integer.parseInt(alertsPage.numberOfAlerts.getText());
       String query="select * from lunch_alert";

        List<String> list= DBUtils.executeQueryAndGetColumnValue(query,"id");

        int expected=list.size();

        assertEquals(expected,actual);
    }


    @Then("message {int}  should be same as database records")
    public void message_should_be_same_as_database_records(Integer messageNumber) throws InterruptedException {
        AlertsPage alertsPage = new AlertsPage();
        Thread.sleep(2000);
        String actualMessage=alertsPage.alertMessages.getText();

        String query="select * from lunch_alert where id=1";

        String expected=DBUtils.executeQueryAndGetColumnValue(query,"message").get(0);
        assertEquals(expected,actualMessage);


    }

}
