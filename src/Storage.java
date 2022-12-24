import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Storage {
   public static List<Senior> seniorList = new ArrayList<>();
    public static List<Junior> juniorList = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void createSenior() throws IOException {
        Membership ms = createMember();
        seniorList.add(new Senior(ms));
    }
    public static void createJunior() throws IOException {
        Membership ms = createMember();
        juniorList.add(new Junior(ms));
    }
    public static Membership createMember() throws IOException {
        System.out.println("What is your first name ?");
        String firstName = sc.nextLine();
        System.out.println("What is your surname ?");
        String surName = sc.nextLine();

        Membership ms = new Membership(firstName, surName);

        return ms;

   }


}
//Ejerskab; Munira & Ugbaad