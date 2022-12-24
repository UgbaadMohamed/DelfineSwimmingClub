import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
public class ChangeMembership {
    //—————————————————————————————————————————————————— Variables —————————————————————————————————————————————————————
    private String InputChangeMembership;
    private int inputDeleted;

    //—————————————————————————————————————————————————— instance & scanner ————————————————————————————————————————————
    Scanner sc = new Scanner(System.in);

    Membership membership;
    {
        try {
            membership = new Membership();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    //——————————————————————————————————————————————————   Methods ————————————————————————————————————————————————————

    public void changeMembership() throws IOException {
        deleteMembership();
        System.out.println("You want to change your membership");
        System.out.println("write active to be change or passive to change");
        InputChangeMembership = sc.nextLine();
        if (InputChangeMembership.equals("active".toLowerCase())) {
            System.out.println("Your membership is change to a passive membership");
            membership.passiveMember();
            if (membership.getRegularMember().equals("active")) ;
            System.out.println("Your membership is change to an active membership");
            membership.active();

        } else if (InputChangeMembership.equals("passive".toLowerCase())) {
            System.out.println("Your membership is change to a active membership");
            membership.getInputLine().equals("active member");
        }
    }

    public void deleteMembership() {
        try {
            System.out.println("Is it a senior or a junior competitor or just a regular member?");
            String team = sc.nextLine();
            if (team.equalsIgnoreCase("senior")) {
                for (Senior s : Storage.seniorList) {
                    System.out.println("Which member do you wish to delete");
                    Storage.seniorList.remove(inputDeleted);
                }
            } else if (team.equalsIgnoreCase("junior")) {
                for (Junior j : Storage.juniorList) {
                    System.out.println("Which member do you wish to delete");
                    Storage.juniorList.remove(inputDeleted);
                }
            } else if (team.equalsIgnoreCase("regular")) {
                System.out.println(membership.getRegularMember());
                System.out.println("Which member do you wish to delete");
                inputDeleted = sc.nextInt();
                membership.getRegularMember().remove(inputDeleted);
            } else {
                System.out.println(inputDeleted + " is not a member from"
                        + LocalDateTime.now().format(DateTimeFormatter.ofPattern("YYYY-MM-DD HH:mm:ss" + " ")));
            }
            System.out.println("The member is now remove from the club");
        } catch (Exception e) {
            System.out.println("Something went wrong while deleting a member");
        }
    }
}

//Ejerskab; Munira, wei & Ugbaad