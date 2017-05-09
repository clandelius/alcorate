import java.util.Comparator;

/**
 * Created by Ramtin on 2017-05-09.
 */
public class MostDownVotesComparator implements Comparator<Drink> {

    @Override
    public int compare(Drink d1, Drink d2) {

        int d1DownVotes = d1.getDownVotes();
        int d2DownVotes = d2.getDownVotes();

        return d1DownVotes - d2DownVotes;
    }
}
