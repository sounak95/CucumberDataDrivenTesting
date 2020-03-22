package utils;


import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataHelper {
    public static HashMap<String,String> storeValues = new HashMap<String, String>();
    public static List<HashMap<String,String>> readExcelDatafromFile(String filePath, String sheetName){
        // Create a formatter, do this once
        DataFormatter formatter = new DataFormatter(Locale.US);
        //create Java List to store Hashmaps
        List <HashMap<String,String>>excelData = new ArrayList<>();

        try{
            FileInputStream fs = new FileInputStream(filePath);
            XSSFWorkbook wb = new XSSFWorkbook(fs);
            XSSFSheet sheet = wb.getSheet(sheetName);

            //catch header row, so that you can use it as Key for your hashmap
            Row HeaderRow = sheet.getRow(0);
            //System.out.println("Rows:"+sheet.getPhysicalNumberOfRows());

            for(int r = 1; r<sheet.getPhysicalNumberOfRows();r++){
                Row CurrentRow = sheet.getRow(r);
                //each row of data is stored in new hashmap
                HashMap<String,String> currentRowMap = new HashMap<String,String>();

                //System.out.println("r: "+r) ;

                for(int c=0;c<CurrentRow.getPhysicalNumberOfCells();c++){
                    //	System.out.println("c:" +c);
                    Cell CurrentCell = CurrentRow.getCell(c);
                    //System.out.print(CurrentCell.getStringCellValue() + "\t");
                    //System.out.println(formatter.formatCellValue(CurrentCell));
                    currentRowMap.put(formatter.formatCellValue(HeaderRow.getCell(c)),formatter.formatCellValue(CurrentCell));
                    // i.e hashmap<key, value> = <row(0)column(c), row(1)column(c)>
                }
                excelData.add(currentRowMap);
            }
            wb.close();
            fs.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return excelData;

    }


}