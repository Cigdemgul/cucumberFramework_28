package step_definitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import utilities.DBUtils;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class Hooks {

    @Before
    public void setUp(){
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Driver.getDriver().manage().window().maximize();
    }

    @After
    public void tearDown(){
        Driver.closeDriver();
    }

    @Before(value = "@db")
    public void setUpDBConnection(){
        DBUtils.createConnection();
    }

    @After(value = "@db")
    public void closeDBConnection(){
        DBUtils.closeConnection();
    }

}
