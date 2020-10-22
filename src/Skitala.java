import java.util.Scanner;

public class Skitala implements Cryptography {

    @Override
    public String encrypt(String srcData, int key) {

        int k = srcData.length();
        int n = ((k - 1) / key) + 1;
        int index = 0;
        char[][] currentState = new char[key][n];
        StringBuffer result = new StringBuffer();
        Scanner scanner = new Scanner(System.in);
        String scanResult = new String();

        System.out.print("Показать промежуточный этап шифрования ? (Y/N): ");
        scanResult = scanner.next().toLowerCase();

        if (scanResult.equals("y"))
            System.out.println("Промежуточный этап шифровния\n");
        for (int i = 0; i < key; i++) {
            for (int j = 0; j < n; j++) {
                if (index < k) {
                    if (scanResult.equals("y"))
                        System.out.print(srcData.charAt(index) + "\t");
                    currentState[i][j] = srcData.charAt(index++);
                } else {
                    currentState[i][j] = ' ';
                }
            }
            if (scanResult.equals("y"))
                System.out.println();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < key; j++) {
                result.append(currentState[j][i]);
            }
        }

        return result.toString();
    }

    @Override
    public String decrypt(String resData, int key) {

        int k = resData.length();
        int n = ((k - 1) / key) + 1;
        int index = 0;
        char[][] currentState = new char[key][n];
        StringBuffer result = new StringBuffer();
        Scanner scanner = new Scanner(System.in);
        String scanResult = new String();

        System.out.print("Показать промежуточный этап дешифрования ? (Y/N): ");
        scanResult = scanner.next().toLowerCase();

        if (scanResult.equals("y"))
            System.out.println("Промежуточный этап дешифровния\n");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < key; j++) {
                if (index < k)
                    currentState[j][i] = resData.charAt(index++);
            }
        }

        index = 0;
        for (int i = 0; i < key; i++) {
            for (int j = 0; j < n; j++) {
                if (scanResult.equals("y"))
                    System.out.print(currentState[i][j] + "\t");
                if (index++ < k) {
                    result.append(currentState[i][j]);
                }
            }
            if (scanResult.equals("y"))
                System.out.println();
        }

        return result.toString();
    }
}
