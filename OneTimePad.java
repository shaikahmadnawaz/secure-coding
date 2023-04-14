// Java program Implementing One Time Pad Algorithm

// Importing required classes
import java.io.*;

// Main class
public class OneTimePad {

    // Method 1
    // Returning encrypted text
    public static String stringEncryption(String text, String key) {

        // Initializing cipherText
        String cipherText = "";

        // Initialize cipher array of key length
        // which stores the sum of corresponding no.'s
        // of plainText and key.
        int cipher[] = new int[key.length()];

        for (int i = 0; i < key.length(); i++) {
            cipher[i] = text.charAt(i) - 'A' + key.charAt(i) - 'A';
        }

        // If the sum is greater than 25
        // subtract 26 from it
        // and store that resulting value
        for (int i = 0; i < key.length(); i++) {
            if (cipher[i] > 25) {
                cipher[i] = cipher[i] - 26;
            }
        }

        // Converting the no.'s into integers

        // Convert these integers to corresponding
        // characters and add them up to cipherText
        for (int i = 0; i < key.length(); i++) {
            int x = cipher[i] + 'A';
            cipherText += (char) x;
        }

        // Returning the cipherText
        return cipherText;
    }

    // Method 2
    // Returning plain text
    public static String stringDecryption(String s, String key) {
        // Initializing plain text
        String plainText = "";

        // Initializing integer array of key length
        // which stores difference
        // of corresponding no.'s of
        // each character of cipherText and key
        int plain[] = new int[key.length()];

        // Running for loop for each character
        // subtracting and storing in the array
        for (int i = 0; i < key.length(); i++) {
            plain[i] = s.charAt(i) - 'A'
                    - (key.charAt(i) - 'A');
        }

        // If the difference is less than 0
        // add 26 and store it in the array.
        for (int i = 0; i < key.length(); i++) {
            if (plain[i] < 0) {
                plain[i] = plain[i] + 26;
            }
        }

        // Converting int to corresponding char
        // add them up to plainText
        for (int i = 0; i < key.length(); i++) {
            int x = plain[i] + 'A';
            plainText += (char) x;
        }

        // Returning plainText
        return plainText;
    }

    // Method 3
    // Main driver method
    public static void main(String[] args) {
        // Declaring plain text
        String plainText = "Hello";

        // Declaring key
        String key = "MONEY";

        // Converting plain text to toUpperCase
        // function call to stringEncryption
        // with plainText and key as parameters
        String encryptedText = stringEncryption(plainText.toUpperCase(), key.toUpperCase());

        // Printing cipher Text
        System.out.println("Cipher Text - "
                + encryptedText);

        // Calling above method to stringDecryption
        // with encryptedText and key as parameters
        System.out.println("Message - " + stringDecryption(encryptedText, key.toUpperCase()));
    }
}
