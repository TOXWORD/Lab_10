import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.StringIndexOutOfBoundsException;
public class Main {

    public static void main(String[] args) {
        URLChecker u = new URLChecker();
        try {
            u.checkHTML();
            u.checkFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
