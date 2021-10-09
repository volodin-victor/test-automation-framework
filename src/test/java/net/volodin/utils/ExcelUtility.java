package net.volodin.utils;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ExcelUtility {
    private static Workbook book;
    private static Sheet sheet;

    /**
     * Methods opens Excel file
     *
     * @param filePath Full path to the file
     */
    private static void openExcel(String filePath) {
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(filePath);
            book = new XSSFWorkbook(fileInputStream);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * Method loads sheet out of Excel book
     *
     * @param sheetName Sheet's name in Excel book
     */
    private static void loadSheet(String sheetName) {
        sheet = book.getSheet(sheetName);
    }

    private static int rowCount() {
        return sheet.getPhysicalNumberOfRows();
    }

    /**
     * Method returns columns count
     *
     * @param rowIndex Index of column
     * @return Count of rows
     */
    private static int colCount(int rowIndex) {
        return sheet.getRow(rowIndex).getLastCellNum();

    }

    /**
     * Method returns data which is in the specific cell
     *
     * @param cellIndex Index of cell
     * @param rowIndex  Index of row
     * @return Data which is in specific row in specific cell
     */
    private static String cellData(int rowIndex, int cellIndex) {
        return sheet.getRow(rowIndex).getCell(cellIndex).toString();

    }

    /**
     * Method turn Excel sheet into Objects array
     *
     * @param filePath  Full path to the Excel file
     * @param sheetName Sheet's name
     * @return Two-dimensional array of Objects
     */
    public static Object[][] excelIntoArray(String filePath, String sheetName) {
        openExcel(filePath);
        loadSheet(sheetName);

        int rows = rowCount();
        int cols = colCount(0);

        Object[][] data = new Object[rows - 1][cols];
        // Iterate over rows
        for (int row = 1; row < rows; row++) {
            // Iterate over cols
            for (int col = 1; col < cols; col++) {
                // store cell to Object [][] data
                data[row - 1][col] = cellData(row, col);
            }
        }

        return data;
    }

    /**
     * Method turns Excel sheet into List of Maps
     *
     * @param filePath  Full path to the Excel file
     * @param sheetName Sheet's name of Excel book
     * @return List of maps
     */
    public static List<Map<String, String>> excelIntoListofMaps(String filePath, String sheetName) {
        openExcel(filePath);
        loadSheet(sheetName);

        List<Map<String, String>> list = new ArrayList<>();
        Map<String, String> excelMap;

        for (int row = 1; row < rowCount(); row++) {
            excelMap = new LinkedHashMap<>();
            for (int c = 0; c < colCount(row); c++) {
                excelMap.put(cellData(0, c), cellData(row, c));
            }
            list.add(excelMap);
        }

        return list;

    }

}