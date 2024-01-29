import java.util.*;

public class CrackThePassCode {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String S = in.nextLine();
        String result = findSubstring(S);
        System.out.println(result);
    }
    public static String findSubstring(String S){
        int n = S.length();
        //Iterate through the string to find the longest common prefix substring
        for(int len = n-1;len >0 ;len--){
            String prefix = S.substring(0,len);
            String suffix = S.substring(n-len);

//            String suffix = new StringBuilder(S.substring(n-len)).reverse().toString();
//            if(prefix.equals(suffix)){
//                //check if the substring is located somehwere inside the string
//                String insideSubstring = S.substring(len,n-len);
//                if(!insideSubstring.isEmpty() && insideSubstring.contains(prefix)){
//                    return insideSubstring;
//                }
//            }

//            String suffix = new StringBuilder(S.substring(1,n-1)).reverse().toString();
            String insideSubstring = S.substring(len,n);
            if(insideSubstring.contains(prefix)){
                return prefix;
            }
        }
        return "Not so cool";
    }
}

/*
Problem Statement
Rahul, Raj and their temporary buddies suffix and prefix found the harmony temple. Its doors are temporarily locked and no one was able to open the door.
Later they found a string S written on the rock and spoke the string aloud but nothing happened. Then Raj thought the password might be substring t of the string S.
Prefix supposed that the substring t is the beginning of the string S, Suffix supposed that the substring t should be the end of the string S and Raj supposed that t should be located somewhere inside the string S, that is, t is neither its beginning nor its end.
Rahul chose the substring t so as to please all his companions. Besides, from all the acceptable variants, Rahul chose the longest one(as he loves long strings). When Rahul spoke aloud, doors suddenly opened.
You are given the string S. Find the substring t or determine that such substring does not exist.


Input format
The first line contains the non-empty string S

Output format
Print the string t. If a suitable t string does not exist, then print "Not so Cool" without the quotes.

Constraints
1 <=S <= 10^6

Time Limit
1 second

Example
Sample Input
qwertyqwertyqwerty

Sample Output
qwerty

Sample Test Case Explanation
qwerty is the longest substring present in the qwertyqwertyqwerty satisfying the conditions.


Default Code
import java.util.*;
import java.io.*;

public class Main {
  public static void main(String args[]) throws IOException {

    //write your code here

  }
}

 */