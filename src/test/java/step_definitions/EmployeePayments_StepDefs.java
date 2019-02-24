package step_definitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.EmployeePaymentsPage;
import pages.LunchHomePage;
import utilities.BrowserUtils;
import utilities.Driver;

import java.util.List;

public class EmployeePayments_StepDefs {
    LunchHomePage lhp = new LunchHomePage();
    EmployeePaymentsPage employeePaymentsPage = new EmployeePaymentsPage();


    @Then("I navigate to the employee payments page")
    public void i_navigate_to_the_employee_payments_page() {
        lhp.clickEmployeePayments();
    }

    @When("I create a new register cash move")
    public void i_create_a_new_register_cash_move() {
        employeePaymentsPage.clickCreate();
        employeePaymentsPage.newAmount.clear();
        employeePaymentsPage.addAmount("50.00");
        employeePaymentsPage.addDescription("Payment for lunch");

        employeePaymentsPage.clickSave();
    }

    @Then("I verify a new cash move has been created")
    public void i_verify_a_new_cash_move_has_been_created() {
        try {
            BrowserUtils.wait(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String finalNameAtTop = Driver.getDriver().findElement(By.cssSelector(".active:nth-child(2)")).getText();

        Assert.assertNotEquals(finalNameAtTop, "new");
    }

    @When("I click the register cash move that was created last")
    public void i_click_the_register_cash_move_that_was_created_last() {
        List<WebElement> productsTable = Driver.getDriver().findElements(By.cssSelector("[class='ui-sortable'] tr"));
        int count = productsTable.size();
        WebElement lastItem = Driver.getDriver().findElement(By.cssSelector(".ui-sortable .o_data_row:nth-of-type(" + count + ") .o_required_modifier:nth-of-type(2)"));
        lastItem.click();
    }

    @Then("I delete that register cash move and verify it was deleted")
    public void i_delete_that_register_cash_move_and_verify_it_was_deleted() {
        BrowserUtils.waitForVisibility(employeePaymentsPage.indivAction,5);
        String initPageLimit = Driver.getDriver().findElement(By.className("o_pager_limit")).getText();

        employeePaymentsPage.deleteIndivItem();
        try {
            BrowserUtils.wait(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String finalPageLimit = Driver.getDriver().findElement(By.className("o_pager_limit")).getText();
        Assert.assertNotEquals(finalPageLimit, initPageLimit);
    }


}
