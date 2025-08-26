package testNGTestCases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class OrangeHrmLoginTest extends utilities.base {
  static WebDriver driver;

  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { "Admin", "admin123" },
      new Object[] { "abcd", "bjjjj" },
    };
  }
  
  @Test(groups = { "regressiontest" }, dataProvider = "dp")
  public void login(String un, String pw) {
       
        
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@placeholder=\"Username\"]")).sendKeys(un);
		driver.findElement(By.name("password")).sendKeys(pw);
		driver.findElement(By.cssSelector("#app > div.orangehrm-login-layout > div > div.orangehrm-login-container > div > div.orangehrm-login-slot > div.orangehrm-login-form > form > div.oxd-form-actions.orangehrm-login-action > button")).click();

		boolean loginSuccess;
		try {
			driver.findElement(By.xpath("//span[@class=\"oxd-userdropdown-tab\"]")); 
			loginSuccess = true;
		}
		catch (NoSuchElementException e) {
			System.out.println("Login Failed - user dropdown not found");
				loginSuccess = false;
				highlightElement(driver, driver.findElement(By.xpath("//p[text()=\"Invalid credentials\"]")));
				captureScreenShot(driver, un +"_" + pw + ".jpg");
				 
			}
		Assert.assertEquals(loginSuccess, true);
  }
  @BeforeClass
  public void beforeClass() {
	  driver=LaunchBrowser();
	  	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
		driver.manage().window().maximize();
  }

  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}
