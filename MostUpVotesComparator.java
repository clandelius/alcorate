/**
 * Created by Ramtin on 2017-05-09.
 */
import java.util.Comparator;

public class MostUpVotesComparator implements Comparator<Drink> {

    @Override
    public int compare(Drink d1, Drink d2) {
        int d1UpVotes = d1.getUpvotes();
        int d2UpVotes = d2.getUpvotes();

        return d1UpVotes - d2UpVotes;
    }
}
