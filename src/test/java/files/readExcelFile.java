package files;


import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/*import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
*/

//How to read excel files using Apache POI
public class readExcelFile {

	static XSSFCell s_username;
	static XSSFCell s_password;
	//static WebDriver driver;	



	public static void main (String [] args) throws IOException, InterruptedException{
		// open the browser with the url
		//driver.get("http://demowebshop.tricentis.com/");

		//I have placed an excel file 'Test.xlsx' in my D Driver 
		FileInputStream fis = new FileInputStream("D:\\Test.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		

		System.out.println(sheet.getLastRowNum());
		int rowcount = sheet.getLastRowNum();
		for (int i = 1; i < rowcount +1; i ++) {
			s_username = sheet.getRow(i).getCell(0);
			s_password = sheet.getRow(i).getCell(1);
			displayValues(s_username,s_password);
		}
		//String cellval = cell.getStringCellValue();

	}	
	static void displayValues(XSSFCell s_custid2,XSSFCell s_custname2) throws InterruptedException

	{

		System.out.println("Username is:" + s_custid2 + " Password is : " + s_custname2);

		String p1 = s_custid2.toString();	
		String p2 = s_custname2.toString();
		
		
	}


}



