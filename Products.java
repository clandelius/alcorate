import org.apache.poi.ss.usermodel.Row;
import java.util.ArrayList;

/**
 * Created by macbook on 2017-05-06.
 * Products send the excel document to the ExcelReader and creates an ArrayList of Drinks from the result.
 */

public class Products {

    //fields
     ExcelReader excelReader;
     ArrayList<Row> rows;
     ArrayList<Drink> drinks;

    /**
     * The constructor send the excel document systemet.xls to ExcelReader, collects the ArrayList of rows and
     * converts them to an arrayList of drinks.
     */
    public Products(){
        excelReader = new ExcelReader("systemet.xls");
        drinks = new ArrayList<>();
        rows = excelReader.getCategories();
        fillDrinks();
    }

    private void fillDrinks() {
        if (rows.size() < 1) {
            return;
        }
        for (Row row : rows) {
            String name = row.getCell(3).getStringCellValue();
            String price = row.getCell(5).getStringCellValue();
            String type = row.getCell(11).getStringCellValue();
            String alcoholpercentage = row.getCell(22).getStringCellValue();
            int year = (int) row.getCell(20).getNumericCellValue();
            Drink drink = new Drink(name, price, type, alcoholpercentage, year);
            drinks.add(drink);      //field
        }
    }

    /**
     * This method returns the ArrayList of drinks created by the constructor. If the rows list is empty
     * the drinks list will also be empty.
     * @return  An ArrayList of drinks.
     */
    public ArrayList<Drink> getDrinks() {
        return drinks;
    }
}
