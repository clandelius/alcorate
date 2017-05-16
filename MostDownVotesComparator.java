import java.util.Comparator;

/**
 * Created by Ramtin on 2017-05-09.
 */
public class MostDownVotesComparator implements Comparator<Drink> {
    /**
     * Compare the amount of down votes associated with two drinks
     * @param d1 drink one
     * @param d2 drink two
     * @return the difference between their down votes for the Collection.sort functions
     */
    @Override
    public int compare(Drink d1, Drink d2) {

        int d1DownVotes = d1.getDownVotes();
        int d2DownVotes = d2.getDownVotes();

        //return d1DownVotes - d2DownVotes; Changed place to make them appear on top
        return d2DownVotes - d1DownVotes;
    }
}
