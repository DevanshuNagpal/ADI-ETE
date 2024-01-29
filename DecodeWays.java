import java.util.*;

public class DecodeWays {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: Encoded message string
        String s = scanner.next();

        // Calculate the number of ways to decode the message
        int result = numDecodings(s);

        // Output: Number of ways the code can be decoded
        System.out.println(result);
    }

    /*
    private static int numDecodings(String s){
        int n = s.length();
        //Edge case
        if(n == 0 || s.charAt(0) == '0'){
            return 0;
        }
        //dp[i] represents the number of ways to decode the substring s[0...i]
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        for(int i =2;i<=n;i++){
            int oneDigit = Integer.parseInt(s.substring(i-1,i));
            int twoDigits = Integer.parseInt(s.substring(i-2,i));

            if(oneDigit >= 1){
                dp[i] += dp[i-1];
            }
            if(twoDigits >= 10 && twoDigits <=26){
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }
     */

//    Recursive
    private static int numDecodings(String s){
        return countDecodings(s,0);
    }
    private static int countDecodings(String s,int index){
        int n = s.length();
        // Base case
        //If current index reaches the end of string return  1
        if(index == n){
            return 1;
        }
        //if current digit is '0' it cannot be decoded individually
        if(s.charAt(index) == '0'){
            return 0;
        }
        //count the number of decodings for the current digit
        int ways = countDecodings(s,index +1);
        //check if the current digit and the next digit
        // can be decoded as two digit number
        if(index < n-1 && isValidTwoDigit(s.charAt(index),s.charAt(index + 1))){
            ways += countDecodings(s,index + 2);
        }
        return ways;
    }

    private static boolean isValidTwoDigit(char first, char second) {
        int num = (first - '0') * 10 + (second - '0');
        return num >= 10 && num <= 26;
    }
}
/*
Decode Ways

Problem Statement
A message containing letters from A-Z can be encoded into numbers using the following mapping:

'A' -> "1"
'B' -> "2"
...
'Z' -> "26"
To decode an encoded message, all the digits must be grouped and then mapped back into letters using the reverse of the mapping above (there may be multiple ways).

Input Format
contains an input string.
Output Format
An integer. (Total number of ways the code can be decoded)
Constraint
    • 1 <= s.length <= 100
    • s contains only digits and may contain leading zero(s).

Example
Sample Input 1
11106            // (encoded message string)
Sample Output 1
2                         // number of ways the code can be decoded
Sample Input 2
226          // (encoded message string)
Sample Output 2
3                   // number of ways the code can be decoded
Sample test case Explanation
In the first test case, "11106" can be mapped into:

"AAJF" with the grouping (1 1 10 6)
"KJF" with the grouping (11 10 6)
Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is different from "06".
So, the total number of ways is 2.
In the second test case, “226” can be mapped into:
“BZ” with the grouping ( 2 26)
“VF” with the grouping (22 6)
“BBF” with the grouping (2 2 6)
So, the total number of ways is 3.

 */