package utilities.dataProvider;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class DataProviderGenerator {

    public static Object[][] generateExcelDataProvider(String excelFilePath, String sheetName){

        String[][] data = null;
        try {
            File file = new File(excelFilePath);
            FileInputStream fis = new FileInputStream(file);
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheet(sheetName);

            int rows = sheet.getPhysicalNumberOfRows();
            int columns = sheet.getRow(1).getPhysicalNumberOfCells();

            System.out.println(rows);
            System.out.println(columns);

            data = new String[rows-1][columns];

            for (int i = 1; i<rows; i++){
                for (int j = 0; j<columns; j++){
                    XSSFCell cellData = sheet.getRow(i).getCell(j);
                    if (cellData == null){
                        data[i-1][j] = "";
                        continue;
                    }
                    CellType cellDataType = sheet.getRow(i).getCell(j).getCellType();
                    if (cellDataType != CellType.STRING){
                        sheet.getRow(i).getCell(j).setCellType(CellType.STRING);
                    }
                    data[i-1][j] = cellData.getStringCellValue();

                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }

        return data;
    }

    public static Object[][] generateExcelDataProviderFirstRow(String excelFilePath, String sheetName){

        String[][] data = null;
        try {
            File file = new File(excelFilePath);
            FileInputStream fis = new FileInputStream(file);
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheet(sheetName);

            int rows = sheet.getPhysicalNumberOfRows();
            int columns = sheet.getRow(1).getPhysicalNumberOfCells();

            System.out.println(rows);
            System.out.println(columns);

            data = new String[1][columns];

            for (int i = 1; i<2; i++){
                for (int j = 0; j<columns; j++){
                    XSSFCell cellData = sheet.getRow(i).getCell(j);
                    if (cellData == null){
                        data[i-1][j] = "";
                        continue;
                    }
                    CellType cellDataType = sheet.getRow(i).getCell(j).getCellType();
                    if (cellDataType != CellType.STRING){
                        sheet.getRow(i).getCell(j).setCellType(CellType.STRING);
                    }
                    data[i-1][j] = cellData.getStringCellValue();

                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }

        return data;
    }
}
