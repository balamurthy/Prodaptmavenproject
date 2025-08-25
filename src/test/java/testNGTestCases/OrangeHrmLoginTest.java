package testNGTestCases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class OrangeHrmLoginTest {
  static WebDriver driver;
	@Test(groups = { "sanitytest" })
  public void login() {
  
		driver.findElement(By.xpath("//input[@placeholder=\"Username\"]")).sendKeys("Adminabc");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.cssSelector("#app > div.orangehrm-login-layout > div > div.orangehrm-login-container > div > div.orangehrm-login-slot > div.orangehrm-login-form > form > div.oxd-form-actions.orangehrm-login-action > button")).click();

		boolean loginSuccess;
		try {
			driver.findElement(By.xpath("//span[@class=\"oxd-userdropdown-tab\"]")); 
			loginSuccess = true;
		}
		catch (NoSuchElementException e) {
			System.out.println("Login Failed - user dropdown not found");
				loginSuccess = false;
			}
		Assert.assertEquals(loginSuccess, true);
  }
  @BeforeClass
  public void beforeClass() {
	  driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
		driver.manage().window().maximize();
  }

  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}
