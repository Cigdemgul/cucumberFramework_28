package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class OrdersByVendorPage {
    public OrdersByVendorPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "//th[@class = 'o_group_name']/span")
    public WebElement firstVendor;

    @FindBy (xpath = "//th[text()='December 2018 (2)']")
    public WebElement firstVendorDate;

    @FindBy(xpath = "//tr//td[2]//div//input")
    public WebElement firstCheckbox;

    @FindBy(xpath = "//a[@data-section = 'print']")
    public WebElement printButton;

    @FindBy (xpath = "//a[@data-index ='0' and @data-section='print']")
    public WebElement lunchOrderButton;

    @FindBy (xpath = "//div[@class = 'o_list_buttons']")
    public WebElement printAndActionButtons;

}
