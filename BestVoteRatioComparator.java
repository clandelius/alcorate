import java.util.Comparator;

/**
 * Created by Ramtin on 2017-05-09.
 */
public class BestVoteRatioComparator implements Comparator<Drink> {

    @Override
    public int compare(Drink d1, Drink d2) {
        int d1UpVotes = d1.getUpvotes();
        int d1DownVotes = d1.getDownVotes();
        int d1TotalVotes = d1UpVotes + d1DownVotes;
        int d1Ratio = (d1UpVotes - d1DownVotes)/d1TotalVotes;

        int d2UpVotes = d2.getUpvotes();
        int d2DownVotes = d2.getDownVotes();
        int d2TotalVotes = d2UpVotes + d2DownVotes;
        int d2Ratio = (d2UpVotes - d2DownVotes)/d2TotalVotes;

        return d1Ratio - d2Ratio;
    }
}
