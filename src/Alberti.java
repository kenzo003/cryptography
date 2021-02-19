import java.time.LocalDateTime;
import java.util.Arrays;

public class Alberti {
    private final String seed;
    private static final int[][] arrAlph() {
        int N = 255;
        int M = 255;
        int alphabet[][] = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0, k = i, l = 0; j < M; j++, k++) {
                if (j < M - i) {
                    alphabet[i][j] = k;
                } else {
                    alphabet[i][j] = l++;
                }
            }
        }
        return alphabet;
    }

    public String getSeed(){
        return this.seed;
    }
    public Alberti() {
        this.seed = LocalDateTime.now().toString().replaceAll("[^0-9]*", "");
    }

    public Alberti(String seed) {
        this.seed = seed;
    }

    public String next() {
        String key = this.seed;
        key = key.repeat(255 / key.length() + 1).substring(0, 255);
        int result[] = new int[255];
        int alphabet[][] = arrAlph();
        for (int i = 0; i < 255; i++) {
            String s = String.valueOf(key.charAt(i));
            result[i] = alphabet[i][Integer.parseInt(s)];
        }
        return Arrays.toString(result).replaceAll("[^0-9]*", "");
    }



//    public int[] encrypt(String key) {
//        int result[] = new int[key.length()];
//
//        int alphabet[][] = arrAlph();
//
//        for (int i = 0; i < key.length(); i++){
//            Character s = key.charAt(i);
//            result[i] = alphabet[(int)s][(int)s];
//        }
//
//            return result;
//    }

//    public int[] encrypt2(String key) {
//        key = key.repeat(255/key.length()+1);
//        int result[] = new int[255];
//        int alphabet[][] = arrAlph();
//
//        for (int i = 0; i < 255; i++){
//            Character s = key.charAt(i);
//            result[i] = alphabet[i][(int)s];
//        }
//        return result;
//    }
}
