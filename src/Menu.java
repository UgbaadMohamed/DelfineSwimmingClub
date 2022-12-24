import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Menu {
    Scanner sc = new Scanner(System.in);
    private int input;
    private boolean keeplaying = true;

    public Menu() throws IOException {
    }

    public void menuheader () {
        System.out.printf("  ———————————————————————————————————————————————————————————————————————————————————————————————————————————————%n");
        System.out.println("        \uD83D\uDC2C  I N T E R N A T I O N A L    D E L F I N E    S W I M M M I N G C L U B \uD83D\uDC2C  " );
        System.out.println("  ———————————————————————————————————————————————————————————————————————————————————————————————————————————————");

        System.out.println();
        System.out.printf("  %-25s   %-30s    %5s %n","M E M B E R S H I P","              C O M P A T I T I O N", "              E C O N O M Y");

        System.out.printf("  %-38s  %-37s %-50s ","New member","  Junior teams",  "   Payment");
        System.out.println();
        System.out.printf("   %-38s  %-37s %-50s ","\n  Deleted memebrship","     Senior team","      Debt overview");
        System.out.println();
        System.out.printf("   %-25s","\n  Change mebership");
        System.out.println();
        System.out.println("\n - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
        System.out.println( "  I N F O R M A T I O N ");
        System.out.println(" - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
        System.out.println("\n  Choose 1 (Membership)");
        System.out.println("  Choose 2 (Compatition)");
        System.out.println("  Choose 3 (Economy)");
        System.out.print("\n  Enter:");

    }

    SubMenuMembership menuMembership = new SubMenuMembership();
    SubMenuCompetition menuCompetition = new SubMenuCompetition();
    SubMenuEconomy menuEconomy = new SubMenuEconomy();
    Login login = new Login();

    public void readerchoiceoce(){
        try{
            while (keeplaying) {
                menuheader();
                input = sc.nextInt();
                switch (input) {
                    case 1:
                        menuMembership.membershipReaderChoice();
                        break;

                    case 2:
                        login.enterSystem();
                        menuCompetition.competitionReaderChoice();
                        break;

                    case 3:
                        menuEconomy.Economyreaderchoic();

                        break;

                    default:
                        System.out.println("You typed something the system could not understand!");
                }
            }

        } catch (InputMismatchException e) {
            System.out.println("Waring you wrote something our system dose not contain ");
        }
    }
}
//Ejerskab; isaac og ugbaad