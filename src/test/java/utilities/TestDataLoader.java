package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class TestDataLoader {

    static {
        try (InputStream input = TestDataLoader.class.getClassLoader()
                                                     .getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new RuntimeException("config.properties not found in classpath!");
            }

            Properties props = new Properties();
            props.load(input);

            // Push into System properties
            for (String key : props.stringPropertyNames()) {
                if (System.getProperty(key) == null) { 
                    // don’t override if already set via -D
                    System.setProperty(key, props.getProperty(key));
                }
            }

            System.out.println("✅ Config loaded at class load time");

        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }
    

    // Optional convenience method
    public static String get(String key) {
        return System.getProperty(key);
    }


// ==============================
// 2. Get Excel Data
// ==============================
public static String getExcelData(String filePath, String sheetName, int rowNum, int colNum) {
    try (FileInputStream fis = new FileInputStream(filePath)) {
    	XSSFWorkbook workbook = new XSSFWorkbook(fis);
        
        XSSFSheet sheet = workbook.getSheet(sheetName);
        return sheet.getRow(rowNum).getCell(colNum).toString();
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
}

// ==============================

// 3. TestNG DataProvider (Excel driven)
// ==============================
@DataProvider(name = "loginData")
public static Object[][] getLoginData() {
    String filePath = "src/test/resources/TestData.xlsx";
    String sheetName = "Sheet1";

    try (FileInputStream fis = new FileInputStream(filePath)) {
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet(sheetName);

        //int rowCount = sheet.getPhysicalNumberOfRows();
        int rowCount =  sheet.getLastRowNum() + 1; // Including header
        int colCount =  sheet.getRow(0).getPhysicalNumberOfCells();

        Object[][] data = new Object[rowCount - 1][colCount];

        for (int i = 1; i < rowCount; i++) {
            XSSFRow row =  sheet.getRow(i);
            for (int j = 0; j < colCount; j++) {
                data[i - 1][j] = row.getCell(j).toString();
            }
        }
        return data;

    } catch (Exception e) {
        e.printStackTrace();
        return new Object[0][0];
    }
}

public static String getCellValue(String xlpath, String sheetname, int row, int col) {
	// TODO Auto-generated method stub
	
    try (FileInputStream fis = new FileInputStream(xlpath)) {
    	  XSSFWorkbook workbook = new XSSFWorkbook(fis);
          XSSFSheet sheet = workbook.getSheet(sheetname);
  return sheet.getRow(row).getCell(col).toString();
    }
    catch (Exception e) {
		e.printStackTrace();
		return null;
	}

}
}