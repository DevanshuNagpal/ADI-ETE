import java.util.*;

public class CountBits {

    static int[] countBits(int n) {
        int[] ans = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            // Counting bits using Brian Kernighan's algorithm
            ans[i] = ans[i >> 1] + (i & 1);
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input for Counting Bits
        int n = scanner.nextInt();

        // Output for Counting Bits
        int[] result = countBits(n);
        System.out.println(Arrays.toString(result));

        scanner.close();
    }
}
/*

Question 19: Counting Bits

Problem Statement : Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.

Input Format
Integer: Only Integers

Output Format
Print the required answer
Constraints
0 <= n <= 10^5
Example
Sample Input 1
2

Sample Output 1
[0,1,1]

Sample Input 2
5

Sample Output 2
[0,1,1,2,1,2]

 */