package steps;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class Hooks {

    @Before
    public void setUp() {
        WebDriver driver = DriverFactory.getDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
