package caesar;

public class Runner {
    public static void main(String[] args) {
       if (args.length!=3){
           System.out.println("Please  use 3 arguments: command path key");
           return;
       }
        System.out.println("Arguments");
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }
        String command = args[0];
        String filepath = args[1];
        int key;
        try {
             key = Integer.parseInt(args[2]);

        }catch (NumberFormatException a ) {
            System.out.println("Key must be a number");
            return;
        }
        FileService fs = new FileService();
        String filecontent = fs.read(filepath);
        if (filecontent==null){
            System.out.println("Cannot read file "+ filepath);
            return;
        }
        CaesarCipher cipher = new CaesarCipher();

        if ("ENCRYPT".equals(command)) {
            String s = cipher.encrypt(filecontent, key);
            String newFileName = addSuffixToFileName(filepath, "[ENCRYPTED]");
            fs.write(s, newFileName);
            System.out.println(s);
            System.out.println(newFileName + " was created.");
        } else if ("DECRYPT".equals(command)) {
            String s = cipher.decrypt(filecontent, key);
            String newFileName1 = addSuffixToFileName(filepath, "[DECRYPTED]");
            fs.write(s, newFileName1);
            System.out.println(s);
            System.out.println(newFileName1 + " was created.");
        } else {
            System.out.println("Command should be ENCRYPT or DECRYPT");
        }
    }

    public static String addSuffixToFileName(String filePath, String suffix) {
        int d = filePath.lastIndexOf(".");
        String s1 = filePath.substring(0, d);
        String s2 = filePath.substring(d);
        // System.out.println(s1);
        // System.out.println(s2);
        return s1 + suffix + s2;
    }
}