/**
 * Created by Cecilia Landelius on 2017-05-06.
 */
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Reads from the excel document systemet.xls. Uses apache poi, code is inspired from their website.
 */
public class ExcelReader {

    XSSFSheet sheet;

    public ExcelReader (String filename){
        FileInputStream file = null;
        try {
            file = new FileInputStream(new File(filename));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        XSSFWorkbook workbook = null;
        try {
            workbook = new XSSFWorkbook(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        sheet = workbook.getSheetAt(0);
    }

    public ArrayList<Row> getCategories() {
        ArrayList<Row> rows = new ArrayList<>();
        Iterator<Row> rowIterator = sheet.iterator();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            String category = row.getCell(11).getStringCellValue();
            if (category.equals("Whisky") || category.equals("Cognac")) {
                rows.add(row);
            }
        }
        return rows;
    }
}
