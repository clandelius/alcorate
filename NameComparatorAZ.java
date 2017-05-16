import java.util.Comparator;

/**
 * Created by Ramtin on 2017-05-09.
 */
public class NameComparatorAZ implements Comparator<Drink> {
    /**
     * Compares the name of two drinks (A to Z)
     * @param d1 drink one
     * @param d2 drink two
     * @return a pos or neg integer
     * negative integer means that d1 goes below d2 in the list
     * positive integer means that d1 goes above d2 in the list
     */
    @Override
    public int compare(Drink d1, Drink d2) {
        String d1Name = d1.getName().toLowerCase();
        String d2Name = d2.getName().toLowerCase();

        return d1Name.compareTo(d2Name);
    }
}
