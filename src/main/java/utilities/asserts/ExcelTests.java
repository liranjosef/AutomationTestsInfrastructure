package utilities.asserts;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import utilities.asserts.Verifications;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class ExcelTests {

    public static void assert2ExcelFiles(String expectedExcelFilePath, String actualExcelFilePath){

        String[][] data1;
        String[][] data2;

        try {
            File file1 = new File(expectedExcelFilePath);
            FileInputStream fis1 = new FileInputStream(file1);
            XSSFWorkbook wb1 = new XSSFWorkbook(fis1);
            XSSFSheet sheet1 = wb1.getSheetAt(0);

            File file2 = new File(actualExcelFilePath);
            FileInputStream fis2 = new FileInputStream(file2);
            XSSFWorkbook wb2 = new XSSFWorkbook(fis2);
            XSSFSheet sheet2 = wb2.getSheetAt(0);

            int rows1 = sheet1.getPhysicalNumberOfRows();
            int columns1 = sheet1.getRow(1).getPhysicalNumberOfCells();
            System.out.println("number of rows on excel 1: " + rows1);
            System.out.println("number of columns on excel 1: " + columns1);

            int rows2 = sheet2.getPhysicalNumberOfRows();
            int columns2 = sheet2.getRow(1).getPhysicalNumberOfCells();
            System.out.println("number of rows on excel 2: " + rows2);
            System.out.println("number of columns on excel 2: " + columns2);

            Verifications.verifyInts(rows1,rows2,"rows count assert between 2 excels");
            Verifications.verifyInts(columns1,columns2,"columns count assert between 2 excels");

            data1 = new String[rows1][columns1];
            data2 = new String[rows2][columns2];

            for (int i = 0; i<rows1; i++){
                for (int j = 0; i<columns1; j++){
                    XSSFCell cellData1 = sheet1.getRow(i).getCell(j);
                    XSSFCell cellData2 = sheet2.getRow(i).getCell(j);
                    if (cellData1 == null){
                        data1[i][j] = "null";
                        if (cellData2 == null){
                            data2[i][j] = "null";
                            continue;
                        }
                        Verifications.verifyFail("null on table1 and not in table2. location: line " + (i+1) + " and column " + (j+1));
                        continue;
                    }
                    if (cellData2 == null){
                        data2[i][j] = "null";
                        Verifications.verifyFail("null on table2 and not in table1. location: line " + (i+1) + " and column " + (j+1));
                        continue;
                    }

                    CellType cellDataType1 = sheet1.getRow(i).getCell(j).getCellType();
                    CellType cellDataType2 = sheet2.getRow(i).getCell(j).getCellType();

                    if (cellDataType1 != CellType.STRING){
                        sheet1.getRow(i).getCell(j).setCellType(CellType.STRING);
                    }
                    data1[i][j] = cellData1.getStringCellValue();

                    if (cellDataType2 != CellType.STRING){
                        sheet1.getRow(i).getCell(j).setCellType(CellType.STRING);
                    }
                    data2[i][j] = cellData2.getStringCellValue();
                    Verifications.verifyStrings(data1[i][j],data2[i][j],"cell location: line " + (i+1) + " and column " + (j+1));
                }
            }

            System.out.println(Arrays.deepToString(data1));
            System.out.println("---------------------------------------------");
            System.out.println(Arrays.deepToString(data2));

        }   catch (IOException e){
            e.printStackTrace();
        }
        Verifications.verifyAll();

    }
}
