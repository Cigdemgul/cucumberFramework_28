package step_definitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pages.ControlAccountsPage;
import pages.LunchHomePage;
import pages.PreviousOrdersPage;
import utilities.Driver;

public class PreviousOrders_mStepDefinitions {

    @Then("I go to Previous Orders page as a manager")
    public void i_go_to_Previous_Orders_page_as_a_manager() {
        LunchHomePage lunchHomePage = new LunchHomePage();
        lunchHomePage.clickPreviousOrder();
    }

    @Then("I go to previous order details")
    public void i_go_to_previous_order_details() {
        PreviousOrdersPage previousOrdersPage = new PreviousOrdersPage();
        previousOrdersPage.orderAtTheTop.click();
    }

    @Then("I go to Action details")
    public void i_go_to_Action_details() {
        PreviousOrdersPage previousOrdersPage = new PreviousOrdersPage();
        previousOrdersPage.actionButton.click();


    }

    @Then("I should be able to see {string}")
    public void i_should_be_able_to_see(String string) {
        PreviousOrdersPage previousOrdersPage = new PreviousOrdersPage();
        Assert.assertEquals("Delete",previousOrdersPage.deleteButtonUnderAction.getText());

    }

    @Then("I go to invoicing manager")
    public void i_go_to_invoicing_manager() {
        LunchHomePage lunchHomePage = new LunchHomePage();
        lunchHomePage.controlAccountsButton.click();
        ControlAccountsPage controlAccountsPage = new ControlAccountsPage();
       controlAccountsPage.invoicingManager.click();
    }

    @When("I select an order")
    public void i_select_an_order() throws InterruptedException {
        ControlAccountsPage controlAccountsPage = new ControlAccountsPage();
        controlAccountsPage.selectingAnOrder.click();
        Thread.sleep(2000);
    }

    @Then("I click on action button")
    public void i_click_on_action_button()  {
        ControlAccountsPage controlAccountsPage = new ControlAccountsPage();
       controlAccountsPage.actionButton.click();


    }

    @Then("I should see {string}")
    public void i_should_see(String string) {
ControlAccountsPage controlAccountsPage = new ControlAccountsPage();
        Assert.assertEquals("Export",controlAccountsPage.exportButton.getText());

    }

    double addedTotalPrice=0;
    double invoiceTotalPrice=0;
    @Then("I select order")
    public void i_select_order() {
        PreviousOrdersPage previousOrdersPage =new PreviousOrdersPage();
         addedTotalPrice=previousOrdersPage.setSelectPrint(2);


        previousOrdersPage.printButton.click();
       previousOrdersPage.lunchOrderPrintButton.click();

    }


    @When("I get the price from invoice print document")
    public void i_get_the_price_from_invoice_print_document() throws InterruptedException {
        PreviousOrdersPage previousOrdersPage = new PreviousOrdersPage();
        Driver.getDriver().switchTo().frame(previousOrdersPage.iFrame);
        Thread.sleep(2000);
         invoiceTotalPrice=Double.parseDouble(previousOrdersPage.totalPriceOnInvoice.getText());

    }

    @Then("invoice total price and total price should be same")
    public void invoice_total_price_and_total_price_should_be_same() throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertEquals(addedTotalPrice,invoiceTotalPrice,0.0);
    }


}
