import static org.junit.Assert.*;

/**
 * Created by Cecilia Landelius on 2017-05-06.
 */
public class DrinkTest {

    Drink drink;
    Drink drink2;

    @org.junit.Before
    public void setUp() throws Exception {
        drink = new Drink("Nice Whisky", "10", "whisky", "70,00%", 2014);
        drink2 = new Drink("Nice Whisky", "10", "whisky", "70,00%", 0);
    }

    @org.junit.Test
    public void getName() throws Exception {
        assertTrue(drink.getName().equals("Nice Whisky"));
        assertFalse(drink.getName().equals(""));
    }

    @org.junit.Test
    public void getPrice() throws Exception {
        assertTrue(drink.getPrice().equals("10"));
        assertFalse(drink.getPrice().equals(""));
    }

    @org.junit.Test
    public void getType() throws Exception {
        assertTrue(drink.getType().equals("whisky"));
        assertFalse(drink.getType().equals(""));
    }

    @org.junit.Test
    public void getAlcoholpercentage() throws Exception {
        assertTrue(drink.getAlcoholpercentage().equals("70,00%"));
        assertFalse(drink.getAlcoholpercentage().equals(""));
    }

    @org.junit.Test
    public void getYear() throws Exception {
        assertTrue(drink.getYear() == 2014);
        assertTrue(drink2.getYear() == 9999);
    }

    @org.junit.Test
    public void displayYear() throws Exception{
        assertTrue(drink.displayYear().equals("2014"));
        assertTrue(drink2.displayYear().equals("N/A"));
    }

    @org.junit.Test
    public void upvote() throws Exception {
        assertTrue(drink.getUpvotes() == 0);
        drink.upvote();
        assertTrue(drink.getUpvotes() == 1);
    }

    @org.junit.Test
    public void downvote() throws Exception {
        assertTrue(drink.getDownVotes() == 0);
        drink.downvote();
        assertTrue(drink.getDownVotes() == 1);
    }
}
