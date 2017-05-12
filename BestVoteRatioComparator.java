import java.util.Comparator;

/**
 * Created by Ramtin on 2017-05-09.
 */
public class AgeComparator implements Comparator<Drink> {

    @Override
    public int compare(Drink d1, Drink d2) {

        int d1Age;
        int d2Age;

        if (d1.getYear().equals("N/A")) {
            d1Age = 9999;
        } else {
            d1Age = Integer.parseInt(d1.getYear());
        }

        if (d2.getYear().equals("N/A")) {
            d2Age = 9999;
        } else {
            d2Age = Integer.parseInt(d2.getYear());
        }


        int difference = d1Age - d2Age;
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
