import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

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

        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(result);
            writer.flush();
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }

    }
}
