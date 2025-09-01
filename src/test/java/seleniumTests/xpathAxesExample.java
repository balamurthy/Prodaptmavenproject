package seleniumTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class xpathAxesExample {
	static WebDriver driver;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//file:///D:/wrapper.html
		WebElement txt_email,lnk_logout;
		
		driver = new FirefoxDriver();
		// open the browser with the url
		driver.get("https://money.rediff.com/gainers/bse/daily/groupa");
		
	WebElement getCurrentPrice,getPercentage;  
	
		getCurrentPrice = driver.findElement(By.xpath("//a[contains(text(),'Marico')]/parent::td/following-sibling::td[3]"));
		System.out.println(getCurrentPrice.getText());
		
		//following-sibling
		
		getPercentage = driver.findElement(By.xpath("//a[contains(text(),'Marico')]/parent::td/following-sibling::td[3]/following-sibling::td"));
		System.out.println(getPercentage.getText());
		
		
		
		
	}

}
