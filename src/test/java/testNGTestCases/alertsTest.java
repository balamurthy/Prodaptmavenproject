package testNGTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import utilities.Helper;

//Modal dialog boxes
public class alertsTest extends Helper{
	static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		driver=Helper.launchBrowser("chrome");
		
		
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("window.scrollBy(0,300)");
		
		
		
		//first alert 
		driver.findElement(By.id("btnAlert")).click();
		
		driver.switchTo().alert().accept();
		
		//confirm
		/*
		driver.findElement(By.id("confirmButton")).click();
		driver.switchTo().alert().dismiss();
		boolean res = driver.findElement(By.id("confirmResult")).getText().contains("Cancel");
		
		System.out.println(res);
	
		
		
		driver.findElement(By.id("promtButton")).click();
		driver.switchTo().alert().sendKeys ("Selenium");
		String txt = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		
		System.out.println(txt);
		boolean res = driver.findElement(By.id("promptResult")).getText().contains(txt);
		System.out.println(res);
	*/
		
		
	}

}
