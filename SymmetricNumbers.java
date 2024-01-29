import java.util.Scanner;

public class SymmetricNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Sample Input
        System.out.println("Enter the range (low and high):");
        int low = scanner.nextInt();
        int high = scanner.nextInt();

        // Sample Output
        int count = countSymmetricNumbers(low, high);
        System.out.println("Count of Symmetric Numbers: " + count);
    }

    public static int countSymmetricNumbers(int low, int high) {
        int count = 0;

        for (int i = low; i <= high; i++) {
            if (isSymmetric(i)) {
                count++;
            }
        }

        return count;
    }

    public static boolean isSymmetric(int num) {
        // Convert the number to a string for easier manipulation
        String numStr = Integer.toString(num);
        int n = numStr.length();

        // Check if the number has an even number of digits
        if (n % 2 != 0) {
            return false;
        }

        // Calculate the sum of the first half and the sum of the second half
        int sumFirstHalf = 0, sumSecondHalf = 0;
        for (int i = 0; i < n / 2; i++) {
            sumFirstHalf += Character.getNumericValue(numStr.charAt(i));
            sumSecondHalf += Character.getNumericValue(numStr.charAt(i + n / 2));
        }

        // Check if the sums are equal
        return sumFirstHalf == sumSecondHalf;
    }
}

/*
Question 5: Symmetric Numbers
Problem Statement: Take two positive integers low and high for input.An integer x consisting of 2 * n digits is symmetric if the sum of the first n digits of x is equal to the sum of the last n digits of x. Numbers with an odd number of digits are never symmetric.
Return the number of symmetric integers in the range [low, high].
Input Format
Integer: Low and High, Only integers.
Output Format
Integer: Count of Symmetric Numbers.
Constraints
1 <= low <= high <= 10^4
Example
Sample Input 1
1
100
Sample Output 1
9
Sample Input 2
23
900
Sample Output 2
7

 */