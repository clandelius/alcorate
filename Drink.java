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

    /**
     * Creates new drinks that are later added to the list of Alcorate using the information in Excelreader
     * Excelreader -> Products -> Drinks
     *
     * @param name of the drink
     * @param price of the drink
     * @param type is either whiskey or cognac
     * @param alcoholpercentage of the drink
     * @param year is the production year of the drink
     */
    public Drink(String name, String price, String type, String alcoholpercentage, int year) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.alcoholpercentage = alcoholpercentage;
        this.year = year;
        if (year == 0) {
            this.year = 9999;
        }
        upvotes = 0;
        downvotes = 0;
    }

    /**
     *
     * @return the name of a drink
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return the price of a drink
     */
    public String getPrice() {
        return price;
    }

    /**
     *
     * @return either whiskey or cognac
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @return the alcohol percentage
     */
    public String getAlcoholpercentage() {
        return alcoholpercentage;
    }

    /**
     * Used to ease on other functions when there is no information about the production year
     * @return the year
     */
    public String displayYear() {
        if (year == 9999) {
            return "N/A";
        }

        return "" + year;
    }

    /**
     *
     * @return the production year
     */
    public int getYear() {
        return year;
    }

    /**
     * Vote up a drink
     */
    public void upvote(){
        upvotes++;
    }

    /**
     * Vote down a drink
     */
    public void downvote() {
        downvotes++;
    }

    /**
     *
     * @return the amount of upvotes
     */
    public int getUpvotes() {
        return upvotes;
    }

    /**
     *
     * @return the amount of down votes
     */
    public int getDownVotes() {
        return downvotes;
    }

    /**
     *
     * @return full information about a drink
     */
    public String getDrinkString() {
        return name + "\n" + price + " kr   " + type + "    " + alcoholpercentage + "   Year: " + displayYear();
    }

}
