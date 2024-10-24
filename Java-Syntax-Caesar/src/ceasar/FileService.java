package ceasar;

import java.io.BufferedReader;
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

    public static void main(String[] args) {
       String s = new FileService().read("Example.txt");
        System.out.println(s);
    }
}
