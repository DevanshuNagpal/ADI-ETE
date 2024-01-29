import java.util.Scanner;

public class Heapify {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input size of the array
        int N = scanner.nextInt();

        // Input array elements
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }

        // Perform heapify and print the resulting min heap
        heapify(arr, N);

        scanner.close();
    }

    static void heapify(int[] arr, int N) {
        // Start from the last non-leaf node and heapify each node in reverse order
        for (int i = N / 2 - 1; i >= 0; i--) {
            heapifyUtil(arr, N, i);
        }

        // Print the resulting min heap
        for (int i = 0; i < N; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    static void heapifyUtil(int[] arr, int N, int i) {
        int smallest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // Compare with left child
        if (left < N && arr[left] < arr[smallest]) {
            smallest = left;
        }

        // Compare with right child
        if (right < N && arr[right] < arr[smallest]) {
            smallest = right;
        }

        // If smallest is not the root, swap and recursively heapify the affected sub-tree
        if (smallest != i) {
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;

            heapifyUtil(arr, N, smallest);
        }
    }
}
/*
Question 6: Heapify
Problem Statement: Given an Array ‘arr’ of size ‘N’, implement the Heapify Algorithm so as to convert the sequence of elements into a Min Heap.
Input Format
First Line consists of Integer value (N) representing the size of Array.
Second line consists of N space-separated integers representing the values of the array.
Output Format
Print N space-separated integers representing the values of the Min Heap.
Constraints
1 ≤ N ≤ 106
1 ≤ arr[i] ≤ 106
Example
Sample Input 1
5
12 534 32 2 123
Sample Output 1
2 12 32 534 123
Sample Input 2
6
34 23 89 100 5 10
Sample Output 2
5 23 10 100 34 89

 */