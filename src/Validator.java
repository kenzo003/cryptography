import java.util.ArrayList;
import java.util.Arrays;

public class Validator {

    public static boolean isValid(String src) {
        ArrayList<Character> alphabet = new ArrayList<Character>(Arrays.asList(
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', ' ', '+', '-', '*', '/'));
        for (int i = 0; i < src.length(); i++) {
            if (!alphabet.contains(src.charAt(i))) {
                return false;
            }
        }

        return true;
    }
}
