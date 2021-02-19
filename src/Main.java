import java.io.*;
import java.nio.charset.Charset;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws UnsupportedEncodingException, FileNotFoundException {

        Validator validator = new Validator();
        String srcText = new String();
        String key = new String();
        String result = new String();
        boolean run = true;
        Scanner scanner = new Scanner(System.in);
        int res = 0;

        while (run) {
            System.out.println("\n1. Биграммный шифр Плейфейра");
            System.out.println("2. Шифр «скитала»");
            System.out.println("3. Шифр Вернама");
            System.out.println("4. Шифр Трисемуса");
            System.out.println("5. Гаммирование");
            System.out.print("Выберите метод шифрования: ");
            res = scanner.nextInt();

            switch (res) {
                case 1:

                    srcText = fileReader("src1.txt");
                    if (!validator.isValid(srcText)) {
                        System.out.println("Исходные данные не соответствуют алфавиту");
                        run = false;
                        break;
                    }
                    key = fileReader("key1.txt");

                    int cases_1 = 0;
                    System.out.println("1. Зашифровать");
                    System.out.println("2. Дешифровать");
                    System.out.print("Ваш выбор: ");
                    cases_1 = scanner.nextInt();

                    Playfaier playfaier = new Playfaier();

                    switch (cases_1) {
                        case 1:
                            System.out.print("\nКлюч: " + key);
                            System.out.print("\nИсходные данные: " + srcText + "\n");
                            result = playfaier.encrypt(srcText, key);
                            fileWriter("res1.txt", result);
                            System.out.println("Резульат: " + result);

                            break;
                        case 2:
                            System.out.print("\nКлюч: " + key);
                            System.out.print("\nИсходные данные: " + result + "\n");
                            System.out.println("Резульат: " + playfaier.decrypt(key, result));
                            break;
                    }
                    break;

                case 4:

                    srcText = fileReader("src4.txt");
                    if (!validator.isValid3(srcText)) {
                        System.out.println("Исходные данные не соответствуют алфавиту");
                        run = false;
                        break;
                    }
                    key = fileReader("key4.txt");

                    int cases_4 = 0;
                    System.out.println("1. Зашифровать");
                    System.out.println("2. Дешифровать");
                    System.out.println("3. Криптоанализ");
                    System.out.print("Ваш выбор: ");
                    cases_4 = scanner.nextInt();

                    Trismus trismus = new Trismus();

                    switch (cases_4) {
                        case 1:
                            System.out.print("\nКлюч: " + key);
                            System.out.print("\nИсходные данные: " + srcText + "\n");
                            result = trismus.encrypt(srcText, key);
                            fileWriter("res4.txt", result);
                            System.out.println("Резульат: " + result);

                            break;
                        case 2:
                            System.out.print("\nКлюч: " + key);
                            System.out.print("\nИсходные данные: " + result + "\n");
                            System.out.println("Резульат: " + trismus.decrypt(key, result));
                            break;
                        case 3:
                            String analysis[] = trismus.cryptanalysis(result, key.length());
                            fileWriter("proc4.txt", analysis[1]);
                            System.out.print("\nКлюч: " + analysis[0]);
                            System.out.print("\nИсходные данные: " + result + "\n");
                            System.out.println("Резульат: " + trismus.decrypt(analysis[0], result));
                            break;
                    }
                    break;


                case 5:
                    srcText = fileReader("src5.txt");

                    if (!validator.isValid5(srcText)) {
                        System.out.println("Исходные данные не соответствуют алфавиту");
                        run = false;
                        break;
                    }

                    //key = fileReader("key5.txt");

                    int cases_5 = 0;
                    System.out.println("1. Зашифровать");
                    System.out.println("2. Дешифровать");
                    System.out.print("Ваш выбор: ");
                    cases_5 = scanner.nextInt();

                    Gamming gamming = new Gamming();

                    switch (cases_5) {

                        case 1:
                            System.out.print("\nИсходные данные: " + srcText + "\n");
                            //System.out.print("Исходные данные (бинарные): " + gamming.stringToBinary(srcText) + "\n");
                            result = gamming.encrypt2(srcText);
                            fileWriter("res5.txt", result);
                            System.out.println("Резульат: " + result);

                            break;
                        case 2:
                            //Scanner scanner1 = new Scanner(System.in);
                            String seed = fileReader("seed5.txt");
                            //String gamma = scanner1.nextLine();
                            String text = fileReader("res5.txt");
                            //System.out.print("\nКлюч: " + key);
                            System.out.print("\nИсходные данные: " + fileReader("res5.txt") + "\n");
                            System.out.println("Резульат: " + gamming.decrypt2(result, seed));
                            break;
                    }
                    break;


                case 2:
                    srcText = fileReader("src2.txt");
                    if (!validator.isValid(srcText)) {
                        System.out.println("Исходные данные не соответствуют алфавиту");
                        run = false;
                        break;
                    }
                    key = fileReader("key2.txt");
                    int key1 = Integer.parseInt(key);


                    int cases_2 = 0;
                    System.out.println("1. Зашифровать");
                    System.out.println("2. Дешифровать");
                    System.out.print("Ваш выбор: ");
                    cases_2 = scanner.nextInt();

                    Skitala skitala = new Skitala();

                    switch (cases_2) {
                        case 1:

                            int keyOption = 1;
                            System.out.println("\n1. Считать ключ из файла");
                            System.out.println("2. Ввести вручную");
                            System.out.print("Ваш выбор: ");
                            keyOption = scanner.nextInt();

                            if (keyOption == 2) {
                                System.out.println("Введите значение ключа: ");
                                key1 = scanner.nextInt();
                            }

                            System.out.print("\nКлюч: " + key1);
                            System.out.print("\nИсходные данные: " + srcText + "\n");
                            result = skitala.encrypt(srcText, key1);
                            fileWriter("res2.txt", result);
                            System.out.println("Резульат: " + result);

                            break;
                        case 2:
                            int keyOption2 = 1;
                            System.out.println("\n1. Считать ключ из файла");
                            System.out.println("2. Ввести вручную");
                            System.out.print("Ваш выбор: ");
                            keyOption2 = scanner.nextInt();

                            if (keyOption2 == 2) {
                                System.out.println("Введите значение ключа: ");
                                key1 = scanner.nextInt();
                            }

                            System.out.print("\nКлюч: " + key1);
                            System.out.print("\nИсходные данные: " + result + "\n");
                            System.out.println("Резульат: " + skitala.decrypt(result, key1));
                            break;
                    }

                    break;

                case 3:
                    srcText = fileReader("src3.txt");
                    if (!validator.isValid2(srcText)) {
                        System.out.println("Исходные данные не соответствуют алфавиту");
                        run = false;
                        break;
                    }
                    key = fileReader("key3.txt");

                    int cases_3 = 0;
                    System.out.println("1. Зашифровать");
                    System.out.println("2. Дешифровать");
                    System.out.print("Ваш выбор: ");
                    cases_3 = scanner.nextInt();

                    Vernam vernam = new Vernam();

                    switch (cases_3) {
                        case 1:

                            int keyOption = 1;
                            System.out.println("\n1. Считать ключ из файла");
                            System.out.println("2. Ввести вручную");
                            System.out.print("Ваш выбор: ");
                            keyOption = scanner.nextInt();

                            if (keyOption == 2) {
                                System.out.println("Введите значение ключа: ");
                                key = scanner.next();
                            }

                            System.out.print("\nКлюч: " + key);
                            System.out.print("\nИсходные данные: " + srcText + "\n");
                            result = vernam.encrypt(srcText, key);
                            fileWriter("res3.txt", result);
                            System.out.println("Резульат: " + result);

                            break;
                        case 2:
                            int keyOption2 = 1;
                            System.out.println("\n1. Считать ключ из файла");
                            System.out.println("2. Ввести вручную");
                            System.out.print("Ваш выбор: ");
                            keyOption2 = scanner.nextInt();

                            //key = vernam.generateKey(10);

                            if (keyOption2 == 2) {
                                System.out.println("Введите значение ключа: ");
                                key = scanner.next();
                            }

                            System.out.print("\nКлюч: " + key);
                            System.out.print("\nИсходные данные: " + result + "\n");
                            System.out.println("Резульат: " + vernam.decrypt(result, key));
                            break;
                    }

                default:
                    System.out.print("\n===============404=================");
                    break;
            }

        }
    }

    public static String fileReader(String fileName) {

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

    public static void fileWriter(String fileName, String result) {
        try (FileWriter writer = new FileWriter(fileName, Charset.forName("UTF-8"), true)) {
            new FileOutputStream(fileName, false).close();
            writer.write("");
            writer.write(result);
            writer.flush();
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }

    }
}
