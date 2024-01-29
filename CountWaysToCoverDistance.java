import java.util.Arrays;
import java.util.Scanner;

public class CountWaysToCoverDistance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Sample Input
        System.out.println("Enter the distance:");
        int dist = scanner.nextInt();

        // Sample Output
//        long ways = countWays(dist);
        long[] memo = new long[dist + 1];
        Arrays.fill(memo, -1);
        long ways = countWays(dist,memo);
        System.out.println("Total number of ways to cover the distance: " + ways);
    }
/*
    public static long countWays(int dist) {
        long[] dp = new long[dist + 1];
        dp[0] = 1;

        for (int i = 1; i <= dist; i++) {
            if (i - 1 >= 0) {
                dp[i] += dp[i - 1];
            }
            if (i - 2 >= 0) {
                dp[i] += dp[i - 2];
            }
            if (i - 3 >= 0) {
                dp[i] += dp[i - 3];
            }
        }

        return dp[dist];
    }

 */
    public static long countWays(int dist, long[] memo) {
        if (dist == 0) {
            return 1;
        }

        if (memo[dist] != -1) {
            return memo[dist];
        }

        long totalWays = 0;

        if (dist - 1 >= 0) {
            totalWays += countWays(dist - 1, memo);
        }
        if (dist - 2 >= 0) {
            totalWays += countWays(dist - 2, memo);
        }
        if (dist - 3 >= 0) {
            totalWays += countWays(dist - 3, memo);
        }

        memo[dist] = totalWays;
        return totalWays;
    }
}

/*
Question 6: Count Ways to Cover Distance
Problem Statement : Given a distance 'dist', count the total number of ways to cover the distance using 1, 2, or 3 steps at a time.

Input Format
Integer: The input consists of a single integer representing the distance 'dist'.

Output Format
Integer: Return an integer representing the total number of ways to cover the distance.

Constraints
The distance 'dist' is a non-negative integer.
0 <= dist <= 10^5
Example
Sample Input 1
4

Sample Output 1
7

Sample Input 2
14

Sample Output 2
3136

 */
