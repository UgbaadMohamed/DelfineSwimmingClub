
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Login {
    Scanner scanner = new Scanner(System.in);
    ArrayList<User> userList = new ArrayList<>();
    Random random = new Random();
    private String userName;
    private String password;
    private boolean keepRun = true;

    private int ipAddress;

    public Login() throws IOException {
    }

    public void test() {
        userList.add(new User("Fatima", "fatima123"));
        userList.add(new User("dave2000", "dave123"));
        userList.add(new User("max3000", "max123"));
    }

    public void enterSystem() {
        try {
            // SimpleDateFormat class that format the time
            SimpleDateFormat userLoginTime = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss:ms");
            Date time = new Date();
            // ipAddress with random class from numbers 0 to 255
            ipAddress = random.nextInt(255);
            // FileWriter class that create a new file "UserLogin.txt" and append that save the file
            FileWriter enterSystemFile = new FileWriter(new File("UserLogin.txt"), true);
            enterSystemFile.write("\nWelcome\n");
            test();
            // while loop and scanner so the user and type information to the system.
            // save everything the user type into the "UserLogin.txt" file and print out everything
            while (keepRun) {
                System.out.println(userLoginTime.format(time) + " Enter your username:");
                userName = scanner.nextLine();
                enterSystemFile.write(userLoginTime.format(time) + " " + userName + "\n");

                System.out.println(userLoginTime.format(time) + " Enter your password:");
                password = scanner.nextLine();

                User user = new User(userName, password);

                // boolean to check if the information is true to the ArrayList
                boolean success = checkUser(user);
                System.out.println(userLoginTime.format(time) + " success to the system = " + success + "\n");
                enterSystemFile.write(userLoginTime.format(time) + " success to the system = "
                        + success + "\n");
                enterSystemFile.write(userLoginTime.format(time)
                        + " user's ipAddress that try to log in to the system: "
                        + ipAddress + "." + ipAddress + "." + ipAddress + "." + ipAddress + "\n");
                enterSystemFile.close();
                break;
            }

        } catch (Exception e) {
            System.out.println("Error occurred.");
            e.printStackTrace();
        }
    }

    // for each loop to loop through the entire ArrayList
    public boolean checkUser(User loginUser) {
        boolean doesMatch = false;
        for (User existingUser : userList) {
            if (existingUser.equals(loginUser)) {
                return true;
            }
        }
        lockDown();
        enterSystem();
        return false;
    }

    public void lockDown() {
        int timeToWait = 0; // second
        System.out.println("Wait 5 seconds and try again...");
        try {
            for (int i = 5; i >= timeToWait; i--) {
                Thread.sleep(1000);
                System.out.print("\r" + i);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
//Ejerskab; Wei & isaac