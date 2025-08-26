package utilities;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class base {
	
	public WebDriver LaunchBrowser() {
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
}
