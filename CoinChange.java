import java.util.Scanner;

public class CoinChange {

    static int coinChange(int[] coins, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int amount = coin; amount <= target; amount++) {
                dp[amount] += dp[amount - coin];
            }
        }

        return dp[target];
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] coins = new int[n];

        for (int i = 0; i < n; i++) {
            coins[i] = scanner.nextInt();
        }

        int target = scanner.nextInt();

        System.out.println(coinChange(coins, target));

        scanner.close();
    }
}
/*
Question 16: Coin Change Problem

Problem Statement : Given a set of coins with certain denominations and a target amount, determine the number of ways to make the target amount using any combination of coins.

Input Format
The input begins with an integer N denoting the number of denominations. This is followed by N integers representing the denominations of coins. Then an integer target denoting the target amount.

Output Format
Print an integer representing the number of ways to make the target amount using the given coins.

Constraints
    1 ≤ N ≤ 100
    1 ≤ Denomination values ≤ 1000
    1 ≤ Target amount ≤ 10000
Example
Sample Input 1
4
1 2 5 10
12

Sample Output 1
15

Sample Input 2
6
1 2 5 10 2 7
12
Sample Output  2
51

Explanation
For the given sample input 1, the denominations are 1, 2, 5, 10, and the target amount is 12. There are 15 different ways to make the amount 12 using these denominations.

Default Code
import java.util.*;

class Main {

    static int coinChange(int[] coins, int target) {

    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] coins = new int[n];

        for (int i = 0; i < n; i++) {
            coins[i] = scanner.nextInt();
        }

        int target = scanner.nextInt();

        System.out.println(coinChange(coins, target));

        scanner.close();
    }
}


 */
