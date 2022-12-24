import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SubMenuMembership {
    private int input;
    Scanner sc = new Scanner(System.in);
    Membership membership = new Membership();
    ChangeMembership changeMembership = new ChangeMembership();
    Economy economy = new Economy();
    FileHandler fileHandler = new FileHandler();
    public SubMenuMembership() throws IOException {
    }
    public void printMenu(String leadText) {
        System.out.println(leadText);
    }
    public void membershipReaderChoice() {
        try {
            System.out.println("\n - - - - - - - - - - - - - - - - - - - - - - - - - - - " +
                    "- - - - - - - - - - - - - - - - - - - - - - - - - - -- -");
            System.out.println("  M E M B E R S H I P");
            System.out.print(" - - - - - - - - - - - - - - - - - - - - - - - - - - - - - " +
                    "- - - - - - - - - - - - - - - - - - - - - - - - -- -");
            printMenu("\n Choose 1. (New membership) \n " + "Choose 2. (Delete membership)\n " +
                    "Choose 3. (Change membership)\n Choose 4 (End session)\n");
            System.out.print(" Enter:");
            input = sc.nextInt();
            switch (input) {
                case 1 -> {
                    System.out.println(" You choice to create a new member");
                    membership.activeOrPassiveMember();
                    fileHandler.saveCompetitionMembers();
                    economy.payNowOrLater();
                    membership.saveRegularMember();
                    economy.saveToFile();
                }
                case 2 -> {
                    System.out.println(" You choice deleted member");
                    changeMembership.deleteMembership();
                }

                case 3 -> {
                    System.out.println(" You choice change membership");
                    changeMembership.deleteMembership();
                    changeMembership.changeMembership();
                }
                case 4 -> System.out.println(" Exit");
                default -> System.out.println(" You typed something the system could not understand");
            }


        } catch (InputMismatchException e) {
            System.out.println("Warning you wrote something our system dose not contain ");
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
//Ejerskab; Munira & Ugbaad & isaac