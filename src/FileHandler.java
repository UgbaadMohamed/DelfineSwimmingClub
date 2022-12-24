import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileHandler extends Competitors {
    private final String cocheonefile = "src/cocheOne.txt";

    private final String cocheTwofile = "src/cocheTwo.txt";

    public FileHandler() throws IOException {
        try {
            this.ps = new PrintStream(new PrintStream(cocheonefile, String.valueOf(true)));
            this.ps = new PrintStream(new PrintStream(cocheTwofile, String.valueOf(true)));

        } catch (IOException e) {
            System.out.println("Messege: " + e);
        }
    }

    public String registrationWithMessege(String messege) {
        return messege ;
    }


    public void saveTooCocheCoche () {
        try {
            ps = new PrintStream(new FileOutputStream(cocheonefile,true));
            ps = new PrintStream(new FileOutputStream(cocheTwofile,true));
            ps.append(registrationWithMessege("Coche: Registred by Fatima") +"\n");
            ps.append(registrationWithMessege("Coche: Registred by Max") +"\n");
            ps.printf("%-12s%-30s%-30s%-10s%n", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")), getLine(), getListDiciplin(), getTime());
        }catch (FileNotFoundException e) {
            System.out.println("Something went wrong while starting the program");
        }
    }

    public void connectMemberToTrainer () throws FileNotFoundException {
        System.out.println("What trainer is assigned?");
        System.out.println("Choose 1 (Max) \nChoose 2 (Fatima) \nChoose 4 (No trainer)");
        int trainer = sc.nextInt();
        if (trainer == 1) {
            saveTooCocheCoche();
        }
        else if (trainer == 2){
            saveTooCocheCoche();
        }

        else if (trainer == 4) {
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
//Ejerskab; ugbaad & munira