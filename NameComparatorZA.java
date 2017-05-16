import java.util.Comparator;

/**
 * Created by Navid on 2017-05-16.
 */
public class NameComparatorZA implements Comparator<Drink>{
    /**
     * Compares the name of two drinks (Z to A)
     * @param d1 drink one
     * @param d2 drink two
     * @return a pos or neg integer
     * negative integer means that d2 goes below d1 in the list
     * positive integer means that d2 goes above d1 in the list
     */
    @Override
    public int compare(Drink d1, Drink d2) {
        String d1Name = d1.getName().toLowerCase();
        String d2Name = d2.getName().toLowerCase();

        return -(d1Name.compareTo(d2Name));
    }
}
