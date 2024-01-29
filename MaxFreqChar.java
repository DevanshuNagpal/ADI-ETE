import java.util.Scanner;

public class MaxFreqChar {
    static char maxFrequencyChar(String s) {
        int[] frequency = new int[26]; // Assuming only lowercase alphabets

        for (char ch : s.toCharArray()) {
            frequency[ch - 'a']++;
        }

        char maxChar = s.charAt(0);
        int maxFrequency = frequency[maxChar - 'a'];

        for (char ch : s.toCharArray()) {
            if (frequency[ch - 'a'] > maxFrequency || (frequency[ch - 'a'] == maxFrequency && ch < maxChar)) {
                maxChar = ch;
                maxFrequency = frequency[ch - 'a'];
            }
        }

        return maxChar;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: String S
        String s = scanner.next();

        // Output: Character with maximum frequency
        char result = maxFrequencyChar(s);
        System.out.println(result);

        scanner.close();
    }
}
/*
Problem Statement
Input a String S. Write a function that returns the character with maximum frequency. Print the character returned. In case, if no character is repeated in the input, the function must return first character of the string. If the different characters have same frequency in the input, first character encountered must be returned.
Input Format
String: The Input String S must be lowercase alphabets only.
DO NOT INPUT Uppercase alphabets, numbers or alphanumeric characters.
Output Format
Character: For each test case, print the character with maximum frequency in a String.
Constraints
A string of length between 1 to 1000.
Example
Sample Input 1
abbc
Sample Output 1
b
Sample Input 2
aabbcc
Sample Output 2
a
Sample test case Explanation
In the first test case, b is the character with maximum frequency 2. b is returned and printed as output.
In the second test case a, b, c all three are of same frequency i.e 2 so first character a is encountered, returned and printed.

 */
