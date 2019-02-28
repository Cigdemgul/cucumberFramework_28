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

    @FindBy(css = "body > div.o_main > div.o_main_content > div.o_control_panel > div.o_cp_left > div.o_cp_sidebar > div > div:nth-child(1) > button")
    public WebElement printButton;

    @FindBy (css = "body > div.o_main > div.o_main_content > div.o_control_panel > div.o_cp_left > div.o_cp_sidebar > div > div.btn-group.o_dropdown.open > ul > li > a")
    public WebElement lunchOrderButton;

    @FindBy (xpath = "//div[@class = 'o_list_buttons']")
    public WebElement printAndActionButtons;

}
