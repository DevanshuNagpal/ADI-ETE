import java.util.Scanner;
public class SingleElementInSortedArray {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]= sc.nextInt();
        }
        int ans=0;
        for(int i=0;i<n;i++){
            ans=ans ^ arr[i];
        }
        System.out.println(ans);
    }
}
/*
Question 9:  Find a single element appearing once in a sorted array
 Problem Statement: Input a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once. Print the single element that appears only once.
 Input Format
Input space-separated integers representing the values of the sorted array. Repeat only a single element in the sorted array.
Output Format
Print the element appearing once in the sorted array.
Constraints
Your solution must run in O(log n) time and O(1) space.
1 <= array.length <= 10^5
0 <= array[i] <= 10^5

 Sample Input 1
1 1 2 2 3 4 4
Sample Output 1
3
Sample Input 2
1 1 2 3 3 4 4 8 8
Sample Output 2
2
 */
