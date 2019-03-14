package step_definitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import pages.LunchHomePage;
import pages.ProductCategoriesPage;
import utilities.BrowserUtils;
import utilities.Driver;

public class ProductCategoriesStep_Defs {
    LunchHomePage lhp = new LunchHomePage();
    ProductCategoriesPage pcp = new ProductCategoriesPage();

    @Then("I navigate to the product categories page")
    public void i_navigate_to_the_product_categories_page() {
        lhp.clickProductCategories();

    }

    @When("I create a new product category")
    public void i_create_a_new_product_category() {
        pcp.createNewProductCategory("American Food");
    }

    @Then("I save the new product category and verify it is created")
    public void i_save_the_new_product_category_and_verify_it_is_created() {
        String initialName = Driver.getDriver().findElement(By.cssSelector(".breadcrumb > .active")).getText();
        pcp.clickSave();
        try {
            BrowserUtils.wait(2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String finalName = Driver.getDriver().findElement(By.cssSelector(".breadcrumb > .active")).getText();
        Assert.assertNotEquals(finalName, initialName);
    }

    @Then("I delete the newly created product category")
    public void i_delete_the_newly_created_product_category() {
       pcp.deleteJustMadeProductCategory();
       pcp.clickOKDelete();
       BrowserUtils.waitForVisibility(Driver.getDriver().findElement(By.cssSelector(".o_pager_limit")), 5);
       String newPageNumber = Driver.getDriver().findElement(By.cssSelector(".o_pager_limit")).getText();
       Assert.assertNotNull(newPageNumber);
    }
}
