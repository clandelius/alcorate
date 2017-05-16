import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import static org.junit.Assert.*;

/**
 * Created by Cecilia Landelius on 2017-05-16.
 */
public class ComparatorTest {

    Drink d1;
    Drink d2;
    Drink d3;
    Drink d4;
    ArrayList<Drink> drinks;

    @org.junit.Before
    public void setUp() {
        drinks = new ArrayList<>();
        d1 = new Drink("Q", "1", "qa", "1,00%", 0);
        d2 = new Drink("Ab", "11", "aa", "11,00%", 1901);
        d3 = new Drink("Ac", "12", "ab", "12,00%", 1902);
        d4 = new Drink("Ba", "13", "ba", "13,00%", 1903);
        drinks.add(d1);
        drinks.add(d2);
        drinks.add(d3);
        drinks.add(d4);
    }

    @org.junit.Test
    public void ageHighLowTest() {
        ArrayList<Drink> ageSortedDrinksHL = new ArrayList<>();
        addSortedDrinks(ageSortedDrinksHL);

        assertFalse(drinks.equals(ageSortedDrinksHL));
        Collections.sort(drinks, new AgeComparatorHighLow());
        assertTrue(drinks.equals(ageSortedDrinksHL));
    }

    @org.junit.Test
    public void ageLowHighTest() {
        ArrayList<Drink> ageSortedDrinksLH = new ArrayList<>();
        addSortedDrinks(ageSortedDrinksLH);

        assertFalse(drinks.equals(ageSortedDrinksLH));
        Collections.sort(drinks, new AgeComparatorLowHigh());
        assertTrue(drinks.equals(ageSortedDrinksLH));
    }

    @Test
    public void nameTestHighLow() {
        ArrayList<Drink> nameSortedDrinksHL = new ArrayList<>();
        addSortedDrinks(nameSortedDrinksHL);

        assertFalse(drinks.equals(nameSortedDrinksHL));
        Collections.sort(drinks, new NameComparatorHighLow());
        assertTrue(drinks.equals(nameSortedDrinksHL));
    }

    @Test
    public void nameTestLowHigh() {
        ArrayList<Drink> nameSortedDrinksLH = new ArrayList<>();
        addSortedDrinks(nameSortedDrinksLH);

        assertFalse(drinks.equals(nameSortedDrinksLH));
        Collections.sort(drinks, new NameComparatorLowHigh());
        assertTrue(drinks.equals(nameSortedDrinksLH));
    }

    @Test
    public void percentHighLowTest() {
        ArrayList<Drink> percentageSortedDrinksHL = new ArrayList<>();
        addSortedDrinks(percentageSortedDrinksHL);

        assertFalse(drinks.equals(percentageSortedDrinksHL));
        Collections.sort(drinks, new PercentComparatorHighLow());
        assertTrue(drinks.equals(percentageSortedDrinksHL));
    }

    @Test
    public void percentLowHighTest() {
        ArrayList<Drink> percentageSortedDrinksLH = new ArrayList<>();
        addSortedDrinks(percentageSortedDrinksLH);

        assertFalse(drinks.equals(percentageSortedDrinksLH));
        Collections.sort(drinks, new PercentComparatorLowHigh());
        assertTrue(drinks.equals(percentageSortedDrinksLH));
    }

    @Test
    public void priceHighLowTest() {
        ArrayList<Drink> priceSortedDrinksHL = new ArrayList<>();
        addSortedDrinks(priceSortedDrinksHL);

        assertFalse(drinks.equals(priceSortedDrinksHL));
        Collections.sort(drinks, new PriceComparatorHighLow());
        assertTrue(drinks.equals(priceSortedDrinksHL));
    }

    @Test
    public void priceLowHighTest() {
        ArrayList<Drink> priceSortedDrinksLH = new ArrayList<>();
        addSortedDrinks(priceSortedDrinksLH);

        assertFalse(drinks.equals(priceSortedDrinksLH));
        Collections.sort(drinks, new PriceComparatorLowHigh());
        assertTrue(drinks.equals(priceSortedDrinksLH));
    }

    @Test
    public void upvotesTest() {
        vote();
        ArrayList<Drink> upvotesSortedDrinks = new ArrayList<>();
        addSortedDrinks(upvotesSortedDrinks);

        assertFalse(drinks.equals(upvotesSortedDrinks));
        Collections.sort(drinks, new MostUpVotesComparator());
        assertTrue(drinks.equals(upvotesSortedDrinks));
    }

    @Test
    public void downvotesTest() {
        vote();
        ArrayList<Drink> downvotesSortedDrinks = new ArrayList<>();
        addSortedDrinks(downvotesSortedDrinks);

        assertFalse(drinks.equals(downvotesSortedDrinks));
        Collections.sort(drinks, new MostDownVotesComparator());
        assertTrue(drinks.equals(downvotesSortedDrinks));
    }

    @Test
    public void voteRatioTest() {
        voteWithRatio();
        ArrayList<Drink> voteRatioSortedDrinks = new ArrayList<>();
        addSortedDrinks(voteRatioSortedDrinks);

        assertFalse(drinks.equals(voteRatioSortedDrinks));
        Collections.sort(drinks, new BestVoteRatioComparator());
        assertTrue(drinks.equals(voteRatioSortedDrinks));
    }

    private void addSortedDrinks(ArrayList<Drink> list) {
        list.add(d2);
        list.add(d3);
        list.add(d4);
        list.add(d1);
    }

    private void vote() {
        for (int i = 0; i < 5; i++) {
            d2.upvote();
            d2.downvote();
        }
        for (int j = 0; j < 4; j++) {
            d3.upvote();
            d3.downvote();
        }
        d4.upvote();
        d4.downvote();
    }

    private void voteWithRatio() {
        vote();
        d2.upvote();
        d2.upvote();
        d3.upvote();
        d1.downvote();
    }
}
