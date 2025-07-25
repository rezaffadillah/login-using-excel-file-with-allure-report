package factory;

import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            System.out.println(">>>> INITIALIZING CHROME DRIVER...");
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            String headless = System.getProperty("headless", "false");
            System.out.println(">>>> Headless mode is set to: " + headless);
            if (headless.equalsIgnoreCase("true")) {
                options.addArguments("--headless");
            }
            driver = new ChromeDriver(options);
            System.out.println(">>>> CHROME DRIVER INITIALIZED!");
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}