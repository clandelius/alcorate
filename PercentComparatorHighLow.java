import java.util.Comparator;

/**
 * Created by Ramtin on 2017-05-09.
 */
public class PercentComparatorHighLow implements Comparator<Drink> {
    /**
     * Compares the alcohol percentage of two drinks
     * @param d1 drink one
     * @param d2 drink two
     * @return the percentage difference for the Collection.sort functions (high to low sorting)
     */
    @Override
    public int compare(Drink d1, Drink d2) {

        String d1String = d1.getAlcoholpercentage();
        String d2String = d2.getAlcoholpercentage();

        String d1Sub = d1String.substring(0,d1String.length()-2); //-2 because all end with 0%
        String d2Sub = d2String.substring(0,d2String.length()-2); //-2 because all end with 0%

        Double d1Double = Double.parseDouble(d1Sub);
        Double d2Double = Double.parseDouble(d2Sub);

        int d1Percent =  (int) (100 * d1Double);
        int d2Percent = (int) (100*d2Double);

        return d2Percent - d1Percent;
    }
}
