package seleniumTests;

 
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
 
public class Actions_hover {
 
 public static WebDriver driver;
 
 public static void main(String[] args) throws InterruptedException {
	 
	    driver=utilities.base.LaunchBrowser();
	    
	    
	 // Launch the URL 
        driver.get("http://demoqa.com/menu/");
        System.out.println("demoqa webpage Displayed");
        
     driver.manage().window().maximize();
	    
	//Instantiate Action Class        
        
		Actions actions = new Actions(driver);
        //Retrieve WebElement 'Main Item 2' to perform mouse hover 
    	WebElement menuOption = driver.findElement(By.xpath("//*[contains(text(),'Main Item 2')]"));
    	
    	//Mouse hover menuOption 'Main Item 2'
    	actions.moveToElement(menuOption).perform();
    	System.out.println("Done Mouse hover on 'Main Item 2' from Menu");
    	Thread.sleep(1000);
    	//Now Select 'Rock' from sub menu which has got displayed on mouse hover of 'Music'
    	WebElement subMenuOption = driver.findElement(By.xpath("//*[contains(text(),'Sub Item')]")); 
    	//Mouse hover menuOption 'Sub Item'
    	actions.moveToElement(subMenuOption).perform();
    	System.out.println("Done Mouse hover on 'Sub Item' from Menu");
    	
    	
        // Close the main window 
    	driver.close();
 }
 
}
 

