import java.util.Scanner;

public class SortArrayIndices {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input size of the array
        int N = scanner.nextInt();

        // Input array elements
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }

        // Perform sorting and print the resulting indices
        sortIndices(arr, N);

        scanner.close();
    }

    static void sortIndices(int[] arr, int N) {
        // Create an array of indices and initialize it
        int[] indices = new int[N];
        for (int i = 0; i < N; i++) {
            indices[i] = i;
        }

        // Implement selection sort on indices array based on values in the original array
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (arr[indices[i]] < arr[indices[j]]) {
                    int temp = indices[i];
                    indices[i] = indices[j];
                    indices[j] = temp;
                }
            }
        }

        // Print the resulting indices
        for (int i = 0; i < N; i++) {
            System.out.print(indices[i] + " ");
        }
    }
}


/*
Question 7: Sort array indices
Problem Statement: Input an array of integers of size N. The task is to print the index of the largest number first and then the index of the 2nd largest number and so on till the last one. If two or more numbers are the same then print the index of the number which comes first in the array.
Input Format
First Line consists of Integer value (N) representing the size of Array.
Second line consists of N space-separated integers representing the values of the array.
Output Format
Print space separated Index of array elements as mentioned in question.
Sample Input 1
6
2 6 4 8 2 6
Sample Output 1
3 1 5 2 0 4

Sample Input 2
4
1 3 7 5
Sample Output 2
2 3 1 0

 */
