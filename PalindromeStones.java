import java.util.Scanner;

public class PalindromeStones {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: String pattern
        System.out.println("Enter the string pattern:");
        String pattern = scanner.nextLine();

        // Output: Palindrome substrings and their indices
        findPalindromes(pattern);
    }

    public static void findPalindromes(String pattern) {
        int n = pattern.length();
        boolean[][] isPalindrome = new boolean[n][n];
        boolean foundPalindrome = false;

        // Initialize single characters as palindromes
        for (int i = 0; i < n; i++) {
            isPalindrome[i][i] = true;
        }

        // Check for palindromes of length 2
        for (int i = 0; i < n - 1; i++) {
            if (pattern.charAt(i) == pattern.charAt(i + 1)) {
                isPalindrome[i][i + 1] = true;
                foundPalindrome = true;
                System.out.println(pattern.substring(i, i + 2) + " " + i + "-" + (i + 1));
            }
        }

        // Check for palindromes of length 3 or more using dynamic programming
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (pattern.charAt(i) == pattern.charAt(j) && isPalindrome[i + 1][j - 1]) {
                    isPalindrome[i][j] = true;
                    foundPalindrome = true;
                    System.out.println(pattern.substring(i, j + 1) + " " + i + "-" + j);
                }
            }
        }

        // if no palindrome found
        if (!foundPalindrome) {
            System.out.println("No palindrome string found");
        }
    }
}

/*
6. The Lost Palindrome Stones

Problem Statement
Once upon a time, in the mystical land of Enchantoria, there existed a hidden treasure known as the "Palindrome Stones." Legend had it that these magical stones, when placed together in a specific sequence, had the power to unlock an ancient portal to a realm of unimaginable wonders.
The wise guardian of Enchantoria, an ancient wizard named Eldor, had inscribed a prophecy that foretold the discovery of the Palindrome Stones by a chosen one. The prophecy revealed that these magical stones were embedded within a cryptic pattern, and only those who could decipher the pattern and extract the palindrome substrings would unveil the path to the hidden treasure.
Your quest begins as you, the chosen one, embark on a journey to decipher the ancient pattern. Eldor provides you with a magical scroll containing the mysterious pattern. The pattern is a sequence of symbols, each holding the potential to reveal a part of the palindrome sequence.
Your task is to write a program that extracts all possible palindrome substrings from the given pattern and returns the indices where each of these substrings is located. The indices will guide you to arrange the Palindrome Stones in the correct order, unlocking the portal to the realm of wonders.
Each palindrome substring discovered represents a fragment of the ancient incantation needed to activate the portal. Eldor, in his wisdom, has left clues within the pattern, and by identifying these palindromes and their positions, you will uncover the hidden magic within the stones.
As you delve into the enchanting world of Enchantoria, remember that the indices of the palindrome substrings are the key to your success. Write a program to fulfill the prophecy, unravel the secrets of the Palindrome Stones, and open the portal to the extraordinary realm that awaits you. The fate of Enchantoria rests in your hands. Good luck, brave adventurer!

Input Format
Any string pattern
Output Format
The program prints the palindrome substrings (minimum of length 3)  found in the pattern along with their indices.
Example
Sample Input 1
racecar              // any string pattern
Sample Output 1
cec 2-4    // output palindrome substring of min length 3 along with indices
aceca 1-5
racecar 0-6
Sample Input 2
enchantoria
Sample Output 2
No Palindrome string found
Sample test case Explanation
In the first test case, output palindrome substring of min length 3 along with indices.
In the second test case, there is no palindrome substring so print “No Palindrome string found”


 */
