package testNGTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomePageTests extends utilities.base {
  
	static WebDriver driver;

	@BeforeClass
	public void setup() {
		driver=LaunchBrowser();
        
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void closebrowser() {
	driver.close();	
	}
	
 @Test(priority=1 ,groups = { "smoketest" })
  public void checkTitle() {
		
	 String expectedTitle="AppleHRM";
	 String actualTitle=driver.getTitle();
	
	 Assert.assertEquals(actualTitle, expectedTitle);		
		
  }	
	@Test(priority=2,groups = { "smoketest" })
	  public void checkFooter() {
			
		Assert.assertTrue(driver.findElement(By.partialLinkText("Inc")).isDisplayed());			
	  }
	
}
