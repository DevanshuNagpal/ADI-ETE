import java.util.Scanner;

public class ClimbingStairs {

    static int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        }

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input for Climbing Stairs
        int n = scanner.nextInt();

        // Output for Climbing Stairs
        int result = climbStairs(n);
        System.out.println(result);

        scanner.close();
    }
}

/*
Question 20: Climbing Stairs

Problem Statement :You are climbing a staircase. It takes n steps to reach the top.Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Input Format
Integer: Only Integers

Output Format
Print the required answer
Constraints
1 <= n <= 45
Example
Sample Input 1
5

Sample Output 1
8

Sample Input 2
13

Sample Output 2
377


 */