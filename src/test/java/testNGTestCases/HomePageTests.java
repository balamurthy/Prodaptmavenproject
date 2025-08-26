package testNGTestCases;

import java.util.ArrayList;

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
        System.out.println("Browser launched");
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

	 @Test(priority=1 ,groups = { "sanitytest" })
	  public void checkBrokenLinks() {
		 driver=LaunchBrowser(); 
		 driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		 <ArrayList> links=(ArrayList) driver.findElements(By.tagName("a"));
		 System.out.println(links.getSize());
			 
		 driver.findElements(By.tagName("a")).forEach(link->{
			 String url=link.getAttribute("href");
			 
			 try {
				java.net.HttpURLConnection connection=(java.net.HttpURLConnection)(new java.net.URL(url).openConnection());
				connection.setRequestMethod("HEAD");
				connection.connect();
				int responseCode=connection.getResponseCode();
				if(responseCode>=400) {
					System.out.println(url+" is a broken link");
						}
				else {
					System.out.println(url+" is a valid link");
					
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
		 });
		 
		 }
		 
		 
			
	  }	

	

