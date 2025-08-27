package testNGTestCases;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class linkCheck extends utilities.base  {
	static WebDriver driver;
	 boolean isThereBrokenLink=false;	
		 
	@Test(groups= {"regression"})
	public void linkTest() {
		
	 driver=LaunchBrowser(); 
	 driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
			 driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			
			 List<WebElement> links=driver.findElements(By.tagName("a"));
			 System.out.println(links.size());
				 
			 driver.findElements(By.tagName("a")).forEach(link->{
			
				 String url = link.getAttribute("href");
				 String message = utilities.base.linkValidation1(url);
				 System.out.println(message);
				 Reporter.log(message);
				 Reporter.log("<br>");
				 if (message.contains("OK"))
				 {
					 isThereBrokenLink=false;
				 }
				 else
				 {
					 isThereBrokenLink=true;
				 }
					 
			 
			 });
			
			 Assert.assertEquals(isThereBrokenLink, false);	 
			 driver.quit();	 
				
			  }
		
}

