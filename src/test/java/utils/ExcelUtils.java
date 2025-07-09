
package utils;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;

public class ExcelUtils {
    private Sheet sheet;

    public ExcelUtils(String excelPath, String sheetName) throws Exception {
        FileInputStream inputStream = new FileInputStream(excelPath);
        Workbook workbook = new XSSFWorkbook(inputStream);
        sheet = workbook.getSheet(sheetName);
    }

    public String getCellData(int rowNum, int colNum) {
        return sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
    }

    public int getRowCount() {
        return sheet.getLastRowNum();
    }
}
