import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class Senior extends Competitors  {


    public Senior() throws IOException {
        super();
    }
    public Senior(Membership membership) throws IOException {
        super(membership);
    }
    public Senior(String locationName, String differentDicipiline, String line) throws IOException {
        super(locationName, differentDicipiline,line);
    }
    public Senior(String time) throws IOException {
        super(time);
    }

    @Override
    public String events(ArrayList<Competitors> lavedlistee) throws IOException {
        return super.events(lavedlistee);
    }

}

