package utilities;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class base {
	
	public static WebDriver LaunchBrowser() {
	  	  WebDriver driver;
	  ChromeOptions options = new ChromeOptions();

      // Create preferences map
      Map<String, Object> prefs = new HashMap<>();

      // Disable Chrome's password manager prompt
      prefs.put("credentials_enable_service", false);
      prefs.put("profile.password_manager_enabled", false);

      options.setExperimentalOption("prefs", prefs);

      // Launch Chrome with these options
      driver = new ChromeDriver(options);
      return driver;
	}

	 public static void captureScreenShot(WebDriver driver, String fileName) {
	        TakesScreenshot ts = (TakesScreenshot) driver;
	        File src = ts.getScreenshotAs(OutputType.FILE);
	        try {
	        	    	  
	            FileUtils.copyFile(src, new File("./screenshot/" + fileName + ".png"));
	        } catch (IOException e) {
	            System.out.println(e.getMessage());
	        }
	        // System.out.println("Screenshot is taken.");
	    }

	 public static void highlightElement(WebDriver driver, WebElement element) {

	        JavascriptExecutor js = ((JavascriptExecutor) driver);

	        js.executeScript("arguments[0]" + ".setAttribute('style','background-color: yellow; border: 2px solid red;')",
	                element);

	        try {
	            Thread.sleep(1000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	       
	    }


}
