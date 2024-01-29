import  java.util.*;
public class OverlappingIntervals {
    static int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        // Sort intervals by end time
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));

        int count = 1;
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {
                // Non-overlapping interval found
                count++;
                end = intervals[i][1];
            }
        }

        // Minimum number of intervals to be removed is the total intervals minus non-overlapping intervals
        return intervals.length - count;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[][] intervals = new int[n][2];

        for (int i = 0; i < n; i++) {
            intervals[i][0] = scanner.nextInt();
            intervals[i][1] = scanner.nextInt();
        }

        System.out.println(eraseOverlapIntervals(intervals));

        scanner.close();
    }
}
/*
Question 7:  Non-overlapping Intervals
Problem Statement : Given an array of intervals, intervals where intervals[i] = [start, end], return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

Input Format
Integer: The input begins with an integer N denoting the number of intervals. This is followed by N pairs of integers representing the start and end points of intervals.

Output Format
Print an integer representing the minimum number of intervals to be removed.
Constraints :
    1 ≤ N ≤ 1000
    -10^6 ≤ Start and End points ≤ 10^6

Example
Sample Input 1
4
1 2
2 3
3 4
1 3
Sample Output 1
1

Sample Input 2
2
1 2
2 3

Sample Output 2
0

Default Code
import java.util.*;

class Main {
    static int eraseOverlapIntervals(int[][] intervals) {
        // Enter your code here
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[][] intervals = new int[n][2];

        for (int i = 0; i < n; i++) {
            intervals[i][0] = scanner.nextInt();
            intervals[i][1] = scanner.nextInt();
        }

        System.out.println(eraseOverlapIntervals(intervals));

        scanner.close();
    }
}
 */