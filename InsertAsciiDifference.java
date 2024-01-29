import java.util.Scanner;

public class InsertAsciiDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: String S
        System.out.println("Enter the string:");
        String inputString = scanner.nextLine();

        // Output: String with difference between characters
        String result = insertAsciiDifference(inputString);
        System.out.println("Result: " + result);
    }

    public static String insertAsciiDifference(String s) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length() - 1; i++) {
            result.append(s.charAt(i));
            result.append(s.charAt(i + 1) - s.charAt(i));
        }

        // Append the last character
        result.append(s.charAt(s.length() - 1));

        return result.toString();
    }
}
/*
Problem Statement
Take as input S, a string. Write a program that inserts between each pair of characters the difference between their ascii codes and print the answer.
Input Format
String: The Input String S can be alphabets, numbers or alphanumeric characters.
Output Format
String: String with difference between characters
Example
Sample Input 1
acb
Sample Output 1
a2c-1b
Sample Input 2
A12$
Sample Output 2
A-16112-14$
 */