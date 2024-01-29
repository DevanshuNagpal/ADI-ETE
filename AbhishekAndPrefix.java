import java.util.Scanner;
import java.util.Arrays;

public class AbhishekAndPrefix {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: Strings S and T
        String S = scanner.nextLine();
        String T = scanner.nextLine();

        // Output: Maximum length of some prefix of S which occurs in T as a subsequence
        int result = maxLengthOfPrefix(S, T);
        System.out.println(result);

        scanner.close();
    }
/*
    static int maxLengthOfPrefix(String S, String T) {
        int m = S.length();
        int n = T.length();

        int[][] memo = new int[m + 1][n + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return memoizedDP(S, T, m, n, memo);
    }

    static int memoizedDP(String S, String T, int m, int n, int[][] memo) {
        if (m == 0 || n == 0) {
            return 0;
        }

        if (memo[m][n] != -1) {
            return memo[m][n];
        }

        if (S.charAt(m - 1) == T.charAt(n - 1)) {
            memo[m][n] = 1 + memoizedDP(S, T, m - 1, n - 1, memo);
        } else {
            memo[m][n] = Math.max(memoizedDP(S, T, m - 1, n, memo), memoizedDP(S, T, m, n - 1, memo));
        }

        return memo[m][n];
    }

 */

    static int maxLengthOfPrefix(String S, String T) {
        int m = S.length();
        int n = T.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (S.charAt(i - 1) == T.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }
}

/*
Question 11:  Abhishek and Prefix

Problem Statement
Abhishek loves the string algorithms very much and his teacher gave him a task in which he was provided with two strings S and T and he had to find the maximum length of some prefix of the string S which occurs in string T as a subsequence.
As Abhishek is having an exam tomorrow and he isn't having time, he wants your help with the solution.

Input format
The first line represents the string S.
The second line contains the string T.

Output format
Print the required answer.

Constraints
1 <= S, T <= 10^6
Note: Both strings consist of lowercase Latin letters.

Example
Sample Input 1
digger
biggerdiagram

Sample Output 2
3
Sample Input 2
absolute
Itisabsentinthedrive

Sample Output 2
3
 */