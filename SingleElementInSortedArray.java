import java.util.Scanner;

public class SingleElementInSortedArray {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input sorted array
        String[] inputArray = scanner.nextLine().split(" ");
        int[] nums = new int[inputArray.length];
        for (int i = 0; i < inputArray.length; i++) {
            nums[i] = Integer.parseInt(inputArray[i]);
        }

        // Find the single element
        int result = findSingleElement(nums);
        System.out.println(result);

        scanner.close();
    }

    static int findSingleElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // Check if the single element is on the left or right side
            if (mid % 2 == 1) {
                mid--; // Ensure we have an even index
            }

            // If the elements at mid and mid+1 are not equal, move left
            if (nums[mid] != nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 2;
            }
        }

        return nums[left];
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