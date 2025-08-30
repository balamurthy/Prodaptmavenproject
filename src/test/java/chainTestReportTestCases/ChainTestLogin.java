package chainTestReportTestCases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.chaintest.plugins.ChainTestListener;


@Listeners(ChainTestListener.class)
public class ChainTestLogin {
	static WebDriver driver;
    
	@DataProvider (name = "data-provider")
    public Object[][] dpMethod(){
	 return new Object[][] {{"Admin","admin123"}, {"Admin111","admin122"}};
    }
	
	@BeforeMethod
    public void initialize()
    {
    	driver=new ChromeDriver();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
	@Test(dataProvider="data-provider")
    public void login(String un,String pw) {
    	System.out.println("Username " + un + "  Password:" + pw);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.name("username")).sendKeys(un);
		driver.findElement(By.name("password")).sendKeys(pw);
		ChainTestListener.log("Username:"+ un + " Password:"+ pw);
		driver.findElement(By.xpath("//button")).click();
		boolean loginSuccess;
		try {
			driver.findElement(By.xpath("//span[@class=\"oxd-userdropdown-tab\"]")); 
			loginSuccess = true;
		}
		catch (NoSuchElementException e) {
			System.out.println("Login Failed - user dropdown not found");
				loginSuccess = false;
				 
			}
		Assert.assertEquals(loginSuccess, true);
    }
	 @AfterMethod
	    public void attachScreenshot(ITestResult result){
		 //Take Screenshot on failure
		 System.out.println(result.getStatus());
	        if(!result.isSuccess()){
	            ChainTestListener.embed(takeScreenshot(), "image/png");
	        }
	    }
	 
	    public byte[] takeScreenshot(){
	        return ((TakesScreenshot)(driver)).getScreenshotAs(OutputType.BYTES);
	    }
	 
	   @AfterClass
	   public void tearDown() {
	       driver.quit();
	   }
	 
    
}
