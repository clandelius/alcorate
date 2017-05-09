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
 * The class excelReader reads information from an excel document using apache poi and thru that creates a copy of the
 * excel sheet from which information can be read.
 */
public class ExcelReader {

    XSSFSheet sheet;

    /**
     * The constructor for ExcelReader takes a filename and creates a copy of the first excel sheet in that file.
     * @param filename  input file, if the file can't be found a filenotfound exception is thrown.
     */
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

    /**
     * This method is specific for our purpose and iterates through the excel sheet created in the onstructor and
     * returns an ArrayList of rows that all have the categories Whisky or Cognac.
     * @return  the ArrayList containing the rows of interest.
     */
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
