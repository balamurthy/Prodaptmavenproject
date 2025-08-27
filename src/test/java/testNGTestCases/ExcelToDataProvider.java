package testNGTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utilities.ExcelApiTest;
 
public class ExcelToDataProvider extends utilities.base {
     static WebDriver driver;
    String xlFilePath = "d:\\Test.xlsx";
    String sheetName = "Sheet1";
    ExcelApiTest eat = null;
     
    @Test(dataProvider = "userData")
 public void login(String un, String pw) {
       
        
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@placeholder=\"Username\"]")).sendKeys(un);
		driver.findElement(By.name("password")).sendKeys(pw);
		driver.findElement(By.cssSelector("#app > div.orangehrm-login-layout > div > div.orangehrm-login-container > div > div.orangehrm-login-slot > div.orangehrm-login-form > form > div.oxd-form-actions.orangehrm-login-action > button")).click();

		boolean loginSuccess;
		try {
			driver.findElement(By.xpath("//span[@class=\"oxd-userdropdown-tab\"]")); 
			loginSuccess = true;
		}
		catch (NoSuchElementException e) {
			System.out.println("Login Failed - user dropdown not found");
				loginSuccess = false;
				highlightElement(driver, driver.findElement(By.xpath("//p[text()=\"Invalid credentials\"]")));
				captureScreenShot(driver, un +"_" + pw + ".jpg");
				 
			}
		Assert.assertEquals(loginSuccess, true);
  }
  @BeforeClass
  public void beforeClass() {
	  	driver=LaunchBrowser();
	  	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
		driver.manage().window().maximize();
  }

  @AfterClass
  public void afterClass() {
	  driver.close();
  }
 
     
    @DataProvider(name="userData")
    public Object[][] userFormData() throws Exception
    {
        Object[][] data = testData(xlFilePath, sheetName);
        return data;
    }
     
    public Object[][] testData(String xlFilePath, String sheetName) throws Exception
    {
        Object[][] excelData = null;
        eat = new ExcelApiTest(xlFilePath);
        int rows = eat.getRowCount(sheetName);
        int columns = eat.getColumnCount(sheetName);
                 
        excelData = new Object[rows-1][columns];
        //for each row 
        for(int i=1; i<rows; i++)
        {
        	//for each column within the row
            for(int j=0; j<columns; j++)
            {
                excelData[i-1][j] = eat.getCellData(sheetName, j, i);
            }
             
        }
        return excelData;
    }
}