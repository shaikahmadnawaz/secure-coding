import java.util.Scanner;

public class ShiftCipher {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter plaintext: ");
        String plaintext = scanner.nextLine();

        System.out.print("Enter shift value: ");
        int shift = scanner.nextInt();

        String ciphertext = encrypt(plaintext, shift);
        System.out.println("Ciphertext: " + ciphertext);

        String decryptedText = decrypt(ciphertext, shift);
        System.out.println("Decrypted text: " + decryptedText);

        scanner.close();
    }

    public static String encrypt(String plaintext, int shift) {
        StringBuilder ciphertext = new StringBuilder();
        for (char c : plaintext.toCharArray()) {
            if (Character.isUpperCase(c)) {
                ciphertext.append((char) ('A' + (c - 'A' + shift) % 26));
            } else if (Character.isLowerCase(c)) {
                ciphertext.append((char) ('a' + (c - 'a' + shift) % 26));
            } else {
                ciphertext.append(c);
            }
        }
        return ciphertext.toString();
    }

    public static String decrypt(String ciphertext, int shift) {
        StringBuilder decryptedText = new StringBuilder();
        for (char c : ciphertext.toCharArray()) {
            if (Character.isUpperCase(c)) {
                decryptedText.append((char) ('A' + (c - 'A' - shift + 26) % 26));
            } else if (Character.isLowerCase(c)) {
                decryptedText.append((char) ('a' + (c - 'a' - shift + 26) % 26));
            } else {
                decryptedText.append(c);
            }
        }
        return decryptedText.toString();
    }
}
