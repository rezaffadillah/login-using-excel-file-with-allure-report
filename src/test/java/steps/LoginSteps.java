package steps;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import utils.ExcelUtils;
import org.testng.Assert;
import java.io.ByteArrayInputStream;

public class LoginSteps {
    WebDriver driver = DriverFactory.getDriver();
    LoginPage loginPage = new LoginPage(driver);

    @Given("I open the login page")
    public void iOpenLoginPage() {
        System.out.println("URL already opened in Hooks. Current URL: " + driver.getCurrentUrl());
    }

    @When("I login with {string} data from Excel")
    public void iLoginWithDataFromExcel(String usernameKey) throws Exception {
        ExcelUtils excel = new ExcelUtils("src/test/resources/testdata/LoginData.xlsx", "Sheet1");
        for (int i = 1; i <= excel.getRowCount(); i++) {
            if (excel.getCellData(i, 0).equals(usernameKey)) {
                String username = excel.getCellData(i, 1);
                String password = excel.getCellData(i, 2);
                new LoginPage(driver).login(username, password);
                Allure.addAttachment("Screenshot after login", new ByteArrayInputStream(
                    ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
                break;
            }
        }
    }

    @Then("I should see {string}")
    public void iShouldSeeExpectedResult(String expectedResult) {
        loginPage.isHomepageDisplayed(expectedResult);
    }
}