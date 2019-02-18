package step_definitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pages.ControlAccountsPage;
import pages.LunchHomePage;

public class ControllingAccounts_mStepDefinitions {
    ControlAccountsPage controlAccountsPage = new ControlAccountsPage();

    int a=0;
    int b =0;
    String amount =null;

    @Then("I go to Control Accounts page as a manager")
    public void i_go_to_Control_Accounts_page_as_a_manager() throws InterruptedException {
        //Thread.sleep(2000);
        LunchHomePage lunchHomePage = new LunchHomePage();
        lunchHomePage.controlAccountsButton.click();
    }

    @Then("I add the amounts of all accounts then I find out the total amount then the amounts should be the same")
    public void i_add_the_amounts_of_all_accounts_then_I_find_out_the_total_amount_then_the_amounts_should_be_the_same() throws InterruptedException {
        ControlAccountsPage controlAccountsPage = new ControlAccountsPage();
        Double amount = controlAccountsPage.sumAccountsDisplayedAccount();
        String totalAmount1 = controlAccountsPage.totalAmount.getText();
        String str = totalAmount1.replaceFirst(",", "");
        Double totalAmount = Double.parseDouble(str);
        Assert.assertEquals(amount, totalAmount);
    }

    @When("I go to Create New Account Section")
    public void i_go_to_Create_New_Account_Section() {
        ControlAccountsPage controlAccountsPage = new ControlAccountsPage();
        controlAccountsPage.createNewAccount.click();
    }

    @Then("I enter information")
    public void i_enter_information() throws InterruptedException {
        ControlAccountsPage controlAccountsPage = new ControlAccountsPage();
        a=controlAccountsPage.findAddedAccount();
        controlAccountsPage.getUsers.click();
        Thread.sleep(2000);
        controlAccountsPage.selectingUser();
        controlAccountsPage.selectingDate();
        controlAccountsPage.setCreateNewAccount("43.99", "New account opened");


    }

    @Then("I save")
    public void i_save() {
        ControlAccountsPage controlAccountsPage = new ControlAccountsPage();
        controlAccountsPage.saveButton.click();

    }

    @Then("the amounts should be the same")
    public void the_amounts_should_be_the_same() throws InterruptedException {
        ControlAccountsPage controlAccountsPage = new ControlAccountsPage();
        Thread.sleep(2000);
        Assert.assertEquals("43.99", controlAccountsPage.amount1.getText());

    }

    @When("I get the number of accounts then the number of accounts should be increased by one")
    public void i_get_the_number_of_accounts_then_the_number_of_accounts_should_be_increased_by_one() {
        LunchHomePage lunchHomePage = new LunchHomePage();
        lunchHomePage.controlAccountsButton.click();
        ControlAccountsPage controlAccountsPage = new ControlAccountsPage();

         b = controlAccountsPage.findAddedAccount();
        Assert.assertEquals(b-a,1);
    }



    @When("I click on import button")
    public void i_click_on_import_button() {

        ControlAccountsPage controlAccountsPage= new ControlAccountsPage();
        controlAccountsPage.importButton.click();

    }
    String path= "/Users/vedat/Documents/lunch.cashmove 1.csv";
    @Then("I upload file path")
    public void i_upload_file_path() {
        ControlAccountsPage controlAccountsPage= new ControlAccountsPage();
        controlAccountsPage.uploadFilePath.sendKeys(path);
    }

    @Then("I click on load file button")
    public void i_click_on_load_file_button() {
        ControlAccountsPage controlAccountsPage= new ControlAccountsPage();
        controlAccountsPage.loadFileButton.click();

    }


    }

