package ceasar;

public class CaesarCipher {
    String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public String encrupt(String a, int key) {
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
            char encrupt = ALPHABET.charAt(index);
            sb.append(encrupt);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = new CaesarCipher().encrupt("Hello Z", 2);
        System.out.println(s);
    }
}
