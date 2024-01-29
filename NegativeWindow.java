import java.util.ArrayList;
import java.util.Scanner;

public class NegativeWindow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: Number of test cases
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            // Input: Size of the array
            int n = scanner.nextInt();

            // Input: Array elements
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = scanner.nextInt();
            }

            // Input: Size of the window (k)
            int k = scanner.nextInt();

            // Output: First negative integer in each window of size k
            printFirstNegativeInWindow(arr, k);
            System.out.println();
        }
    }

    private static void printFirstNegativeInWindow(int[] arr, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        //process the first window separatly
        int i ;
        for(i =0;i<k;i++){
            if(arr[i] < 0){
                list.add(i);
            }
        }
        //process the remaining windows
        for(;i<arr.length;i++){
            //print the first negative integer in the current window or 0 if none exists
            if(!list.isEmpty()){
                System.out.print(arr[list.get(0)] + " ");
            }
            else{
                System.out.print("0 ");
            }

            //remove the elements that are out of the current window
            while(!list.isEmpty() && list.get(0) < i-k+1){
                list.remove(0);
            }
            //add the current element's index to the list if its negative
            if(arr[i] < 0){
                list.add(i);
            }

        }
        //process the last window
        if(!list.isEmpty()){
            System.out.print(arr[list.get(0)]);
        }
        else{
            System.out.print("0");
        }
    }

}
/*
Que 9  :- Given an array and a positive integer k, find the first negative integer for each window(contiguous subarray) of size k. If a window does not contain a negative integer, then print 0 for that window.

Input : arr[] = {12, -1, -7, 8, -15, 30, 16, 28} , k = 3
Output : -1 -1 -7 -15 -15 0

Example :-
Input:
5
-8 2 3 -6 10
2
Output:
-8 0 -6 -6
Explanation:
First negative integer for each window of size k
{-8, 2} = -8
{2, 3} = 0 (does not contain a negative integer)
{3, -6} = -6
{-6, 10} = -6




 */