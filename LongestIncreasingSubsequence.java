import java.util.*;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: Size of the array
        int N = scanner.nextInt();

        // Input: Array elements
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }

        // Output: Length of the longest increasing subsequence
        int result = lengthOfLIS(arr);
        System.out.println(result);
    }
    public static int lengthOfLIS(int[] nums){
        int dp[][] = new int[nums.length][nums.length + 1];

        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return lengthOfLIS(nums,nums.length,0,-1,dp);
    }
    public static int lengthOfLIS(int[] nums,int n , int ind , int prev, int[][] dp){
        if(ind== n ){
            return 0;
        }
        if(dp[ind][prev + 1] != -1){
            return dp[ind][prev+1];
        }
        int notTakenLen = lengthOfLIS(nums,n,ind+1,prev,dp);
        int takeLen = 0;

        if(prev == -1 || nums[ind] > nums[prev]){
            takeLen = 1 + lengthOfLIS(nums,n,ind+1,ind,dp);
        }
        dp[ind][prev+1] = Math.max(takeLen,notTakenLen);
        return dp[ind][prev + 1];
    }
}
/*
Problem Statement : Given an array of integers, find the length of the longest subsequence in the array such that all elements of the subsequence are sorted in strictly increasing order.

Input Format : The input begins with an integer N denoting the size of the array. This is followed by N integers representing the elements of the array.

Output Format: Print an integer representing the length of the longest increasing subsequence.

Constraints :
    1 ≤ N ≤ 1000
    -10^9 ≤ Array elements ≤ 10^9

Time Limit : 1 second

Example
Input:
8
10 22 9 33 21 50 41 60

Output:
5

Explanation:
For the given input array [10, 22, 9, 33, 21, 50, 41, 60], the longest increasing subsequence is [10, 22, 33, 50, 60] with a length of 5.

Default Code :
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) {
    }
}





Coding Block Link: https://ide.codingblocks.com/s/681166

*/

