public class UglyNumber {
    public static void main(String[] args) {
        // Sample Input
        int num1 = 6;
        int num2 = 34;

        // Sample Output
        System.out.println(isUgly(num1)); // Output: true
        System.out.println(isUgly(num2)); // Output: false
    }

    public static boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }

        // Continue dividing by 2, 3, and 5 while n is divisible
        while (n % 2 == 0) {
            n /= 2;
        }

        while (n % 3 == 0) {
            n /= 3;
        }

        while (n % 5 == 0) {
            n /= 5;
        }

        // If n becomes 1, it's an ugly number
        return n == 1;
    }
}

/*
Question 2: Ugly Number
Problem Statement: Input an integer n and check whether n is an ugly number or not.Return true if n is an ugly number otherwise false.An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.

Input Format
Integer: Only integer. DO NOT INPUT string, floating point numbers or any other data type.
Output Format
Boolean: For each test case, return true or false.
Constraints
-2^31 <= n <= 2^31 - 1
Example
Sample Input 1
6
Sample Output 1
true
Sample Input 2
34
Sample Output 2
false

 */