import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Gamming {

    public String stringToBinary(String s) {
        return s
                .chars()
                .collect(StringBuilder::new,
                        (sb, c) -> sb.append(Integer.toBinaryString(c)).append(' '),
                        StringBuilder::append)
                .toString();
    }

//    public String encrypt(String plainText, String key) {
//        Alberti alberti = new Alberti(12);
//        int current[] = alberti.encrypt2(key);
//        String[] keyCurrent = new String[plainText.length()];
//
//        for (int i = 0; i < plainText.length(); i++) {
//            //current[i] = (alberti.encrypt2(key)[i % key.length()] + 1) % 128;
//            keyCurrent[i] = Integer.toBinaryString(current[i]);
//        }
//
//
//        if (plainText.length() != keyCurrent.length) {
//            return null;
//        }
//
//        String[] encryptedText = new String[plainText.length()];
//
//        String[] scrText = new String[plainText.length()];
//        for (int i = 0; i < plainText.length(); i++) {
//            scrText[i] = Integer.toBinaryString((int) plainText.charAt(i));
//        }
//
//        plainText = stringToBinary(plainText.toString());
//        //keyCurrent1 = stringToBinary(keyCurrent.toString());
//        for (int j = 0; j < scrText.length; j++) {
//            encryptedText[j] = "";
//            for (int i = 0; i < scrText[j].length(); i++) {
//                if (scrText[j].charAt(i) == keyCurrent[j].charAt(i)) {
//                    encryptedText[j] += "0";
//
//                } else {
//                    encryptedText[j] += "1";
//                }
//            }
//        }
//
//
//        StringBuffer keyCurrent1 = new StringBuffer();
//        StringBuffer encryptedText1 = new StringBuffer();
//        StringBuffer plainText1 = new StringBuffer();
//        for (String s : keyCurrent) {
//            fileWriter("gamma5.txt", s + " ");
//            keyCurrent1.append(s + " ");
//
//        }
//        for (String s : encryptedText) {
//            //fileWriter("gamma5.txt", s + " ");
//            fileWriter("crypt5.txt", s + " ");
//            encryptedText1.append(s + " ");
//
//        }
//        for (String s : scrText) {
//            //fileWriter("gamma5.txt", s + " ");
//            plainText1.append(s + " ");
//
//        }
//
//        StringBuffer resultg = new StringBuffer();
//        //String[] words = encryptedText.toString().split(" ");
//        //encryptedText.setLength(0);
//        Character symbol = 0;
//        for (int i = 0; i < keyCurrent.length; i++) {
//            symbol = (char) Integer.parseInt(keyCurrent[i], 2);
//            resultg.append(symbol.toString());
//        }
//        //fileWriter("gamma5.txt", keyCurrent1);
//        System.out.print("Исходные данные (бинарные): " + plainText1 + "\n");
//        System.out.println("Гамма-шифра:                " + keyCurrent1);
//        System.out.println("Результат:                  " + encryptedText1.toString());
//        System.out.println("Гамма-шифра (текстовой формат): " + resultg);
//
//
//        StringBuffer result = new StringBuffer();
//        //String[] words = encryptedText.toString().split(" ");
//        //encryptedText.setLength(0);
//        Character symbol2 = 0;
//        for (int i = 0; i < encryptedText.length; i++) {
//            symbol2 = (char) Integer.parseInt(encryptedText[i], 2);
//            result.append(symbol2.toString());
//        }
//        //int r = Integer.parseInt(words[0], 2);
//
//
//        return result.toString();
//    }

    public String encrypt2(String plainText) {
        //генерация пвсевдослучайной последовательности
        Alberti alberti = new Alberti();

        String sequence = alberti.next();
//        String sequence = alberti.next().substring(0,plainText.length());
//        if (sequence.length() < plainText.length())
//            sequence = sequence.repeat(plainText.length() / sequence.length() + 1).substring(0,plainText.length());

        //Конвертация открытого текста в двоичное представление 8 бит на символ
        String[] opentText = new String[plainText.length()];
        for (int i = 0; i < plainText.length(); i++) {
            String item = "00000000" + Integer.toBinaryString((int) plainText.charAt(i));
            opentText[i] = item.substring(item.length() - 8, item.length());
        }

//        //Построение гамма шифра
//        String[] gammaChiper = new String[plainText.length()];
//        StringBuilder gamma = new StringBuilder();
//        for (int i = 0; i < plainText.length(); i++) {
//            String item = "00000000" + Integer.toBinaryString((int) sequence.charAt(i));
//            gammaChiper[i] = item.substring(item.length() - 8, item.length());
//        }

        //Построение гамма шифра
        String[] gammaChiper = new String[plainText.length()];
        StringBuilder gamma = new StringBuilder();
        //Представляем в двоичной последовтельности гамма шифру
        for (int i = 0; i < sequence.length(); i++) {
            gamma.append(Integer.toBinaryString(Integer.parseInt(String.valueOf(sequence.charAt(i)))));
        }
        //Обрезаем лишнее
        gamma.setLength(plainText.length() * 8);
        //Разбиваем на блоки
        for (int i = 0; i < plainText.length(); i++) {
            gammaChiper[i] = gamma.substring(i * 8, i * 8 + 8);
        }

        //Получаем результат сложения xor
        String[] itemResult = new String[opentText.length];
        Arrays.fill(itemResult, "");
        //Сложение
        for (int i = 0; i < opentText.length; i++) {
            for (int j = 0; j < opentText[i].length(); j++) {
                if (opentText[i].charAt(j) == gammaChiper[i].charAt(j))
                    itemResult[i] += ("0");
                else
                    itemResult[i] += ("1");
            }
        }

        //Перевод из двоичной записи в обычную
        String[] result = new String[itemResult.length];
        StringBuilder resultOne = new StringBuilder();
        for (int i = 0; i < itemResult.length; i++) {
            result[i] = String.valueOf((char) Integer.parseInt(itemResult[i], 2));
            resultOne.append((char) Integer.parseInt(itemResult[i], 2));
        }

        File.fileWriter("gamma5.txt", Arrays.toString(itemResult));
        File.fileWriter("seed5.txt", alberti.getSeed());
        System.out.println(Arrays.toString(opentText));
        System.out.println(Arrays.toString(gammaChiper));
        System.out.println(Arrays.toString(itemResult));
        System.out.println(Arrays.toString(result));
        //System.out.println(resultOne);

        return resultOne.toString();
    }

    public String decrypt(String plainText, String gamma) {
        String[] wordText = plainText.split(" ");
        String[] gammaText = gamma.split(" ");
        String[] result = new String[wordText.length];

        for (int j = 0; j < wordText.length; j++) {
            result[j] = "";
            for (int i = 0; i < wordText[j].length(); i++) {
                if (wordText[j].charAt(i) == gammaText[j].charAt(i)) {
                    result[j] += "0";

                } else {
                    result[j] += "1";
                }
            }
        }

        StringBuffer result2 = new StringBuffer();
        //String[] words = encryptedText.toString().split(" ");
        //encryptedText.setLength(0);
        Character symbol = 0;
        for (int i = 0; i < result.length; i++) {
            symbol = (char) Integer.parseInt(result[i], 2);
            result2.append(symbol.toString());
        }

        return result2.toString();
    }

    public String decrypt2(String plainText, String gammas) {
        //генерация пвсевдослучайной последовательности
        Alberti alberti = new Alberti(gammas);
        String sequence = alberti.next();


        //Конвертация открытого текста в двоичное представление 8 бит на символ
        String[] opentText = new String[plainText.length()];
        for (int i = 0; i < plainText.length(); i++) {
            String item = "00000000" + Integer.toBinaryString((int) plainText.charAt(i));
            opentText[i] = item.substring(item.length() - 8, item.length());
        }


        //Построение гамма шифра
        String[] gammaChiper = new String[plainText.length()];
        StringBuilder gamma = new StringBuilder();
        //Представляем в двоичной последовтельности гамма шифру
        for (int i = 0; i < sequence.length(); i++) {
            gamma.append(Integer.toBinaryString(Integer.parseInt(String.valueOf(sequence.charAt(i)))));
        }
        //Обрезаем лишнее
        gamma.setLength(plainText.length() * 8);
        //Разбиваем на блоки
        for (int i = 0; i < plainText.length(); i++) {
            gammaChiper[i] = gamma.substring(i * 8, i * 8 + 8);
        }

        //Получаем результат сложения xor
        String[] itemResult = new String[opentText.length];
        Arrays.fill(itemResult, "");
        //Сложение
        for (int i = 0; i < opentText.length; i++) {
            for (int j = 0; j < opentText[i].length(); j++) {
                if (opentText[i].charAt(j) == gammaChiper[i].charAt(j))
                    itemResult[i] += ("0");
                else
                    itemResult[i] += ("1");
            }
        }

        //Перевод из двоичной записи в обычную
        String[] result = new String[itemResult.length];
        StringBuilder resultOne = new StringBuilder();
        for (int i = 0; i < itemResult.length; i++) {
            result[i] = String.valueOf((char) Integer.parseInt(itemResult[i], 2));
            resultOne.append((char) Integer.parseInt(itemResult[i], 2));
        }

        System.out.println(Arrays.toString(opentText));
        System.out.println(Arrays.toString(gammaChiper));
        System.out.println(Arrays.toString(itemResult));
        System.out.println(Arrays.toString(result));
        //System.out.println(resultOne);
        return resultOne.toString();
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

    private static void fileWriter(String fileName, String result) {

        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(result);
            writer.flush();
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }

    }
}
