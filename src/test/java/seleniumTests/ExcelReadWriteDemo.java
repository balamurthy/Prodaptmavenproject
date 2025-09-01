package seleniumTests;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelReadWriteDemo {

    @SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException {
        String filePath = "src/test/resources/srchData.xlsx";

        // Load Excel
        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet("Sheet1");
        
        Cell headerCell = sheet.getRow(0).createCell(2); // 3rd column (0-based index)
        
        headerCell.setCellValue("SearchResult");
        
        // Loop through rows in first column
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {  // start from row 1 (skip header)
            Row row = sheet.getRow(i);
            if (row != null) {
                Cell expectedNosCell = row.getCell(1); // read first column
                expectedNosCell.setCellType(CellType.STRING);
                String expectedNosValue = expectedNosCell.getStringCellValue();

                System.out.println("Row " + i + " First Column Value: " + expectedNosValue);

                // Write to another column (say column 2 -> index 1, or new column 3 -> index 2)
                Cell newCell = row.createCell(2); // 3rd column (0-based index)
                newCell.setCellValue(expectedNosValue);
            }
        }

        // Save the changes
        fis.close();
        FileOutputStream fos = new FileOutputStream(filePath);
        workbook.write(fos);
        fos.close();
        workbook.close();

        System.out.println("Excel updated successfully!");
    }
}
