import org.apache.poi.ss.usermodel.Row;
import java.util.ArrayList;

/**
 * Created by macbook on 2017-05-06.
 */

public class Products {

    //fields
     ExcelReader excelReader;
     ArrayList<Row> rows;
     ArrayList<Drink> drinks;

    public Products(){
        excelReader = new ExcelReader("systemet.xls");
        drinks = new ArrayList<>();
        rows = excelReader.getCategories();
        fillDrinks();
    }

    private void fillDrinks() {
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

    public ArrayList<Drink> getDrinks() {
        return drinks;

    //public static void main(String[] args) {
     //   Products products = new Products();
    //for (Drink drink : drinks) {
      //      System.out.println("Name: " + drink.getName() + " | Price: " + drink.getPrice() + " | Type: " + drink.getType() + " | Year: " + drink.getYear() + " | Alcohol Percentage: " + drink.getAlcoholpercentage());
        //}
   // }
}
