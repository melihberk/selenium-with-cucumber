package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

public class ExcelUtils {

    public static String getCellValue(String filePath, String sheetName, int row, int col) {
        String cellData = "";
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);
            Row excelRow = sheet.getRow(row);
            Cell cell = excelRow.getCell(col);

            cellData = cell.getStringCellValue();
            System.out.println("📄 Excel'den okunan veri: " + cellData);

        } catch (Exception e) {
            System.out.println("❌ Excel verisi okunamadı: " + e.getMessage());
        }
        return cellData;
    }
}
