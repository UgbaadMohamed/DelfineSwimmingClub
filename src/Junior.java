import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

public class Junior extends Competitors {
    private final String nameOfFile = "src/competitorFile.txt";

    PrintStream printStream = new PrintStream(new FileOutputStream(nameOfFile, true));

    private ArrayList<Competitors> lavedlistee = new ArrayList<>();

    public Junior( Membership membership) throws IOException {
        super(membership);
    }

    public Junior(String locationName, String differentDicipiline, String line) throws IOException {
        super(locationName, differentDicipiline,line);
    }
    public Junior(String time) throws IOException {
        super(time);
    }

    public Junior() throws IOException {
        super();
    }

    @Override
    public String events(ArrayList<Competitors> lavedlistee) throws IOException {
        return super.events(lavedlistee);
    }


}

