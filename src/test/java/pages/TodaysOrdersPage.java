package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TodaysOrdersPage {

    @FindBy(css = "[data-menu='101'] .oe_menu_text")
    public WebElement todaysOrdersButton;

    @FindBy(xpath = "//div[@class='o_facet_values']/span")
    public WebElement todayOptionButton;
}
