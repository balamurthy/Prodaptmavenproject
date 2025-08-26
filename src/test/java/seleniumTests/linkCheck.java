package seleniumTests;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class linkCheck extends utilities.base  {
	static WebDriver driver;
	boolean isLinkBroken=false;
	 
	@Test
	public void linkTest() {
	 driver=LaunchBrowser(); 
	 driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
			 driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			
			 List<WebElement> links=driver.findElements(By.tagName("a"));
			 System.out.println(links.size());
				 
			 driver.findElements(By.tagName("a")).forEach(link->{
				 String url=link.getAttribute("href");
				 
				 try {
					java.net.HttpURLConnection connection=(java.net.HttpURLConnection)(new java.net.URL(url).openConnection());
					connection.setRequestMethod("HEAD");
					connection.connect();
					int responseCode=connection.getResponseCode();
					if(responseCode>=404) {
						System.err.println(url+" is a broken link" + responseCode);
						isLinkBroken=true;
					}
					else {
						System.out.println(url+" is a valid link" + responseCode);
						isLinkBroken=false;
								
						
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 Assert.assertEquals(isLinkBroken, false);
			 });
				driver.close();	 
			 }
		
}

