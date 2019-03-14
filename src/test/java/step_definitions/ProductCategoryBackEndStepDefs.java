package step_definitions;

import cucumber.api.java.en.Then;
import org.junit.Assert;
import pages.ProductCategoriesPage;
import utilities.BrowserUtils;
import utilities.DBUtils;

import java.util.Arrays;
import java.util.List;

public class ProductCategoryBackEndStepDefs {
    
    ProductCategoriesPage pch;
   
    @Then("Product Categories should match database record")
    public void product_Categories_should_match_database_record() throws InterruptedException {
        pch = new ProductCategoriesPage();
        String sql = "select name from lunch_product_category;";
        Thread.sleep(2000);

        List<String> dbnames = DBUtils.executeQueryAndGetColumnValue(sql, "name");
        System.out.println("dbnames = " + dbnames);

        List<String> urlnames = BrowserUtils.getElementsText(pch.names);
        System.out.println("urlnames = " + urlnames);

        for (String name : dbnames) {
            Assert.assertTrue(urlnames.contains(name));
        }


    }
    @Then("Product Category total amount match database amount record")
    public void product_Category_total_amount_match_database_amount_record() throws InterruptedException {
        pch = new ProductCategoriesPage();
        String sql = "select count(id) from lunch_product_category;";
        Thread.sleep(2000);
        List<String> totalAmount1 = DBUtils.executeQueryAndGetColumnValue(sql, "count");
        String tAmount1=totalAmount1.get(0);

        String tAmount=pch.totalAmount.getText();

        Assert.assertEquals(tAmount,tAmount1);
    }
    @Then("Product {string} match database record")
    public void product_match_database_record(String string) throws InterruptedException {
       pch=new ProductCategoriesPage();
       String sql="select * from lunch_product_category\n" +
               "where name='Pizza';";
       Thread.sleep(2000);
       List<String> dbPizza=DBUtils.executeQueryAndGetColumnValue(sql,"name");
       String dpPizza1=dbPizza.get(0);
        System.out.println(dpPizza1);

        List<String> urlPizza = BrowserUtils.getElementsText(pch.names);
        String urlPizza1=urlPizza.get(1);
        System.out.println(urlPizza.get(1));

        Assert.assertEquals(dpPizza1,urlPizza1);
    }
}
