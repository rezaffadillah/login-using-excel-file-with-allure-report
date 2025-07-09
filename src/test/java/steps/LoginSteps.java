
package steps;

import io.cucumber.java.en.*;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.Assertions;
import pages.LoginPage;
import utils.ExcelUtils;

import java.io.ByteArrayInputStream;

public class LoginSteps {
    WebDriver driver;

    @Given("I open the login page")
    public void iOpenLoginPage() {
        driver = new ChromeDriver();
        driver.get("https://example.com/login");
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
        String pageSource = driver.getPageSource();
        if (expectedResult.equals("Dashboard Page")) {
            Assertions.assertTrue(pageSource.contains("Welcome"));
        } else if (expectedResult.equals("Login Failed")) {
            Assertions.assertTrue(pageSource.contains("Invalid"));
        }
        driver.quit();
    }
}
