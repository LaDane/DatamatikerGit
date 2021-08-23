import java.util.Comparator;

public class PointScoreSorter implements Comparator<Team> {
    @Override
    public int compare(Team team1, Team team2) {

        Integer t1Points = team1.getPoints();
        Integer t2Points = team2.getPoints();

        int iComp = (t1Points.compareTo(t2Points));

        if (iComp != 0) {
            return iComp;
        }

        Integer t1PointScore = team1.getPointScore();
        Integer t2PointScore = team2.getPointScore();

        return (t1PointScore.compareTo(t2PointScore));
    }
}