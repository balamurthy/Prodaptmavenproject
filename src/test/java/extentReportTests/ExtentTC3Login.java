package extentReportTests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import utilities.TestListener;

@Listeners(TestListener.class)
public class ExtentTC3Login {
	static WebDriver driver;
    @BeforeClass
    public void initialize()
    {
    	driver=new ChromeDriver();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
	@Test
    public void login() {
    	
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button")).click();
		
    	List <WebElement> d = driver.findElements(By.xpath("//*[text()=\"Dashboard\"]"));
    	if (d.size()==2) //This is to check if there is Dashboard displayed on breadcrumb area and left navigation area
    	{	
    		
    		Assert.assertTrue(true);
    	}
    		else
    		{	Assert.assertEquals(false, true);
    		}
    	
    }

    @AfterSuite
    public void closeBrowser() {
		if (driver != null) {
			driver.quit();
		}
	}
}
