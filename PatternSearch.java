import java.util.Scanner;

public class PatternSearch {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input text and pattern
        String text = scanner.nextLine();
        String pattern = scanner.nextLine();
        text = text.toLowerCase();
        pattern = pattern.toLowerCase();

        // Find and print the starting index of the pattern
        int index = searchPattern(text, pattern);
        System.out.println(index);


        scanner.close();
    }

    static int searchPattern(String text, String pattern) {
        int[] lps = calculateLPS(pattern);

        int i = 0; // Index for text
        int j = 0; // Index for pattern

        while (i < text.length()) {
            if (pattern.charAt(j) == text.charAt(i)) {
                i++;
                j++;
            }

            if (j == pattern.length()) {
                return i - j;
            } else if (i < text.length() && pattern.charAt(j) != text.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        return -1; // Pattern not found
    }

    static int[] calculateLPS(String pattern) {
        int[] lps = new int[pattern.length()];
        int len = 0; // Length of the previous longest prefix suffix

        for (int i = 1; i < pattern.length(); ) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }
}

/*
Starting Index of the Pattern matched in the String
Imagine you are developing a text processing application in Java. Users can input a large text document, and your application needs to perform pattern searching to find occurrences of specific words or phrases within the text. Write a function that returns the starting index of the pattern matched in the string first time.
Input Format
Line1: Text in which you want to search for a pattern. Each word must be separated by space in the text.
Line2: Pattern you want to search in text. Take care of case sensitivity during input of pattern.
Output Format
Print Index where pattern found, if no pattern found print -1.
Constraints
Implement KMP algorithm in code, complexity should not exceed O(m+n).
Sample Input 1
This is a simple example.
simple
Sample Output 1
10
Sample Input 2
Lorem ipsum dolor sit amet, consectetur adipiscing elit.
Ipsum
Sample Output 2
6

 */