import org.apache.poi.ss.usermodel.Row;
import java.util.ArrayList;

/**
 * Created by macbook on 2017-05-06.
 */

public class Products {

    //fields
    static ExcelReader excelReader;
    static ArrayList<Row> rows;
    static ArrayList<Drink> drinks;

    public Products(){
        excelReader = new ExcelReader("systemet.xls");
        drinks = new ArrayList<>();
        rows = excelReader.getCategories();
        fillDrinks();
    }

    public static void fillDrinks() {
        for (Row row : rows) {
            Drink drink = new Drink(row);
            drinks.add(drink);      //field
        }
    }

    public static void main(String[] args) {
        Products products = new Products();
        for (Drink drink : drinks) {
            System.out.println("Name: " + drink.getName() + " | Price: " + drink.getPrice() + " | Type: " + drink.getType() + " | Alcohol Percentage: " + drink.getAlcoholpercentage());
        }
    }
}
