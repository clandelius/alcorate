import org.apache.poi.ss.usermodel.Row;

/**
 * Created by macbook on 2017-05-06.
 */
public class Drink {
    private String name;
    private String price;
    private String type;
    private String alcoholpercentage;
    private int upvotes;
    private int downvotes;

    public Drink(Row row) {
        name = row.getCell(3).getStringCellValue();
        price = row.getCell(5).getStringCellValue();
        type = row.getCell(11).getStringCellValue();
        alcoholpercentage = row.getCell(22).getStringCellValue();
        upvotes = 0;
        downvotes = 0;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public String getAlcoholpercentage() {
        return alcoholpercentage;
    }

    public void upvote(){
        upvotes++;
    }

    public void downvote() {
        downvotes++;
    }

    public int getUpvotes() {
        return upvotes;
    }

    public int getDownVotes() {
        return downvotes;
    }
}
