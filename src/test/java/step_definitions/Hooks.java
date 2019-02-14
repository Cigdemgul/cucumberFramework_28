package step_definitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class Hooks {

    @Before
    public void setUp(){
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
//
//    @After
////    public void tearDown(){
////        Driver.closeDriver();
////    }
}
