package seleniumTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class framesExample extends utilities.base{
	static WebDriver driver;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		driver=LaunchBrowser();
		
		driver.get("https://the-internet.herokuapp.com/nested_frames");
		
		driver.switchTo().frame("frame-bottom");
		//System.out.println(driver.findElement(By.id("content")).getText());
		System.out.println(driver.findElement(By.tagName("body")).getText());
		
		
	}

}
