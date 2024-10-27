package caesar;

public class CaesarCipher {
    String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public String encrypt(String a, int key) {
        System.out.println(a);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);
            int index = ALPHABET.indexOf(c);
            if (index == -1) {
                sb.append(c);
                continue;
            }
            index = index + key;
            if (index > ALPHABET.length()) {
                index = index - ALPHABET.length();
            }
            char encrypt = ALPHABET.charAt(index);
            sb.append(encrypt);
        }
        return sb.toString();
    }
    public String decrypt(String a, int key) {
        System.out.println(a);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);
            int index = ALPHABET.indexOf(c);
            if (index == -1) {
                sb.append(c);
                continue;
            }
            index = index - key;
            if (index < 0) {
                index = index + ALPHABET.length();
            }
            char decrypt = ALPHABET.charAt(index);
            sb.append(decrypt);
        }
        return sb.toString();
    }

}
