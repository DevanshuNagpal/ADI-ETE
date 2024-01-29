import java.util.*;
public class LeadersAndBricks {
    public static int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq =  new PriorityQueue<>();
        for(int i =0;i<heights.length - 1;i++){
            int diff = heights[i+1] - heights[i];
            if(diff > 0){
                pq.offer(diff);
                if(pq.size() > ladders){
                    bricks -= pq.poll();
                }
                if(bricks < 0){
                    return i;
                }
            }
        }
        return heights.length - 1;

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: Building Heights
        System.out.println("Enter the building heights (separated by space):");
        String[] heightsInput = scanner.nextLine().split(" ");
        int[] heights = new int[heightsInput.length];
        for (int i = 0; i < heightsInput.length; i++) {
            heights[i] = Integer.parseInt(heightsInput[i]);
        }

        // Input: Number of Bricks
        System.out.println("Enter the number of bricks:");
        int bricks = scanner.nextInt();

        // Input: Number of Ladders
        System.out.println("Enter the number of ladders:");
        int ladders = scanner.nextInt();

        // Output: Furthest Building Index
        int result = furthestBuilding(heights, bricks, ladders);
        System.out.println("Furthest Building Index: " + result);
    }
}

/*
You are given an integer array “heights” representing the heights of buildings, some bricks, and some ladders. You start your journey from building 0 and move to the next building by possibly using bricks or ladders. While moving from building i to building i+1 (0-indexed), If the current building's height is greater than or equal to the next building's height, you do not need a ladder or bricks. If the current building's height is less than the next building's height, you can either use one ladder or (h[i+1] - h[i]) bricks. If the number of bricks is less than the difference in the two building heights then you cannot move to the next building. Return the furthest building index (starting from the 0-indexed array) you can reach if you use the given ladders and bricks optimally.

Note: You can use “PriorityQueue” in java.
Input Format
Integer array
Integer // Number of Bricks
Integer // Number of Ladders
Output Format
Integer // Furthest Building Index
Constraints
1 <= heights.length <= 10^5
1 <= heights[i] <= 10^6
0 <= bricks <= 10^9
0 <= ladders <= heights.length
Example
Sample Input 1
4 2 7 6 9 14 12      // Integer array without brackets and separated by space
5                            // Number of Bricks
1                           // Number of Ladders
Sample Output 1
4                     // Furthest Building Index
Sample Input 2
14 3 19 3       // Integer array without brackets and separated by space
14                 // Number of Bricks
0                  // Number of Ladders
Sample Output 2
1
Sample test case Explanation
In the first test case, starting at building 0, you can follow these steps:
- Go to building 1 without using ladders or bricks since 4 >= 2.
- Go to building 2 using 5 bricks. You must use either bricks or ladders because 2 < 7.
- Go to building 3 without using ladders or bricks since 7 >= 6.
- Go to building 4 using your only ladder. You must use ladders because 6 < 9 and you have 0 bricks left.
It is impossible to go beyond building 4 because you do not have any more bricks or ladders.
In the second test case starting at building 0, you can follow these steps:
- Go to building 1 without using ladders or bricks since 14 >= 3.
It is impossible to go beyond building 1 because you do not have any enough bricks or ladders.
 */
