import java.util.Comparator;

/**
 * Created by Navid on 2017-05-16.
 */
public class AgeComparatorHighLow implements Comparator<Drink> {
    /**
     * Compares the production year of two drinks
     * @param d1 drink one
     * @param d2 drink two
     * @return the age difference for the Collection.sort functions (high to low sorting)
     */
    @Override
    public int compare(Drink d1, Drink d2) {

        int d1Year = d1.getYear();
        int d2Year = d2.getYear();

        int difference = d1Year - d2Year;
        return -difference;
    }
}
