import java.util.Scanner;

public class ReduceToZero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Sample Input
        System.out.println("Enter the target number:");
        int target = scanner.nextInt();

        // Sample Output
        int steps = reduceToZero(target);
        System.out.println("Number of steps required: " + steps);
    }

    public static int reduceToZero(int target) {
        int steps = 0;

        while (target > 0) {
            if (target % 2 == 0) {
                target /= 2;
            } else {
                target -= 1;
            }
            steps++;
        }

        return steps;
    }
}

/*
Question 3: Reducing the Target number to Zero
Problem Statement
Given an integer “target”, return the number of steps to reduce it to zero.In one step, if the current number is even, you have to divide it by 2, otherwise, you have to subtract 1 from it.
Input Format
Integer: Only integer. DO NOT INPUT string, floating point numbers or any other data type.
Output Format
Integer: Number of steps required for reduction of Target to  0.
Constraints
0 <= num <= 10^6
Example
Sample Input 1
14
Sample Output 1
6
Sample Input 2
23
Sample Output 2
8
 */