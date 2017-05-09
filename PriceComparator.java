import java.util.Comparator;

/**
 * Created by Ramtin on 2017-05-09.
 */
public class PriceComparator implements Comparator<Drink> {

    //Returns 0 if objects are equal, 1 if d1 > d2 and -1 if d2 > d1.
    @Override
    public int compare(Drink d1, Drink d2) {

        int d1Price = Integer.parseInt(d1.getPrice());
        int d2Price = Integer.parseInt(d2.getPrice());

        if(d1Price > d2Price)
        {
            return 1;
        }
        else if(d1Price == d2Price)
        {
            return 0;
        }
        else {
            return -1;
        }

        //return d1Price - d2Price; instead, but don't know why.
    }
}
