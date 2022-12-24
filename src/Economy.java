import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
public class Economy {
    //—————————————————————————————————————————————————— Variables ———————————————————————————————————————————————————
    private int paymentInput;
    private int accountNumber;
    private final String RED_COLOR = "\\u001B[31m";
    private final String GREEN_COLOR = "\\u001B[32m";
    private final String nameOfFile = "src/economyFile.txt";
    private boolean isPayed;
    private String s;
    PrintStream printStream = new PrintStream(new FileOutputStream(nameOfFile, true));

    //—————————————————————————————————————————————————— Scanner ———————————————————————————————————————————————————
    Scanner sc = new Scanner(System.in);
    //—————————————————————————————————————————————————— Methodes ———————————————————————————————————————————————————

    public void setPayed () {
    }

    public int getAccountNumber() {
        return accountNumber;
    }
    public boolean getIsPayed() {
        return isPayed;
    }

    public Economy() throws FileNotFoundException {
        printStream = new PrintStream(new FileOutputStream(nameOfFile, true));
    }

    public void payNowOrLater() {
        System.out.println("Do you want to pay now OR Later ?");
        System.out.println("Choose '1' (Now) \nChoose '2' (Later)");
        paymentInput = sc.nextInt();
        System.out.println("Please enter your bank accountnumber:");
        accountNumber = sc.nextInt();
        if (paymentInput == 1) {
            isPayed = true;
            System.out.println("We have know with drawn money from your bank account");
        } else if (paymentInput == 2) {
            isPayed = false;
            System.out.println("We have now saved your bank acount informatiion for future payment");
        }
    }

    public void EconomyOverview() {
        System.out.println("OVERVIEW OVER MEMBERS IN DEBT");
        try (InputStreamReader readFilCoche = new InputStreamReader(new FileInputStream(nameOfFile))) {
            int memeberRead = readFilCoche.read();
            while (memeberRead != -1) {
                System.out.print((char) memeberRead);
                memeberRead = readFilCoche.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveToFile() throws FileNotFoundException {

        for (Competitors s : Storage.seniorList) {
            printStream = new PrintStream(new FileOutputStream(nameOfFile, true));
            printStream.append(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")) + " Payment :"  + getIsPayed() +"   Firstname :" + s.ms.getFirstName() +"   Surname :"  + s.ms.getSurName() + "   Acountnumer :" + getAccountNumber() + "   Senior Price:" + s.ms.getSENIOR_PRICE() +  "\n");
            printStream.append("\n__________________________________________________________________________________________________________________________________\n");
        }
        for (Competitors j : Storage.juniorList) {
            printStream = new PrintStream(new FileOutputStream(nameOfFile, true));
            printStream.append(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")) + " Payment :"  + getIsPayed() +"   Firstname :" + j.ms.getFirstName() +"   Surname :"  + j.ms.getSurName() + "   Acountnumer :" + getAccountNumber()  +  "   Junior Price:" + j.ms.getJUNIOR_PRICE() + "\n");
            printStream.append("\n__________________________________________________________________________________________________________________________________\n");
        }
    }
}

//Ejerskab; ugbbad, wei, og munira




