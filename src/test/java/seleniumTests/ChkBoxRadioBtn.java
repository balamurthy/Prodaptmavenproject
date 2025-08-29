package seleniumTests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class ChkBoxRadioBtn {
    static WebDriver driver;
	public static void main(String[] args) {
		// Create a new instance of the FireFox driver
		String exePath = "d://chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
		driver = new ChromeDriver();
		
		// Put an Implicit wait, 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// Launch the URL
		driver.get("http://demoqa.com/automation-practice-form");
		
		List<WebElement> rdBtn_gender= driver.findElements(By.name("gender"));
		
		// Create a boolean variable which will hold the value (True/False)
		boolean bValue = false;
		
		// This statement will return True, in case of first Radio button is selected
		bValue = rdBtn_gender.get(0).isSelected();
		
		// This will check that if the bValue is True means if the first radio button is selected
		if(bValue == true){
			// This will select Second radio button, if the first radio button is selected by default
			rdBtn_gender.get(1).click();
		}else{
			// If the first radio button is not selected by default, the first will be selected
			rdBtn_gender.get(0).click();
		}
		
	
		}

}

