import java.util.Scanner;

public class OddEvenCharacter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Sample Input
        System.out.println("Enter the string:");
        String input = scanner.nextLine();

        // Sample Output
        String result = replaceCharacters(input);
        System.out.println("Modified string: " + result);
    }

    public static String replaceCharacters(String input) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            // Check if the character is even or odd
            if (i % 2 == 0) {
                // Replace even character with the character having just higher ASCII code
                result.append((char) (currentChar + 1));
            } else {
                // Replace odd character with the character having just lower ASCII code
                result.append((char) (currentChar - 1));
            }
        }

        return result.toString();
    }
}

/*
Question 4:  Odd Even character
Problem Statement: Take as input S, a string. Write a function that replaces every even character with the character having just higher ASCII code and every odd character with the character having just lower ASCII code. Print the value returned.
Input Format
String: Can be a combination of alphabets(Both uppercase and lowercase),numbers, special characters etc.
Output Format
String: Required answer
Example
Sample Input 1
abcg
Sample Output 1
badf
Sample Input 2
ABcdfg
Sample Output 2
BAdcgf

 */