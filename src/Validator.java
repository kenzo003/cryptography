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
    public static boolean isValid2(String src) {
        ArrayList<Character> alphabet = new ArrayList<Character>(Arrays.asList(
                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', ' '));
        for (int i = 0; i < src.length(); i++) {
            if (!alphabet.contains(src.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    public static boolean isValid3(String src) {
        ArrayList<Character> alphabet = new ArrayList<Character>(Arrays.asList(
                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'r', 'q', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', ' ', ',', '.', '-'));
        for (int i = 0; i < src.length(); i++) {
            if (!alphabet.contains(src.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    public static boolean isValid5(String src) {

        for (int i = 0; i < src.length(); i++) {
            if (!((int)src.charAt(i) >= 0 && (int)src.charAt(i) <= 255)) {
                return false;
            }
        }

        return true;
    }
}
