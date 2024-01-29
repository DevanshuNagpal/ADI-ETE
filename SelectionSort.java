import java.util.Arrays;
import java.util.Scanner;

public class SelectionSort {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input size of the array
        int N = scanner.nextInt();

        // Input array elements
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }

        // Perform selection sort and print array after each pass
        selectionSort(arr, N);

        scanner.close();
    }

    static void selectionSort(int[] arr, int N) {
        for (int i = 0; i < N - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < N; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap arr[i] with arr[minIndex]
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;

            // Print array after each pass
            System.out.println(Arrays.toString(arr));
        }
    }
}

/*
Question 5: Selection Sort
Problem Statement: Given an unsorted array of size N, use selection sort to sort arr[] in increasing order. You are also required to print the array after every pass (After every swap) using Arrays.toString().
Input Format
First Integer input (N), represents the size of the array.
Next line consist of N-space separated integers representing the values in the array
Output Format
(N-1) lines of array representation after each swap. The arrays must be printed using Arrays.toString().

Constraints
1 ≤ N ≤ 10^3

Example

Sample Input 1
5
12 23 54 67 17

Sample Output 1

[12, 23, 54, 67, 17]
[12, 17, 54, 67, 23]
[12, 17, 23, 67, 54]
[12, 17, 23, 54, 67]

Sample Input 2
4
45 12 90 65

Sample Output 2
[12, 45, 90, 65]
[12, 45, 90, 65]
[12, 45, 65, 90]


 */