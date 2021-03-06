package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class ProductCategoriesPage {
    public ProductCategoriesPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(css = ".o_list_buttons [type='button']:nth-of-type(1)")
    public WebElement createButton;

    @FindBy(css = "[name='name']")
    public WebElement nameInputBox;

    @FindBy(css = ".o_form_buttons_edit [type='button']:nth-of-type(1)")
    public WebElement saveButton;

    @FindBy(css = ".o_cp_sidebar .o_dropdown:nth-of-type(3) [data-toggle]")
    public WebElement newActionButton;

    @FindBy(linkText = "Delete")
    public WebElement newDeleteButton;

    @FindBy(css = ".o_cp_sidebar .o_dropdown:nth-of-type(2) [data-toggle]")
    public WebElement mainPageAction;

    @FindBy(linkText = "Delete")
    public WebElement mainPageDelete;

    @FindBy(css = ".modal-footer [type='button']:nth-of-type(1)")
    public WebElement deleteOK;

    @FindBy(xpath = "//table[@class='o_list_view table table-condensed table-striped o_list_view_ungrouped']/tbody/tr/td[2]")
    public List<WebElement> names;

    @FindBy(css = ".o_pager_limit")
    public WebElement totalAmount;

    public void createNewProductCategory(String name){
        createButton.click();
        nameInputBox.sendKeys(name);
    }

    public void clickSave(){
        saveButton.click();
    }

    public void deleteJustMadeProductCategory(){
        newActionButton.click();
        newDeleteButton.click();
    }

    public void clickMainPageAction(){
        mainPageAction.click();
    }

    public void clickMainPageDelete(){
        mainPageDelete.click();
    }

    public void clickOKDelete(){
        deleteOK.click();
    }
}
