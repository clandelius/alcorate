import java.util.Comparator;

/**
 * Created by Navid on 2017-05-16.
 */
public class PriceComparatorHighLow implements Comparator<Drink> {
    /**
     * Compares the price of two drinks
     * @param d1 drink one
     * @param d2 drink two
     * @return the price difference for the Collection.sort functions (high to low sorting)
     */
    @Override
    public int compare(Drink d1, Drink d2) {

        double d1Priced = Double.parseDouble(d1.getPrice());
        double d2Priced = Double.parseDouble(d2.getPrice());

        int d1Price = (int) d1Priced;
        int d2Price = (int) d2Priced;

        return -(d1Price - d2Price);
    }
}