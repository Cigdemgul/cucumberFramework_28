package step_definitions;

import cucumber.api.java.en.Then;
import org.junit.Assert;
import pages.ProductCategoriesPage;
import utilities.BrowserUtils;
import utilities.DBUtils;

import java.util.List;

public class ProductCategoryBackEndStepDefs {

    @Then("Product Categories should match database record")
    public void product_Categories_should_match_database_record() throws InterruptedException {
        ProductCategoriesPage pch = new ProductCategoriesPage();
        String sql = "select name from lunch_product_category;";
        Thread.sleep(2000);
        System.out.println();
        List<String> dbnames = DBUtils.executeQueryAndGetColumnValue(sql, "name");
        System.out.println("dbnames = " + dbnames);

        List<String> urlnames = BrowserUtils.getElementsText(pch.names);
        System.out.println("urlnames = " + urlnames);

        Assert.assertEquals(dbnames.size(), urlnames.size());

        for (String name : dbnames) {
            Assert.assertTrue(urlnames.contains(name));
        }


    }

}
