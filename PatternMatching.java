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
Question 2: Pattern Matching
Problem Statement
Input a pattern P and String S. Program must return “True” if S (String) follows the same pattern P, otherwise return “False”. Here follows means a full match, such that there is a one to one correspondence between a character/letter in pattern and a non-empty word in the String S.
Input Format
Pattern: String, can be a combination of alphabets or numbers.
String: String, a non-empty word that can be a combination of alphabets or numbers. Include space among each non-empty word.
First input Pattern and then String in the next line and they must not be same.
Output Format
Character: For each test case, return true or false.
Constraints
A string of length between 1 to 1000.
Example
Sample Input 1
abba
dog cat cat dog
Sample Output 1
true
Sample Input 2
abba
dog cat cat fish
Sample Output 2
false
Sample test case Explanation
In the first test case, dog is following a, cat is following b, so there is a full match. Output “true”
In the second test case dog is following a, cat is following b but fish is a mismatch. Not a full match, so output “false”
 */
