import java.util.ArrayList;

public class Playfaier {

    public static boolean flag = false;

    public String encrypt(String text, String key) {

        //Подготовка открытого текста
        ArrayList<char[]> plaintext = new ArrayList<char[]>();
        ArrayList<char[]> encrytext = new ArrayList<char[]>();
        char plate[][] = new char[3][5];
        int a1 = 0, a2 = 0, b1 = 0, b2 = 0;
        String entext = "";


        for (int i = 0; i < text.length(); i += 2) {
            char[] temparr = new char[2];
            temparr[0] = text.charAt(i);
            try {
                if (text.charAt(i) == text.charAt(i + 1)) {
                    temparr[1] = ' ';
                    i--;
                } else {
                    temparr[1] = text.charAt(i + 1);
                }
            } catch (StringIndexOutOfBoundsException e) {
                temparr[1] = ' ';
                flag = true;
            }
            plaintext.add(temparr);
        }

        System.out.print("Биграммы: ");
        for (int i = 0; i < plaintext.size(); i++) {
            System.out.print(plaintext.get(i)[0] + "" + plaintext.get(i)[1] + " ");
        }
        System.out.println();

        //key
        String platekey = "";
        key += "01234456789 +-*/";

        for (int i = 0; i < key.length(); i++) {
            if (!platekey.contains(String.valueOf(key.charAt(i)))) {
                platekey += String.valueOf(key.charAt(i));
            }
        }

        System.out.println(platekey);

        for (int i = 0, k = 0; i < plate.length; i++) {
            for (int j = 0; j < plate[i].length; j++) {
                plate[i][j] = platekey.charAt(k);
                if (k < platekey.length())
                    System.out.print(platekey.charAt(k) + "\t");
                k++;
            }
            System.out.println("\n");
        }
        // кодировка информации

        for (int i = 0; i < plaintext.size(); i++) {

            char[] tmpArr = new char[2];
            for (int j = 0; j < plate.length; j++) {
                for (int k = 0; k < plate[j].length; k++) {
                    if (plate[j][k] == plaintext.get(i)[0]) {
                        a1 = j;
                        b1 = k;
                    }
                    if (plate[j][k] == plaintext.get(i)[1]) {
                        a2 = j;
                        b2 = k;
                    }
                }
            }

            if (a1 == a2) {
                tmpArr[0] = plate[a1][(b1 + 1) % plate[a1].length];
                tmpArr[1] = plate[a2][(b2 + 1) % plate[a1].length];
            } else if (b1 == b2) {
                tmpArr[0] = plate[(a1 + 1) % plate.length][b1];
                tmpArr[1] = plate[(a2 + 1) % plate.length][b2];
            } else {
                tmpArr[1] = plate[a2][b1];
                tmpArr[0] = plate[a1][b2];
            }

            encrytext.add(tmpArr);

        }

        for (int i = 0; i < encrytext.size(); i++) {
            entext += encrytext.get(i)[0] + "" + encrytext.get(i)[1] + " ";
        }

        System.out.println("Промежуточный результат: " + entext);

        StringBuffer dec = new StringBuffer();
        for (int i = 0; i < entext.length(); i++) {
            if (entext.charAt(i) != ' ') {
                dec.append(entext.charAt(i));
            }
        }
        return dec.toString();
    }


    public String decrypt(String key, String text) {
        //Подготовка открытого текста
        ArrayList<char[]> plaintext = new ArrayList<char[]>();
        ArrayList<char[]> encrytext = new ArrayList<char[]>();
        char plate[][] = new char[3][5];
        int a1 = 0, a2 = 0, b1 = 0, b2 = 0;
        String entext = "";


        for (int i = 0; i < text.length(); i += 2) {
            char[] temparr = new char[2];
            temparr[0] = text.charAt(i);
            try {
                if (text.charAt(i) == text.charAt(i + 1)) {
                    temparr[1] = ' ';
                    i--;
                } else {
                    temparr[1] = text.charAt(i + 1);
                }
            } catch (StringIndexOutOfBoundsException e) {
                temparr[1] = ' ';
                flag = true;
            }
            plaintext.add(temparr);
        }

        for (int i = 0; i < plaintext.size(); i++) {
            System.out.print(plaintext.get(i)[0] + "" + plaintext.get(i)[1] + " ");
        }
        System.out.println();

        //key
        String platekey = "";
        key += "01234456789 +-*/";

        for (int i = 0; i < key.length(); i++) {
            if (!platekey.contains(String.valueOf(key.charAt(i)))) {
                platekey += String.valueOf(key.charAt(i));
            }
        }

        System.out.println(platekey);

        for (int i = 0, k = 0; i < plate.length; i++) {
            for (int j = 0; j < plate[i].length; j++) {
                plate[i][j] = platekey.charAt(k);
                if (k < platekey.length())
                    System.out.print(platekey.charAt(k) + "\t");
                k++;
            }
            System.out.println("\n");
        }
        // кодировка информации

        for (int i = 0; i < plaintext.size(); i++) {

            char[] tmpArr = new char[2];
            for (int j = 0; j < plate.length; j++) {
                for (int k = 0; k < plate[j].length; k++) {
                    if (plate[j][k] == plaintext.get(i)[0]) {
                        a1 = j;
                        b1 = k;
                    }
                    if (plate[j][k] == plaintext.get(i)[1]) {
                        a2 = j;
                        b2 = k;
                    }
                }
            }

            if (a1 == a2) {
                b1 = (b1 == 0) ? plate[a1].length : b1;
                b2 = (b2 == 0) ? plate[a1].length : b2;

                tmpArr[0] = plate[a1][(b1 - 1) % plate[a1].length];
                tmpArr[1] = plate[a2][(b2 - 1) % plate[a2].length];
            } else if (b1 == b2) {
                a1 = (a1 == 0) ? plate.length : a1;
                a2 = (a2 == 0) ? plate.length : a2;
                tmpArr[0] = plate[(a1 - 1) % plate.length][b1];
                tmpArr[1] = plate[(a2 - 1) % plate.length][b2];
            } else {
                tmpArr[1] = plate[a2][b1];
                tmpArr[0] = plate[a1][b2];
            }

            encrytext.add(tmpArr);

        }

        for (int i = 0; i < encrytext.size(); i++) {
            entext += encrytext.get(i)[0] + "" + encrytext.get(i)[1] + " ";
        }

        System.out.println("Результат: " + entext);
        StringBuffer dec = new StringBuffer();
        for (int i = 0; i < entext.length(); i++) {
            if (entext.charAt(i) != ' ') {
                dec.append(entext.charAt(i));
            }
        }

        System.out.println(dec.toString());
        return entext;
    }
}
