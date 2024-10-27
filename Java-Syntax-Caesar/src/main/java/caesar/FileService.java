package caesar;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;

public class FileService {
    String read(String path) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            return sb.toString();
        } catch (Exception e) {
            return null;
        }
    }

    void write(String s, String filename) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filename);
            fileOutputStream.write(s.getBytes());
            fileOutputStream.close();
        } catch (Exception e) {
            System.out.println("Як могла так і лажала при написанні цього Чуда!");
        }
    }
}
