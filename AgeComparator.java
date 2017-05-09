import java.util.Comparator;

/**
 * Created by Ramtin on 2017-05-09.
 */
public class AgeComparator implements Comparator<Drink> {

    @Override
    public int compare(Drink d1, Drink d2) {

        if (d1.getYear().equals("N/A")) {
            d1.setAge();
        }

        if(d2.getYear().equals("N/A")) {
            d2.setAge();
        }

        int d1Year = Integer.parseInt(d1.getYear());
        int d2Year = Integer.parseInt(d2.getYear());

        int difference = d1Year - d2Year;
        return difference;

        /*
        if(difference == 0)
        {
            return 0;
        }
        else if(difference > 0){
            return 1;
        }
        return -1;
    }
    */

        //could be shortened down to:
        // return difference;
        // but I don't know why.
    }
}
