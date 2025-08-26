package utilities;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import net.slideshare.test.SlideShareTestCase;

public class Helper {
    @SuppressWarnings("deprecation")
	public static WebDriver launchBrowser(String browserName) {
        WebDriver driver = null;
        if (browserName.equalsIgnoreCase("ie")) {
            driver = new InternetExplorerDriver();
        } else if (browserName.equalsIgnoreCase("chrome")) {
          //  Capabilities cap = DesiredCapabilities.chrome();
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("ff")) {
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {
        	driver=new EdgeDriver();
        }
        
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        return driver;
    }

    public static String linkValidation(String hyperLinkUrl) {
        String result = "";
        try {
            URL url = new URL(hyperLinkUrl);

            HttpURLConnection openConnection = (HttpURLConnection) url.openConnection();
            openConnection.setConnectTimeout(5000);
            openConnection.connect();

            if (HttpURLConnection.HTTP_OK == openConnection.getResponseCode()) {
                result = hyperLinkUrl + " : OK " + openConnection.getResponseCode();
            } else {
                result = hyperLinkUrl + " : " + openConnection.getResponseMessage();
            }
        } catch (Exception e) {
            result = "Exception caught: " + e.getMessage();
        }
        return result;
    }

   /*
    static public void synchronization(WebElement element) {
        WebDriverWait wait = SlideShareTestCase.wait;
        for (int i = 0; i < 5; i++) {
            try {
                wait.until(ExpectedConditions.not(ExpectedConditions.stalenessOf(element)));
                wait.until(ExpectedConditions.visibilityOf(element));
                return;
            } catch (Exception e) {
            }
        }
    }
 */
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