import java.util.Scanner;

public class HearingChallenge {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character after reading T

        for (int i = 0; i < T; i++) {
            String S = scanner.nextLine();
            String result = isSubstringOfYes(S);
            System.out.println(result);
        }
    }
    public static String isSubstringOfYes(String S){
        String repeatedYes = "Yes";
        while(repeatedYes.length() < S.length()){
            repeatedYes += "Yes";
        }
        if(repeatedYes.contains(S)){
            return "YES";
        }
        else{
            return "NO";
        }
    }
}
/*
Problem Statement
You talked to Prepbuddy and asked him a question. You know that when he wants to answer "Yes", he repeats “Yes” many times in a row.
Because of the noise, you only heard part of the answer — some substring of it. That is, if he answered YesYes, then you could hear esY, YesYes, sYes, e, but you couldn't Yess, YES or se.
Determine if it is true that the given string S is a substring of YesYesYes... (Yes repeated many times in a row)

Input format
The first line of input data contains the singular T — the number of test cases.
Each test case is described by a single string of letters S — the part of the Prepbuddy answer that you heard.


Output format
Print "YES" if the specified string s is a substring of the string YesYesYes...Yes (the number of words Yes is arbitrary)  and "NO" otherwise(without quotes).

Constraints
1 <= T <= 100
1 <= S <= 50

Time Limit
1 second

Example
Sample Input
5
YES
esYes
prepbytes
es
se

Sample Output
NO
YES
NO
YES
NO

Sample Test Case Explanation
In the given examples , esYes and es are the given substring of  YesYesYes(Yes repeated many times in a row)

Default Code
import java.util.*;
import java.io.*;

public class Main {
  public static void main(String args[]) throws IOException {

    //write your code here

  }
}
 */