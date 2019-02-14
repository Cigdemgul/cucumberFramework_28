package step_definitions;

import pages.LoginPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.MainPage;
import static org.junit.Assert.*;
import utilities.ConfigurationReader;
import utilities.Driver;

public class LoginStep_Definitions {

    LoginPage loginPage = new LoginPage();
    MainPage mainPage = new MainPage();

    @Given("the user go to url")
    public void the_user_go_to_url() {
        Driver.getDriver().get("url");
    }

    @When("the user clicks on BriteErpDemo button")
    public void the_user_clicks_on_BriteErpDemo_button() {
      mainPage.briteErpDemoButton.click();
    }


    @Given("manager is on the main page")
    public void manager_is_on_the_main_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }



    @When("manager clicks on BriteErpDemo Button")
    public void manager_clicks_on_BriteErpDemo_Button() {

        mainPage.briteErpDemoButton.click();

    }

    @Then("the title should be Login | Website localhost")
    public void the_title_should_be_Login_Website_localhost() {
        assertEquals("Login | Website localhost", Driver.getDriver().getTitle());

    }

    @Then("the database should be {string}")
    public void the_database_should_be(String expectedText) {
        assertEquals(expectedText, loginPage.databaseText.getAttribute("value"));

    }

    @When("the manager enters valid email address")
    public void the_manager_enters_valid_email_address() {
        loginPage.emailInput.sendKeys(ConfigurationReader.getProperty("mailManager"));

    }

    @When("the manager enters valid password")
    public void the_manager_enters_valid_password() {
        loginPage.passwordInput.sendKeys(ConfigurationReader.getProperty("passwordManager"));

    }

    @When("the manager clicks Log in button")
    public void the_manager_clicks_Log_in_button() {
        loginPage.loginButton.click();

    }

    @Then("the title should be Odoo")
    public void the_title_should_be_Odoo() {
        assertEquals("Odoo", Driver.getDriver().getTitle());

    }

    @Given("user is on the main page")
    public void user_is_on_the_main_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));

    }

    @When("user clicks on BriteErpDemo Button")
    public void user_clicks_on_BriteErpDemo_Button() {
        MainPage mainPage = new MainPage();
        mainPage.briteErpDemoButton.click();

    }



    @When("the manager login with {string} and {string}")
    public void the_manager_login_with_and(String email, String password) {
        loginPage.emailInput.sendKeys(ConfigurationReader.getProperty("mailManager"));
        loginPage.passwordInput.sendKeys(ConfigurationReader.getProperty("passwordManager"));
        loginPage.loginButton.click();

    }

    @Then("manager clicks the Lunch Button")
    public void manager_clicks_the_Lunch_Button() {
        loginPage.clickLunchButton();
    }

    @When("the user login with {string} and {string}")
    public void the_user_login_with_and(String email, String password) {
        loginPage.emailInput.sendKeys(ConfigurationReader.getProperty("mailUser"));
        loginPage.passwordInput.sendKeys(ConfigurationReader.getProperty("passwordUser"));
        loginPage.loginButton.click();
    }

    @Then("user clicks the Lunch Button")
    public void user_clicks_the_Lunch_Button() {
        loginPage.clickLunchButton();
    }

    @When("the title should be #Inbox - Odoo")
    public void the_title_should_be_Inbox_Odoo() {
        assertEquals("#Inbox - Odoo" , Driver.getDriver().getTitle());
    }
}
