/**
 * Created by macbook on 2017-05-06.
 */
public class Drink {
    private String name;
    private String price;
    private String type;
    private String alcoholpercentage;
    private int year;
    private int upvotes;
    private int downvotes;

    public Drink(String name, String price, String type, String alcoholpercentage, int year) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.alcoholpercentage = alcoholpercentage;
        this.year = year;
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

    public String getYear() {
        if (year == 0) {
            return "N/A";
        }

        return "" + year;
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

    public String getDrinkString() {
        return name + "\n" + price + " kr   " + type + "    " + alcoholpercentage + "   Year: " + getYear();
    }
}
