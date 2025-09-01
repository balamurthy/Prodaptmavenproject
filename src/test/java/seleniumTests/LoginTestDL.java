package seleniumTests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.TestDataLoader;
import utilities.base;

public class LoginTestDL extends base{
    WebDriver driver;
    static String url = TestDataLoader.get("baseUrl");
    static String username = TestDataLoader.get("username");
    static String password = TestDataLoader.get("password");
    
    @BeforeClass
    public void setUp() {
    	
    	System.out.println("URL: " + url);
    	System.out.println("Username: " + username);
    	System.out.println("Password: " + password);
    	
    	
    	driver = LaunchBrowser();
        driver.manage().window().maximize();
    }

    @Test
    public void testLogin() {
        driver.get(url);
        WebElement userField = driver.findElement(By.name("username"));
        WebElement passField = driver.findElement(By.name("password"));
        WebElement loginBtn = driver.findElement(By.xpath("//button[contains(@class,\"login-button\")]"));

               loginBtn.click();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
