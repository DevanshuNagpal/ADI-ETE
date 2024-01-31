import java.util.*;

class KthLargestInArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); // Length/Size of array
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt(); // Elements of array
        }

        int k = scanner.nextInt(); // Value of K
        int result = findKthLargest(nums, k);

        System.out.println(result);
    }

    static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return minHeap.peek();
    }
    /*
    static int findKthSmallest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        for (int num : nums) {
            maxHeap.add(num);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        return maxHeap.peek();
    }
    */
}
/*
Question 3: Finding the Kth Largest Element in Array
Problem Statement
Given an integer array nums and an integer k, the task is to find and return the kth largest element in the array. It's essential to note that the element in question is the kth largest one in the sorted order, not necessarily the kth distinct element. The challenge is to solve this problem without utilizing sorting algorithms.
Input Format
Length/Size of array : Integer
Elements of array: Integer
Value of K: Integer
Output Format
Kth Largest Element in Array : Integer
Constraints
Do not use any sorting technique.
Example
Sample Input 1
6
3 2 1 5 6 4
2
Sample Output 1
5
Sample Input 2
9
3 2 3 1 2 4 5 5 6
4
 
Sample Output 2
4
Sample test case Explanation
In the first test case, 6 represent array size, 3 2 1 5 6 4 are array elements, then input K that is 2 to find the kth largest element in the array.
In the first test case, 9 represent array size, 3 2 3 1 2 4 5 5 6 are array elements, then input K that is 4 to find the kth largest element in the array.

    */
