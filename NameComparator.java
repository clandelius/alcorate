import org.apache.poi.ss.formula.functions.T;

import java.util.Comparator;

/**
 * Created by Ramtin on 2017-05-09.
 */
public class NameComparator implements Comparator<Drink> {



    @Override
    public int compare(Drink d1, Drink d2) {
        String d1Name = d1.getName().toLowerCase();
        String d2Name = d2.getName().toLowerCase();

        return d1Name.compareTo(d2Name);

    }
}
