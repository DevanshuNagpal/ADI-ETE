import java.util.HashMap;
import java.util.Scanner;

public class IsomorphicKeyboardLayoutChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input two strings
        String firstString = scanner.nextLine();
        String secondString = scanner.nextLine();

        // Check if the layout is isomorphic and print the result
        if (isIsomorphic(firstString, secondString)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

        scanner.close();
    }

    static boolean isIsomorphic(String str1, String str2) {
        // Check if lengths are different
        if (str1.length() != str2.length()) {
            return false;
        }

        // Create maps to store the mapping of characters from str1 to str2, and vice versa
        HashMap<Character, Character> map1 = new HashMap<>();
        HashMap<Character, Character> map2 = new HashMap<>();

        // Iterate through each character in the strings
        for (int i = 0; i < str1.length(); i++) {
            char char1 = str1.charAt(i);
            char char2 = str2.charAt(i);

            // Check if mapping exists in both directions
            if ((map1.containsKey(char1) && map1.get(char1) != char2) ||
                    (map2.containsKey(char2) && map2.get(char2) != char1)) {
                return false;
            }

            // Add the mapping to the maps
            map1.put(char1, char2);
            map2.put(char2, char1);
        }

        return true;
    }
}
/*
Isomorphic Keyboard Layout Checker
Problem Statement: A company is designing a new keyboard layout, and they want to ensure that the layout is isomorphic. In this context, a keyboard layout is considered isomorphic if, when you press a key on the keyboard, it produces the same result regardless of whether the keyboard layout is QWERTY or AZERTY. The company has developed a program that checks whether two given strings represent isomorphic keyboard layouts.
Input Format
String: Two-line separated inputs will be given in String format.
        Output Format
Check if layout is isomorphic or not, if isomorphic print “YES”, if not print “NO”.
Constraints
Do not Input special characters.
Do not start the input string with a number.
Sample Input 1
egg
        add
Sample Output 1
YES
Sample Input 2
egg12
        add11
Sample Output 2
NO
 */