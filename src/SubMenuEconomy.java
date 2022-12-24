import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;
public class SubMenuEconomy {
    private int input;
    Scanner sc = new Scanner(System.in);
    Economy economy = new Economy();

    public SubMenuEconomy() throws FileNotFoundException {
    }
    public void printMenu(String leadText) {
        System.out.println(leadText);
    }

    public void Economyreaderchoic(){
        try {
            System.out.println("\n - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -- -");
            System.out.println( "  E C O N O M Y");
            System.out.print(" - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -- -");
            printMenu("\n  Choose 1. (Payment) \n " + " Choose 2. (Debt overview)\n  Choose 3  (End session)\n" );
            System.out.print("  Enter:");
            input=sc.nextInt();
            switch (input){

                case 1 -> {
                    System.out.println("  Payment");
                    System.out.println(Storage.seniorList);
                    economy.payNowOrLater();

                }
                case 2  -> {
                    System.out.println("  Debt overview");
                    economy.EconomyOverview();
                }

                case 3-> System.out.println("  Exit");
                default->
                        System.out.println(" You typed something the system could not understand");
            }

        }catch (InputMismatchException e){
            System.out.println("Waring you wrote something our system dose not contain ");
        }

    }




}


//Ejerskab;  Munira & Ugbaad & isaac