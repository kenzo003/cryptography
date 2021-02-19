import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Trismus {
    public static boolean flag = false;
    static final int n = 10;
    static final int m = 3;
    HashMap<String, Double> WLet = new HashMap();
    String keyMB = "";
    Double wKey = 99999999D;

    public String encrypt(String text, String key) {

        StringBuffer encrytext = new StringBuffer();
        char plate[][] = new char[n][m];
        //int a1 = 0, a2 = 0, b1 = 0, b2 = 0;
        //String entext = "";
        HashMap<Character, String[]> plainMap = new HashMap();
        HashMap<String, Character> plainMapReverse = new HashMap();

        //key
        String platekey = "";
        key += "abcdefghijklmnopqrstuvwxyz .,-";

//        Убираем повторяющиеся буквы
        for (int i = 0; i < key.length(); i++) {
            if (!platekey.contains(String.valueOf(key.charAt(i)))) {
                platekey += String.valueOf(key.charAt(i));
            }
        }

        System.out.println(platekey);

//        Выводим таблицу
        for (int i = 0, k = 0; i < plate.length; i++) {
            for (int j = 0; j < plate[i].length; j++) {
                plate[i][j] = platekey.charAt(k);
                if (k < platekey.length()){
                    System.out.print(platekey.charAt(k) + "\t");
                    String []item = {Integer.toString(i), Integer.toString(j)};
                    plainMap.put(platekey.charAt(k), item );
                    plainMapReverse.put(item[0]+item[1], platekey.charAt(k));
                }
                k++;
            }
            System.out.println("\n");
        }

        for (int i = 0; i < text.length(); i++){
//            encrytext.append(plainMapReverse.get(plainMap.get(text.charAt(i))));
            String []it = plainMap.get(text.charAt(i));
            String []it2 = {"",""};
            int index = (Integer.parseInt(it[0])+1) % plate.length;
            it2[0] = Integer.toString(index);
            it2[1] = it[1];
            encrytext.append(plainMapReverse.get(it2[0]+it2[1]));

        }

        return encrytext.toString();
    }

    public String decrypt(String key, String text) {
        StringBuffer encrytext = new StringBuffer();
        char plate[][] = new char[n][m];
        int a1 = 0, a2 = 0, b1 = 0, b2 = 0;
        String entext = "";
        HashMap<Character, String[]> plainMap = new HashMap();
        HashMap<String, Character> plainMapReverse = new HashMap();

        //key
        String platekey = "";
        key += "abcdefghijklmnopqrstuvwxyz .,-";

//        Убираем повторяющиеся буквы
        for (int i = 0; i < key.length(); i++) {
            if (!platekey.contains(String.valueOf(key.charAt(i)))) {
                platekey += String.valueOf(key.charAt(i));
            }
        }

        System.out.println(platekey);

//        Выводим таблицу
        for (int i = 0, k = 0; i < plate.length; i++) {
            for (int j = 0; j < plate[i].length; j++) {
                plate[i][j] = platekey.charAt(k);
                if (k < platekey.length()){
                    System.out.print(platekey.charAt(k) + "\t");
                    String []item = {Integer.toString(i), Integer.toString(j)};
                    plainMap.put(platekey.charAt(k), item );
                    plainMapReverse.put(item[0]+item[1], platekey.charAt(k));
                }
                k++;
            }
            System.out.println("\n");
        }

        for (int i = 0; i < text.length(); i++){
            String []it = plainMap.get(text.charAt(i));
            String []it2 = {"",""};
            //int index = (Integer.parseInt(it[0])-1) % plate.length;
            int index = ((Integer.parseInt(it[0])-1) >= 0) ? (Integer.parseInt(it[0])-1) % plate.length : plate.length-1;
            it2[0] = Integer.toString(index);
            it2[1] = it[1];
            encrytext.append(plainMapReverse.get(it2[0]+it2[1]));

        }

        return encrytext.toString();
    }

    public String decrypt2(String key, String text) {
        String keyold = key;
        StringBuffer encrytext = new StringBuffer();
        char plate[][] = new char[n][m];
        int a1 = 0, a2 = 0, b1 = 0, b2 = 0;
        String entext = "";
        HashMap<Character, String[]> plainMap = new HashMap();
        HashMap<String, Character> plainMapReverse = new HashMap();
        HashMap<String, Double> probTeorLet = new HashMap();

        probTeorLet.put("a", 0.081);
        probTeorLet.put("b", 0.016);
        probTeorLet.put("c", 0.032);
        probTeorLet.put("d", 0.036);
        probTeorLet.put("e", 0.123);
        probTeorLet.put("f", 0.023);
        probTeorLet.put("g", 0.016);
        probTeorLet.put("h", 0.051);
        probTeorLet.put("i", 0.071);
        probTeorLet.put("j", 0.001);
        probTeorLet.put("k", 0.005);
        probTeorLet.put("l", 0.040);
        probTeorLet.put("m", 0.022);
        probTeorLet.put("n", 0.072);
        probTeorLet.put("o", 0.079);
        probTeorLet.put("p", 0.023);
        probTeorLet.put("r", 0.060);
        probTeorLet.put("q", 0.002);
        probTeorLet.put("s", 0.066);
        probTeorLet.put("t", 0.096);
        probTeorLet.put("u", 0.031);
        probTeorLet.put("v", 0.009);
        probTeorLet.put("w", 0.020);
        probTeorLet.put("x", 0.002);
        probTeorLet.put("y", 0.019);
        probTeorLet.put("z", 0.001);


        //key
        String platekey = "";
        key += "abcdefghijklmnopqrstuvwxyz .,-";

//        Убираем повторяющиеся буквы
        for (int i = 0; i < key.length(); i++) {
            if (!platekey.contains(String.valueOf(key.charAt(i)))) {
                platekey += String.valueOf(key.charAt(i));
            }
        }

        String toString = "";

//        Выводим таблицу
        for (int i = 0, k = 0; i < plate.length; i++) {
            for (int j = 0; j < plate[i].length; j++) {
                plate[i][j] = platekey.charAt(k);
                if (k < platekey.length()){
                    if(i == 1)
                    toString += platekey.charAt(k) + "\t";
                    //System.out.print(platekey.charAt(k) + "\t");
                    String []item = {Integer.toString(i), Integer.toString(j)};
                    plainMap.put(platekey.charAt(k), item );
                    plainMapReverse.put(item[0]+item[1], platekey.charAt(k));
                }
                k++;
            }
           // System.out.println("\n");
        }

        for (int i = 0; i < text.length(); i++){
            String []it = plainMap.get(text.charAt(i));
            String []it2 = {"",""};
            //int index = (Integer.parseInt(it[0])-1) % plate.length;
            int index = ((Integer.parseInt(it[0])-1) >= 0) ? (Integer.parseInt(it[0])-1) % plate.length : plate.length-1;
            it2[0] = Integer.toString(index);
            it2[1] = it[1];
            encrytext.append(plainMapReverse.get(it2[0]+it2[1]));
        }

        ArrayList<Character> alphabet = new ArrayList<Character>(Arrays.asList(
                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'r', 'q', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', ' ', ',', '.', '-'));
         //количество букв
        HashMap<String, Double> probLet = new HashMap(); //вероятности букв
        double w = 0;

        int count = 0;
//// не теоретические вероятности
//        //Begin
//        int count1 = 0;
//
//        StringBuffer srcText = new StringBuffer();
//        srcText.append(fileReader("src4.txt"));
//        for (int i = 0; i < probTeorLet.size(); i++){
//            for (int j = 0; j < srcText.length(); j++){
//                if(alphabet.get(i) == srcText.charAt(j)){
//                    count1++;
//                }
//            }
//            probTeorLet.put(alphabet.get(i).toString(), (double)count1/(double)alphabet.size());
//            count1 = 0;
//        }
////End
        for (int i = 0; i < probTeorLet.size(); i++){
            for (int j = 0; j < encrytext.length(); j++){
                if(alphabet.get(i) == encrytext.charAt(j)){
                    count++;
                }
            }

            probLet.put(alphabet.get(i).toString(), (double)count/(double)encrytext.length());
            w += Math.pow(probLet.get(alphabet.get(i).toString()) - probTeorLet.get(alphabet.get(i).toString()), 2);
            count = 0;
        }

        WLet.put(keyold, w);

        if (wKey > WLet.get(keyold)){
            wKey = WLet.get(keyold);
            keyMB = keyold;
            keyMB = keyold;
        }


        return toString + WLet.get(keyold);
    }

    public String[] cryptanalysis(String text, int size) {
        int lengthKey = size;
        String key = "";

        PermutationsWithRepetition gen = new PermutationsWithRepetition(
                new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "r", "q", "s", "t", "u", "v", "w", "x", "y", "z", " ", ",", ".", "-"},
                lengthKey);

        Object[][] variations = gen.getVariations();

        StringBuffer res = new StringBuffer();


        for (Object[] s : variations) {
            for (int j = 0; j < lengthKey; j++){
                key+= s[j];
            }

            res.append( key + "\t\t" + decrypt2(key, text) + "\n");
            System.out.println(key + "\t\t" + decrypt2(key, text));
            key = "";

        }

        String result[] = new String[]{keyMB, res.toString()};

        return result;
    }

    private static String fileReader(String fileName) {

        StringBuffer result = new StringBuffer();

        try (FileReader reader = new FileReader(fileName);
             BufferedReader br = new BufferedReader(reader)) {
            String line;
            while ((line = br.readLine()) != null) {
                result.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result.toString();
    }

}
