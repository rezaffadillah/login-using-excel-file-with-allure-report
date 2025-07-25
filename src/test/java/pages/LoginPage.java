
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    By usernameField = By.xpath("//input[@id='user-name']");
    By passwordField = By.xpath("//input[@id='password']");
    By loginButton = By.xpath("//input[@id='login-button']");
    By homePage = By.cssSelector(".app_logo");
    By errorMessageLogin = By.cssSelector("h3");

    public void login(String username, String password) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public void isHomepageDisplayed(String expected) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            WebElement home = wait.until(ExpectedConditions.visibilityOfElementLocated(homePage));
            String actualValue = home.getText().trim();
            Assert.assertEquals(actualValue, expected, "Home page text does not match expected value.");
        } catch (TimeoutException e) {
            WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageLogin));
            String actualError = error.getText().trim();
            Assert.assertEquals(actualError, expected, "Login error message does not match expected value.");
        }
    }
}
