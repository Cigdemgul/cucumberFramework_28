package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigurationReader;
import utilities.Driver;

public class LoginPage {
    public LoginPage(){
        PageFactory.initElements(Driver.getDriver() , this);
    }

    MainPage mainPage = new MainPage();

    @FindBy(id = "db")
    public WebElement databaseText;

    @FindBy(id = "login")
    public WebElement emailInput;

    @FindBy(id = "password")
    public WebElement passwordInput;

    @FindBy(css = ".btn-primary")
    public WebElement loginButton;

    @FindBy( css = "[data-menu='94'] .oe_menu_text")
    public WebElement lunchButton;


    @FindBy(xpath = "//*[@id='modal_27']/div/div")
    public WebElement errorWindow;

    //@FindBy(xpath = "//*[@id='modal_9']/div/div/div[3]/button/span")
    @FindBy(xpath = "//*[.='Ok']")
    public WebElement popUpOkButton;


    public void login(String mail, String pass){
        mainPage.briteErpDemoButton.click();
        emailInput.sendKeys(mail);
        passwordInput.sendKeys(pass);
        loginButton.click();

    }

    public void clickLunchButton(){

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lunchButton.click();
    }

    public void open(){
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }


}


