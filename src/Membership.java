import java.io.*;

import java.security.PublicKey;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
public  class Membership  {
    //—————————————————————————————————————————————————— Variables ———————————————————————————————————————————————————
    private String firstName;
    private String surName;
    private String inputLine;
    private int age;
    private int input;
    private int price;
    private final int SENIOR_PRICE = 1600;
    private final int JUNIOR_PRICE = 1000;
    private final int OVER_60_PRICE = 1200;
    private final int PASSIV_PRICE = 500;
    private final String nameOfFile = "src/economyFile.txt";



    //—————————————————————————————————————————————————— Constructur ———————————————————————————————————————————————————
    public Membership() throws IOException {
    }

    public Membership (int price) throws IOException {
        this.price = price;
    }

    public Membership(int memeberID, String firstName, String surName) throws FileNotFoundException {
    }

    public int getSENIOR_PRICE () {
        return SENIOR_PRICE;
    }
    public int getJUNIOR_PRICE () {
        return JUNIOR_PRICE;
    }
    public int getOVER_60_PRICE () {
        return OVER_60_PRICE;
    }
    public int getPASSIV_PRICE () {
        return PASSIV_PRICE;
    }

    public Membership(String firstName, String surName) throws IOException {
        this.firstName= firstName;
        this.surName= surName;
    }
    //——————————————————————————————————————————————————  Arraylist ————————————————————————————————————————————————————
    private ArrayList<String> regularMember = new ArrayList<String>();
    //——————————————————————————————————————————————————  Scanner & instance ————————————————————————————————————————————————————
    Scanner sc = new Scanner(System.in);
    Economy economy = new Economy();
    //———————————————————————————————————————————————————————  Getter ———————————————————————————————————————————————————————————
    public String getInputLine() {
        return inputLine;
    }

    public ArrayList<String> getRegularMember() {
        return regularMember;
    }

    public String getFirstName(){
        return firstName;
    }
    public String getSurName(){
        return surName;
    }
    public int getPrice () {
        return price;
    }
    public int getAge(){
        return age;
    }
    //——————————————————————————————————————————————————  Setter ——————————————————————————————————————————————————————
    public void setPrice (int price) {
        this.price = price;
    }
    //——————————————————————————————————————————————————  Methodes ————————————————————————————————————————————————————
    public void activeOrPassiveMember () throws IOException {
        System.out.println("Do you want a active or passive membership? ");
        inputLine = sc.nextLine();

        if (inputLine.equals("passive".toLowerCase())) {
            passiveMember();

        } else if (inputLine.equals("active".toLowerCase())) {
            Membersage();
            active();
        }
    }
    public int Membersage() {
        System.out.println("Enter your date of birth in the following format 'YYYY-MM-DD':");
        String birtInput = sc.nextLine();
        LocalDate birth = LocalDate.parse( birtInput);
        LocalDate presentDate = LocalDate.now();
        System.out.println(Period.between(birth, presentDate).getYears());
        age = Period.between(birth, presentDate).getYears();
        return age;
    }

    public void calculatingAge() {
        try {
            if (getAge()< 18 ) {
                setPrice(JUNIOR_PRICE);
                System.out.println("this member is a junior swimmer\nPrice for junior members: " + getJUNIOR_PRICE()+ " yeary");
            }
            else if (getAge() >= 18) {
                setPrice(SENIOR_PRICE);
                System.out.println(" this member is a senior swimmer\nPrice for senior members: " + getSENIOR_PRICE()+ " yeary" );
            }
            else if (getAge() >= 60 )  {
                setPrice(OVER_60_PRICE);
                System.out.println("This member is above 60 \nThe Price for older members: " + (getOVER_60_PRICE() + "(25% of the senior price) "));
            }

        } catch (Exception e) {
            System.err.println("Something went wrong");
        }
    }
    public void active() throws IOException {
        System.out.println("Choose 1 (competition swimmer) \nChoose 2 (exerciser)");
        System.out.print("Enter:");//Det kun relevant hvis du er en junior/senior hvis du er knkurrence svømmer
        //hvis du er motionist er prisen bare relevant for din alder....
        input = sc.nextInt();
        switch (input) {
            case 1 -> {
                if (getAge() > 18) {
                    Storage.createSenior();


                } else if (getAge() < 18) {
                    Storage.createJunior();
                }

                calculatingAge();
            }

            case 2 -> {
                System.out.println(" Please enter your name:");
                String name = sc.nextLine();
                System.out.println(" Please enter your surname:");
                String surename = sc.nextLine();
                calculatingAge();
                regularMember.add("  Name:  "+ name + "    Surename:  " + surename + "  Price:  " + getPrice());
                System.out.println("You are now registered as a exerciser");
            }
        }
    }
    public void receipt() throws InterruptedException {
        System.out.println("\n ----------------------------------------------");
        Thread.sleep(700);
        System.out.println("             REGISTRATION RECIPE              ");
        System.out.println(" ----------------------------------------------");
        System.out.println( " Established membership : " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")) );
        Thread.sleep(800);
        System.out.println("\n Served by: Union president");
        Thread.sleep(500);
        System.out.println("\n\n ----------------------------------------------\n\n");
    }
    public void passiveMember(){
        System.out.println(" Please enter your name:");
        String name = sc.nextLine();
        System.out.println(" Please enter your surname:");
        String surename = sc.nextLine();
        regularMember.add("   Name:  "+ name + "    Surename:  " + surename + "  Price:  " + getPASSIV_PRICE());
        System.out.println(regularMember);
    }
    public void saveRegularMember () throws FileNotFoundException {
        for (int i = 0; i < regularMember.size(); i++) {
            PrintStream printStream = new PrintStream(new FileOutputStream(nameOfFile, true));
            printStream.append(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")) + "  Payment:   " + " " + economy.getIsPayed() + regularMember.get(i)  + "\n");
            printStream.append("\n__________________________________________________________________________________________________________________________________\n");

        }
    }

    @Override
    public String toString() {
        return "Firsname:" + firstName + " Surname :" + surName;
    }

}
//Ejerskab; Munira & Ugbaad