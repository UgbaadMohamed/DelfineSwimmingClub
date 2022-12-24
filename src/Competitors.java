import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Stream;


public abstract class Competitors {
    private int places = 1;

    private final String competitorMemberFile = "src/competitorMemberFile.txt";
    private final String nameOfFile = "competitorFile.txt";
    private final String cocheonefile = "src/cocheOne.txt";
    private final String cocheTwofile = "src/cocheTwo.txt";
    private String locationName;

    private String differentDicipilin;
    private String line;

    private String time;
    PrintStream ps = new PrintStream(new FileOutputStream(nameOfFile, true));
    Scanner sc = new Scanner(System.in);
    Membership ms = new Membership();
    ArrayList<String> ListDiciplin = new ArrayList<>();

    //Arraylister......
    private ArrayList<String> butterflylist  = new ArrayList();
    private ArrayList<String> breastswimminglist  = new ArrayList();
    private ArrayList<String> backswimminglist  = new ArrayList();

    //..................constructor..................
    public Competitors(String locationName, String differentDicipiline, String line) throws IOException {
        generateTime();
        this.line = line;
        this.differentDicipilin = differentDicipiline;
        this.locationName = locationName;
    }
    public Competitors(Membership membership) throws IOException {
        this.ms = membership;
    }
    public Competitors() throws IOException {
    }
    public Competitors(String time) throws IOException {
        this.time=time;
    }

    public void setDifferentDicipilin(String differentDicipilin) {
        this.differentDicipilin = differentDicipilin;
    }
    public String getLine () {
        return line;
    }
    public String getTime () {
        return time;
    }
    public String getDifferentDicipilin() {
        return differentDicipilin;
    }
    public ArrayList<String> getListDiciplin() {
        return ListDiciplin;
    }

    // The ranking of each memeber
    public int placeList() {
        places = places + 1;
        return places;
    }
    //Methode that gets a random time we cn sort afterwards
    public LocalTime generateTime() {
        LocalTime lt = LocalTime.of(1, 1, 1);
        long secound = ChronoUnit.MINUTES.between(lt, LocalTime.now().minusHours(1));
        LocalTime tid = lt.plusMinutes(new Random().nextInt((int) secound + 1));
        return tid;
    }
    public String events(ArrayList<Competitors>lavedlistee) throws IOException {
        Scanner in = new Scanner(System.in);
        try (InputStreamReader readFilCoche = new InputStreamReader(new FileInputStream(competitorMemberFile))) {
            int memeberRead = readFilCoche.read();
            while (memeberRead != -1) {
                System.out.print((char) memeberRead);
                memeberRead = readFilCoche.read();
            }
        }
        System.out.println("Write the Id of the person you wish to register");
        int number = sc.nextInt();
        try (Stream<String> lines = Files.lines(Paths.get(competitorMemberFile))) {
            line = lines.skip(number).findFirst().get();
        }

        System.out.println("How many dicpilins do you wish to register");
        int dicplininput = sc.nextInt();
        for (int i = 0; i < dicplininput; i++) {
            System.out.println("The name of the location ");
            locationName = in.nextLine();
            System.out.println("\nSwimming Disciplins" + "(\nChoose 1 (breastSwimming) \nChoose 2 (butterfly)\nChoose 3 (backSwimming)");
            int inputSwimmingDisciplin = sc.nextInt();

            switch (inputSwimmingDisciplin) {
                case 1 -> {
                    breastswimminglist.add("breastswimming" + line);
                }
                case 2 -> {
                    butterflylist.add("butterfly" + line);
                }

                case 3 -> {
                    backswimminglist.add("BackSwimming" + line);
                }
            }
        }
        System.out.println("Registration Succefully");
        TheCompetitors.listeOprettelse(lavedlistee);

        return locationName + differentDicipilin;
      }





    public void top5Breast() {
            try (InputStreamReader readFilCoche = new InputStreamReader(new FileInputStream(cocheonefile)))  {
                int memeberRead = readFilCoche.read();
                while (memeberRead != -1) {
                    System.out.print((char) memeberRead);
                    memeberRead = readFilCoche.read();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try (InputStreamReader readFilCoche = new InputStreamReader(new FileInputStream(cocheTwofile)))  {
                int memeberRead = readFilCoche.read();
                while (memeberRead != -1) {
                    System.out.print((char) memeberRead);
                    memeberRead = readFilCoche.read();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
      public void saveCompetitionMembers () {
                try {
                    for (Competitors s : Storage.seniorList) {
                        ps = new PrintStream(new FileOutputStream(competitorMemberFile, true));
                        ps.append("\n"+ "  ID:  " + "Firstname :" + s.ms.getFirstName() + "   Surname :" + s.ms.getSurName()  );
                        //printStream.append("\n__________________________________________________________________________________________________________________________________\n");
                    }
                    for (Competitors j : Storage.juniorList) {
                        ps = new PrintStream(new FileOutputStream(competitorMemberFile, true));
                        ps.append("\n"+"  ID:  " + "Firstname :" + j.ms.getFirstName() + "   Surname :" + j.ms.getSurName()+ "\n");
                        //printStream.append("\n__________________________________________________________________________________________________________________________________\n");
                    }

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

    @Override
    public String toString() {
        return " " + ms;
    }
}
//Ejerskab; Munira & Ugbaad
