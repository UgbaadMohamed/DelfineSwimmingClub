import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public abstract class TheCompetitors {
    public static void listeOprettelse(ArrayList<Competitors> time) throws IOException {

        //Midlertidig time(brug localdate time istedet)
        time.add(new Senior("01.1.83"));
        time.add(new Senior("01.03.87"));
        time.add(new Senior("08.01.09"));
        time.add(new Senior("04.11.12"));
        time.add(new Senior("02.01.21"));

        time.add(new Junior("02.12.12"));
        time.add(new Junior("05.11.22"));
        time.add(new Junior("04.12.25"));
        time.add(new Junior("03.12.17"));
        Collections.sort(time, new SortCompetitors());

    }
//Ejerskab; Munira & Ugbaad
}
