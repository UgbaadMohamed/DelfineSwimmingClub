import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.time.Period;
import java.util.ArrayList;
import java.util.SortedMap;


public class Main {
    void run () throws IOException {
       Menu menu = new Menu();
       menu.readerchoiceoce();
    }
    public static void main(String[] args) throws IOException {
        new Main().run();
    }


}
