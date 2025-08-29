package TestCases;

import java.util.regex.Pattern;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.DashboardPage;
import Pages.LoginPage;
import utilities.base;

public class LoginPageTestCases {
  
	static LoginPage lp;
	static DashboardPage dp;
	static WebDriver driver;
  
	@BeforeClass(groups= {"sanity"})
     public void setup() {
	  System.out.println("Setup done");
	  
	  driver=utilities.base.LaunchBrowser();
	  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	  lp = new LoginPage(driver);
	  
  }
  
  @Test
  public void testTitle() {
	  
	  String expectedTitle = "OrangeHRM";
	  
	  String actualTitle = lp.getLoginTitle();
	  
	  Assert.assertEquals(actualTitle, expectedTitle);
  
  }
  
  @Test
  public void testTitlePattern()
  {
	  
	   //	 Pattern p = Pattern.compile(".*potter.*");
			Pattern p = Pattern.compile("^Orange.*");
	  
	  String actualTitle = lp.getLoginTitle();
	  
	  Assert.assertTrue(base.patternMatch(actualTitle,p));
  }
  
  @Test
  public void testUsernamePosition() {
	  
	  int expectedX = 312;
	  int expectedY = 331;
	  
	  int actualX = lp.checkUsernamePosition().getX();
	  int actualY = lp.checkUsernamePosition().getY();
	  System.out.println(lp.checkUsernamePosition());
	  Assert.assertEquals(actualX, expectedX);
	  Assert.assertEquals(actualY, expectedY);
  
  }
  
  @Test
  public void testPasswordField() {

	  boolean isPasswordField = lp.isPasswordAPasswordField();
  	  Assert.assertTrue(isPasswordField);
  }
  
  @Test	( groups= {"sanity"})
  public void DoLogin() {
	  
	  lp.enterUsername("Admin");
	  lp.enterPassword("admin123");
	  lp.clickLogin();
	  
	  dp = new DashboardPage(driver);
	  Assert.assertTrue(dp.isUserLoginSuccessful());
  
  }
  
  @AfterTest
  public void teardown() {
	  driver.quit();
  }
}
