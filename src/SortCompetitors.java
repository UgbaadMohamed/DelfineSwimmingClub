import java.util.Comparator;

public class SortCompetitors implements Comparator<Competitors> {

    public int compare(Competitors a, Competitors b) {
        return b.getTime().compareTo(a.getTime());
    }
}
