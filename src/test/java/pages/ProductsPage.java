package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ProductsPage {
    public ProductsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(css = ".o_list_buttons [type='button']:nth-of-type(1)")
    private WebElement createButton;

    @FindBy(css = ".o_cp_sidebar .o_dropdown:nth-of-type(2) [data-toggle]")
    public WebElement actionButton;

    @FindBy(css = "[name='name']")
    public WebElement newProductName;

    @FindBy(css = "[name='category_id'] input")
    public WebElement newProductCategory;

    @FindBy(css = "[name='supplier'] input")
    public WebElement newProductVendor;

    @FindBy(css = "[name='price']")
    public WebElement newProductPrice;

    @FindBy(css = "[name='description']")
    public WebElement newProductDescription;

    @FindBy(css = ".o_form_buttons_edit [type='button']:nth-of-type(1)")
    public WebElement newProductSave;

    @FindBy(css = ".o_web_client [tabindex='0']:nth-child(5) [tabindex='-1']:nth-of-type(1) a")
    public WebElement categorySandwich;

    @FindBy(xpath = "//body[@class='o_web_client']/div[@class='o_main']/div[@class='o_main_content']/div[@class='o_control_panel']//span[@class='btn-group btn-group-sm']/button[1]")
    public WebElement previousProductsButton;

    @FindBy(css = ".o_cp_pager .btn-group-sm [type='button']:nth-of-type(2)")
    public WebElement nextProductsButton;

    @FindBy(css = ".o_cp_sidebar .o_dropdown:nth-of-type(3) [data-toggle]")
    public WebElement indivProductAction;

    @FindBy(linkText = "Delete")
    public WebElement indivDelete;

    @FindBy(css = ".modal-footer [type='button']:nth-of-type(1)")
    public WebElement deleteOkay;

    @FindBy(css = "thead tr .o_column_sortable:nth-of-type(2)")
    public WebElement productNameSort;

    @FindBy(xpath = "input[type=text][id='o_field_input_387']")
    public WebElement categoryButton;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[3]/div[2]/div/span[1]/span[2]")
    public WebElement countOfProduct;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[2]/div/div/div/table/tbody/tr[1]/td[2] ")
    public WebElement firstProduct;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[2]/div/div/div/table/tbody/tr[1]/td[6]")
    public WebElement firstProductPrice;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[2]/div/div/div/table/tbody/tr[1]/td[3]")
    public WebElement firstProductCategory;

    public void clickCreateButton(){
        createButton.click();
    }

    public void clickActionButton(){
        actionButton.click();
    }

    public void clickSaveButton(){
        newProductSave.click();
    }

    public void clickPreviousProductsButton(){
        previousProductsButton.click();
    }

    public void clickNextProductsButton(){
        nextProductsButton.click();
    }

    public void clickProductNameSort(){
        productNameSort.click();
    }


    public void deleteIndivProduct(){
        indivProductAction.click();
        indivDelete.click();
        deleteOkay.click();
    }

    //Allows for creating a new product
    public void createNewProduct(String name, String price, String description, String vendor){
        newProductName.sendKeys(name);
        newProductPrice.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE);
        newProductPrice.sendKeys(price);
        newProductDescription.sendKeys(description);
        newProductVendor.sendKeys(vendor, Keys.ENTER);
        newProductCategory.click();
        categorySandwich.click();

    }

}
