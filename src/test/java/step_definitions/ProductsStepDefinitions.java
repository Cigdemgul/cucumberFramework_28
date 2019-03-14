package step_definitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.LunchHomePage;
import pages.ProductsPage;
import utilities.BrowserUtils;
import utilities.Driver;

import java.util.List;

public class ProductsStepDefinitions {
    LunchHomePage lhp = new LunchHomePage();
    ProductsPage pp = new ProductsPage();
    public String firstItem = null;

    @Then("I go to products page")
    public void i_go_to_products_page() {
        lhp.clickProducts();

    }

    @When("I create a new product")
    public void i_create_a_new_product() {
        pp.clickCreateButton();
    }

    @Then("I add a product name, category, vendor, and price")
    public void i_add_a_product_name_category_vendor_and_price() {
        pp.createNewProduct("Turkey Melt", "3.00", "Turkey meat with chese", "Galata Restaurant");
    }

    @Then("I click save and verify new product")
    public void i_click_save_and_verify_new_product() {
        pp.clickSaveButton();

        try {
            BrowserUtils.wait(3);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String productNameAtTop = Driver.getDriver().findElement(By.cssSelector(".breadcrumb li:nth-of-type(2)")).getText();

        Assert.assertEquals("Turkey Melt", productNameAtTop);
    }

    @When("I click the last item on the list")
    public void i_click_the_last_item_on_the_list() {
        pp.clickPreviousProductsButton();
        try {
            BrowserUtils.wait(2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<WebElement> productsTable = Driver.getDriver().findElements(By.cssSelector("[class='ui-sortable'] tr"));
        int count = productsTable.size();
        WebElement lastItem = Driver.getDriver().findElement(By.cssSelector(".ui-sortable .o_data_row:nth-of-type(" + count + ") .o_required_modifier:nth-of-type(2)"));
        lastItem.click();
    }

    @When("I choose delete through the action button")
    public void i_choose_delete_through_the_action_button() {
        pp.deleteIndivProduct();

    }

    @Then("I verify product is deleted")
    public void i_verify_product_is_deleted() {
        String initPageLimit = Driver.getDriver().findElement(By.className("o_pager_limit")).getText();
        try {
            BrowserUtils.wait(2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String finalPageLimit = Driver.getDriver().findElement(By.className("o_pager_limit")).getText();

        Assert.assertNotEquals(finalPageLimit, initPageLimit);
    }

    @When("I reorder the page")
    public void i_reorder_the_page() {
        firstItem = Driver.getDriver().findElement(By.cssSelector(".ui-sortable .o_data_row:nth-of-type(1) .o_required_modifier:nth-of-type(2)")).getText();
        pp.clickProductNameSort();
    }

    @Then("I verify it is reordered")
    public void i_verify_it_is_reordered() {
        try {
            BrowserUtils.wait(2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String newFirstItem = Driver.getDriver().findElement(By.cssSelector("tbody .o_data_row:nth-of-type(1) .o_required_modifier:nth-of-type(2)")).getText();

        Assert.assertNotEquals(firstItem, newFirstItem);
    }


}
