package testNGTestCases;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OrangeHRMLoginTestWithEnvProfile {

    WebDriver driver;
    String baseUrl;

    @BeforeTest
    public void setUp() {
        // Read from Maven profile
        baseUrl = System.getProperty("baseUrl");
        String env = System.getProperty("env");

        System.out.println("Running tests on environment: " + env);
        System.out.println("Opening URL: " + baseUrl);

        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testLoginPage() {
        driver.get(baseUrl);

        // Just verify title for demo purpose
        String title = driver.getTitle();
        System.out.println("Page title is: " + title);
        assert title.contains("OrangeHRM");
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
