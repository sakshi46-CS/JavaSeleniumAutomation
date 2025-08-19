package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

public class ExcelReader {
    Workbook workbook;

    public ExcelReader(String filePath) {
        try {
            FileInputStream fis = new FileInputStream(filePath);
            workbook = new XSSFWorkbook(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getCellData(String sheetName, int row, int col) {
        Sheet sheet = workbook.getSheet(sheetName);
        return sheet.getRow(row).getCell(col).getStringCellValue();
    }
}
