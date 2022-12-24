
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SubMenuCompetition {
    private int input;
    Scanner sc = new Scanner(System.in);
    Senior senior = new Senior();
    Junior junior = new Junior();
    FileHandler fileHandler = new FileHandler();
    public SubMenuCompetition() throws IOException {
    }
    public void printMenu(String leadText) {
        System.out.println(leadText);
    }
    public void competitionReaderChoice() {
        try {
            System.out.println("\n - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - " +
                    "- - - - - - - - - - - - - - - - - -- -");
            System.out.println("  C O M P O T I T I O N");
            System.out.print(" - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - " +
                    "- - - - - - - - - - - - - - - -- -");
            printMenu("\n  Choose 1. (SwimmingClub.Senior team) \n "
                    + " Choose 2. (SwimmingClub.Junior team)\n  Choose 3  (End session)\n");
            System.out.println();
            System.out.print("  Enter:");
            input = sc.nextInt();
            switch (input) {
                case 1:
                    senior();
                    break;
                case 2:
                    System.out.println(" SwimmingClub.Junior team");
                     junior();
                    break;
                case 3:
                    System.out.println("  Exit");

                default:
                    System.out.println(" You typed something the system couldn't understand");
            }

        } catch (InputMismatchException e) {
            System.out.println("Waring you wrote something our system doesn't contain");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private ArrayList<Competitors> lavedlistee = new ArrayList<>();
    public void senior() throws IOException {
        System.out.println(" SwimmingClub.Senior team");
        System.out.println("1) For top 5 swimmers 2) To register Competitor swimmer");
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        switch (input) {
            case 1 -> {

                System.out.println("top 5 swimmer");
                senior.top5Breast();
            }
            case 2 -> {
                System.out.println("write the ID nr for member you wish to register");
                //2
                fileHandler.connectMemberToTrainer();
                senior.events(lavedlistee);


            }
            default -> System.out.println(" You typed something the system couldn't understand");
        }

    }
    public void junior() throws IOException {
        System.out.println(" SwimmingClub.Junior team");
        System.out.println("1) For top 5 swimmers \n 2) To register Competitor swimmer");
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        switch (input) {
            case 1 -> {
                System.out.println("top 5 swimmer");
                junior.top5Breast();
            }
            case 2 -> {
                System.out.println("write the ID nr for member you wish to register");
                fileHandler.connectMemberToTrainer();
                junior.events(lavedlistee);


            }
            default -> System.out.println(" You typed something the system couldn't understand");
        }
}
}
//Ejerskab; Munira & Ugbaad & isaac
