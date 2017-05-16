import java.util.Comparator;

/**
 * Created by Ramtin on 2017-05-09.
 */
public class AgeComparatorLowHigh implements Comparator<Drink> {
    /**
     * Compares the production year of two drinks
     * @param d1 drink one
     * @param d2 drink two
     * @return the age difference for the Collection.sort functions (low to high sorting)
     */
    @Override
    public int compare(Drink d1, Drink d2) {

        int d1Year = d1.getYear();
        int d2Year = d2.getYear();

        int difference = d1Year - d2Year;
        return difference;
    }
}
