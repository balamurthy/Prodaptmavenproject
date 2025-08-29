package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
	WebDriver driver;
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}
	
By usersuccess = By.xpath("//p[contains(@class,\"userdropdown-name\")]");
	
	public String getDashboardTitle() {
		return driver.getTitle();
	}
	
	public boolean isUserLoginSuccessful() {

		try {
			return driver.findElement(usersuccess).isDisplayed();
		}
		catch(NoSuchElementException e) {
			return false;
		}
	}	

}
