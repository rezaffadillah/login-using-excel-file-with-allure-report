package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
//        features = "src/test/resources/features",
        features = "classpath:features",
        glue = {"steps", "hooks"},
        plugin = {"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
)
public class TestNGTestRunner extends AbstractTestNGCucumberTests {
    static {
        System.out.println("=== STATIC block in TestNGTestRunner executed ===");
    }

    public TestNGTestRunner() {
        super();
        System.out.println("=== CONSTRUCTOR TestNGTestRunner executed ===");
    }
}