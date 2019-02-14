package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class OrdersByVendorPage {
    public OrdersByVendorPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "//*[@class = 'o_group_name']")
    public WebElement firstVendor;

    @FindBy (xpath = "//*[.= 'January 2019 (2)']")
    public WebElement firstVendorDate;

    @FindBy(xpath = "//*[.= '01/21/2019']")
    public WebElement firstCheckbox;

    @FindBy(xpath = "//div/button[@class= 'o_dropdown_toggler_btn btn btn-sm dropdown-toggle']")
    public WebElement printButton;

    @FindBy (xpath = "//div//ul/li/a[@data-index= '0']")
    public WebElement lunchOrderButton;

}
