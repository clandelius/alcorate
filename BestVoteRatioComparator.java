import java.util.Comparator;

/**
 * Created by Ramtin on 2017-05-09.
 */
public class BestVoteRatioComparator implements Comparator<Drink> {

    @Override
    public int compare(Drink d1, Drink d2) {
        int d1UpVotes = d1.getUpvotes()*1000000;
        int d1DownVotes = d1.getDownVotes()*1000000;
        int d1TotalVotes = d1UpVotes + d1DownVotes;



        int d2UpVotes = d2.getUpvotes()*1000000;
        int d2DownVotes = d2.getDownVotes()*1000000;
        int d2TotalVotes = d2UpVotes + d2DownVotes;

        //Avoiding division by zero through the use of if-statements
        if(d2TotalVotes == 0 && d1TotalVotes == 0) //equal
        {
            return 0;
        }
        else if(d1TotalVotes != 0 && d2TotalVotes == 0) //d1 > d2
        {
            return -1;
        }
        else if(d1TotalVotes == 0 && d2TotalVotes != 0) //d2 > d1
        {
            return 1;
        }

        int d1Ratio = d1UpVotes/d1TotalVotes;
        int d2Ratio = d2UpVotes/d2TotalVotes;

        return d2Ratio - d1Ratio;
    }
}
