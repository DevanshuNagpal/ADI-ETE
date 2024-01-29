import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PatternMatching {

    static boolean patternMatching(String pattern, String s) {
        String[] words = s.split(" ");

        if (pattern.length() != words.length) {
            return false;
        }

        Map<Character, String> charToWordMap = new HashMap<>();
        Map<String, Character> wordToCharMap = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char currentChar = pattern.charAt(i);
            String currentWord = words[i];

            if (charToWordMap.containsKey(currentChar)) {
                if (!charToWordMap.get(currentChar).equals(currentWord)) {
                    return false; // Mismatch in pattern
                }
            } else {
                charToWordMap.put(currentChar, currentWord);
            }

            if (wordToCharMap.containsKey(currentWord)) {
                if (wordToCharMap.get(currentWord) != currentChar) {
                    return false; // Mismatch in pattern
                }
            } else {
                wordToCharMap.put(currentWord, currentChar);
            }
        }

        return true; // Full match
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: Pattern P
        String pattern = scanner.next();

        // Consume the newline character
        scanner.nextLine();

        // Input: String S
        String s = scanner.nextLine().trim();

        // Output: True or False
        boolean result = patternMatching(pattern, s);
        System.out.println(result);

        scanner.close();
    }
}

/*

 */