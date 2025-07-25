package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ManualChromeTest {
    @Test
    public void openBrowser() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        System.out.println("Page title: " + driver.getTitle());
        try { Thread.sleep(5000); } catch (Exception e) {}
        driver.quit();
    }
}