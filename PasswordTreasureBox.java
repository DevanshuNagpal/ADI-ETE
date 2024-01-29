import java.util.*;

public class PasswordTreasureBox {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //input space separated
        System.out.println("Enter space-separated words:");
        String input = in.nextLine();

        // Output: Code Number
        String code = findCode(input);
        System.out.println("Code: " + code);
    }
    public static String findCode(String input){
        //split the input string into an array of words
        String[] words = input.split(" ");
        StringBuilder codeBuilder = new StringBuilder();

        //process each word and calculate the code
        for(String word:words){
            int value = calcualteValue(word);
            codeBuilder.append(Math.max(0,Math.min(9,value)));
            //ensure the value is between 0 and 9
        }
        return codeBuilder.toString();
     }
     public static int calcualteValue(String word){
        int value = 0;
        //calulate the value based on the rules
         for(char ch: word.toCharArray()){
             if(Character.isUpperCase(ch)){
                 value += ch - 'A' + 1;

             }
             else if(Character.isLowerCase((ch))){
                 value -= ch -'a' +1;
             }
         }
         return value;
     }

}

/*
Question 2: Password of the treasure box

Problem Statement

While digging in his backyard, Anil has found a treasure box and a bottle with a note inside it. The first line in the note says,” Biggers will be rewarded and the Smalls will be slaughtered” and the second line is some arbitrary space separated words which does not make any sense. After searching about such a treasure and note online, he came to understand that the note holds the password for the treasure box. The arbitrary space separated words actually form a number which could be used to open the box.

The number of those arbitrary words in the note is the number of digits of the required number to open the box. A word represents a digit that cannot be less than 0 and greater than 9. So, if the word deciphered into a number comes greater than 9, it is taken as 9 and if it comes less than 0, it is taken as 0. The word can be transformed into a number by using the following rules:

    1. Alphabets written in Capital are to be added while small ones are to be subtracted. Example:
If the word is ANil
Value of A and N is to be added and the value of i and l is to be subtracted.
    2. Alphabets (either small case or upper case) are assigned values in ascending order from 1 to 26. Example:
A-1, C-3…………Z-26
So word ANil will give 0.

Help Anil write a JAVA program to find the code to open the treasure box and see what is inside it.
Input Format
String: Space Separated Words
DO NOT INPUT numbers or alphanumeric characters.
Output Format
Returns the code Number
Example
Sample Input 1
ABc CDeF GHi
Sample Output 1
086
Sample Input 2
ANil
Sample Output 2
0
Sample test case Explanation
In the first test case, there are 3 words
for the first word ABc – A-1, B-2, c-3 (1+2 -3 =0)
for the second word CDeF – C-3, D-4, e-5, F-6 (3 + 4 -5 +6 =8)
for the third word GHi – G-7, H-8, i-9 (7 +8 -9 =6)
So, the code is 086
In the second test case, there is single word
For ANil – A-1, N-14, i-9, l-12 (1 +14 -9-12 =-6 that automatically converts to 0)
As if the number is less than 0 (zero) then the code is equal to 0.

 */
