package Pages;
 
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    WebDriver driver;

    //constructor
	public LoginPage(WebDriver driver) {
	
		this.driver = driver;
	
	}	
	
	//Elements
	By username = By.name("username");
	By password = By.name("password");
	By loginBtn = By.xpath("//button[contains(@class,\"login-button\")]");
	
	
	
	//Actions
	
	public void enterUsername(String user) {
		
		 // Initialize WebDriverWait with a timeout of 15 seconds
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Wait until the element with ID "myDynamicElement" is visible
       wait.until(ExpectedConditions.visibilityOfElementLocated(username));

		driver.findElement(username).sendKeys(user);
	}
	public void enterPassword(String pass) {
		driver.findElement(password).sendKeys(pass);
	
	}
	public void clickLogin() {
		driver.findElement(loginBtn).click();
	
	}
	
	public String getLoginTitle() {
		return driver.getTitle();
	
	}
	public Point checkUsernamePosition() {
		driver.manage().window().maximize();
		 // Initialize WebDriverWait with a timeout of 15 seconds
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Wait until the element with ID "myDynamicElement" is visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(username));


		int x = driver.findElement(username).getLocation().getX();
		int y = driver.findElement(username).getLocation().getY();
		Point p = new Point(x,y);
		return p;
	}
	
	public boolean isPasswordAPasswordField() {
		String type = driver.findElement(password).getAttribute("type");
		if(type.equals("password")) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
}
