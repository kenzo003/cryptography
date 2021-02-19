import java.io.*;
import java.nio.charset.Charset;

public class File {
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
