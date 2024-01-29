import java.util.*;
public class knapsack01 {
//    MEMOIZATION HASHMAP
/*
    static int knapSack(int W, int wt[], int val[], int n,HashMap<String,Integer> memo)
    {
        if(n == 0 || W == 0){
            return 0;
        }
        if(memo.containsKey(W+","+n)){
            return memo.get(W+","+n);
        }

        if(wt[n-1] > W){
            return knapSack(W,wt,val,n-1,memo);
        }
        else{
            int pick = val[n-1] + knapSack(W - wt[n - 1],wt,val,n-1,memo);
            int notPick = knapSack(W,wt,val,n-1,memo);
            int result = Math.max(pick,notPick);
            memo.put(W + ","+ n , result);
            return result;
        }
    }

    static int knapSack(int W, int wt[], int val[], int n){
       return knapSack(W,wt,val,n,new HashMap<>());
    }
 */

//    MEMOISATION 2d matrix
/*
    static int knapSack(int W, int wt[], int val[], int n,int[][] dp) {
        if(n==0|W==0){
            return 0;
        }
        if(dp[n][W] != -1){
            return dp[n][W];
        }
        if(wt[n-1] > W){
            return knapSack(W,wt,val,n-1,dp);
        }
        else{
            return dp[n][W] = Math.max(val[n-1] + knapSack(W-wt[n-1],wt,val,n-1,dp) , knapSack(W,wt,val,n-1,dp));

        }
    }



    static int knapSack(int W, int wt[], int val[], int n){
//        return knapSack(W,wt,val,n,new HashMap<>());
        int dp[][]  = new int[n+1][W+1];

        for(int[] rows:dp){
            Arrays.fill(rows,-1);
        }

        return knapSack(W,wt,val,n,dp);

    }

*/


//    Tabulation
    static int knapSack(int W, int wt[], int val[], int n) {
        int dp[][] = new int[n+1][W+1];
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (i == 0 || w == 0)
                    dp[i][w] = 0;
                else if (wt[i - 1] <= w)
                    dp[i][w]
                            = Math.max(val[i - 1]
                                    + dp[i - 1][w - wt[i - 1]],
                            dp[i - 1][w]);
                else
                    dp[i][w] = dp[i - 1][w];
            }
        }

        return dp[n][W];

    }


    public static void main(String[] args)
    {
        int profit[] = new int[] { 10,5,15 };
        int weight[] = new int[] { 2,3,5};
        int W = 8;
        int n = profit.length;
        System.out.println(knapSack(W, weight, profit, n));
    }
}


/*
Question 1: 
Problem Statement
Given N items, each with its weight and profit, and a bag with a capacity W, the task is to select items to maximize the total profit such that the sum of weights of selected items is less than or equal to the bag's capacity.
Input Format
The input consists of an integer N denoting the number of items. This is followed by N pairs of integers representing the weight and profit of each item. Finally, an integer W represents the capacity of the bag.
Integer // Number of Items
Pair of Integers // weight and profit of each item 
Integer // capacity of the bag
Output Format
Print an integer representing the maximum possible profit.
Integer // Maximum possible profit
Constraints
1 ≤ N ≤ 100
1 ≤ Weight, Profit ≤ 1000
1 ≤ Bag capacity ≤ 10000
Example
Sample Input 1
3           // Number of Items
2 10      // Item 1 weight and profit
3 5       // Item 2 weight and profit
5 15    // Item 3 weight and profit
8         // capacity of the bag
Sample Output 1
25                    // Maximum possible profit 

Sample Input 2
4        // Number of Items
1 1     // Item 1 weight and profit
3 4     // Item 2 weight and profit
4 5    // Item 3 weight and profit
5 7   // Item 4 weight and profit
7      // capacity of the bag
Sample Output 2
9   // Maximum possible profit
Sample test case Explanation
For the given input, the items are:

Item 1: Weight = 2, Profit = 10
Item 2: Weight = 3, Profit = 5
Item 3: Weight = 5, Profit = 15

The bag's capacity is 8. By selecting Item 1 and Item 3, the total weight is 7 (2 + 5) which is less than 8, and the total profit is 25 (10 + 15), which is the maximum possible.

In the second test case 
For the given input, the items are:

Item 1: Weight = 1, Profit = 1
Item 2: Weight = 3, Profit = 4
Item 3: Weight = 4, Profit = 5
    Item 4: Weight = 5, Profit = 7

The bag's capacity is 7. By selecting Item 2 and Item 3, the total weight is 7 (2 + 5) which is equal to 7, and the total profit is 9 (4 + 5), which is the maximum possible.

 */