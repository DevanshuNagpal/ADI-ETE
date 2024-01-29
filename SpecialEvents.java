import java.util.Scanner;

public class SpecialEvents {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: Integer array
        System.out.println("Enter the integer array (separated by space):");
        String[] input = scanner.nextLine().split(" ");
        int[] arr = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        // Output: Count of special elements
        int result = countSpecialElements(arr);
        System.out.println("Count of special elements: " + result);
    }

/*
    public static int countSpecialElements(int[] arr){
        int count = 0;
        //iterate through each element in the array
        for(int i =0;i<arr.length ; i++){
            //calculate the sum of elements at odd and even indexes after removing the current element
            int sumEven = 0,sumOdd = 0;
            for(int j = 0;j<arr.length ; j++){
                if(j!= i){
                    if(j%2 == 0){
                        sumEven += arr[j];
                    }
                    else{
                        sumOdd += arr[j];
                    }
                }
            }
            //check if removing the current element makes array balanced
            if(sumEven == sumOdd)
            {
                count++;
            }
        }
        return count;
    }
*/
/*
    public static int countSpecialElements(int[] arr) {
        int count =0;
        int sumEven = 0 ,sumOdd = 0;
        //calculate the initial sum of elements at odd and even indexes
        for(int i=0;i<arr.length ; i++){
            if(i %2 == 0){
                sumEven += arr[i] ;

            }
            else{
                sumOdd += arr[i];

            }
        }
        //iterate through each element in the array and check if removing it makes the array  balanced
        for(int i =0;i<arr.length ;i++){
            //check if removing the current element makes the array balanced
            if (sumEven - (i % 2 == 0 ? arr[i] : 0) + sumOdd - (i % 2 != 0 ? arr[i] : 0) == sumEven) {
                count++;
            }
            //update the cumulative sum of elements at odd and even indexes
            if(i % 2 == 0){sumEven -= arr[i];
            }
            else {
                sumOdd -= arr[i];
            }
        }
        return count;
    }

 */
    public static int countSpecialElements(int[] arr) {
        int count = 0;
        int sumEven = 0, sumOdd = 0;

        // Arrays to store the cumulative sum of elements at odd and even indexes
        int[] cumSumEven = new int[arr.length];
        int[] cumSumOdd = new int[arr.length];

        // Calculate the initial cumulative sum of elements at odd and even indexes
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                sumEven += arr[i];
            } else {
                sumOdd += arr[i];
            }
            cumSumEven[i] = sumEven;
            cumSumOdd[i] = sumOdd;
        }

        // Iterate through each element in the array and check if removing it makes the array balanced
//        for (int i = 0; i < arr.length; i++) {
//            // Check if removing the current element makes the array balanced
//            if (cumSumEven[i] - (i % 2 == 0 ? arr[i] : 0) + cumSumOdd[i] - (i % 2 != 0 ? arr[i] : 0) == cumSumOdd[i]) {
//                count++;
//            }
//        }
        for (int i = 0; i < arr.length; i++) {
            // Check if removing the current element makes the array balanced
            if (i % 2 == 0) {
                if (cumSumEven[i] - arr[i] + cumSumOdd[i] == cumSumOdd[i]) {
                    count++;
                }
            } else {
                if (cumSumEven[i] + cumSumOdd[i] - arr[i] == cumSumOdd[i]) {
                    count++;
                }
            }
        }

        return count;
    }

}
/*
Given an integer array A of size N. You need to count the number of special elements in the given array. An element is special if the removal of that element makes the array balanced.
The array will be balanced if the sum of the even index element is equal to the sum of the odd index element.

Input Constraints :

1 <= N <= 10^5

1 <= A[i] <= 10^9

Input Format
Only Single Input consists of an integer array A of size N. Integer array consists of integers separated by space.
Output Format
Returns an integer denoting the count of special elements
Example
Sample Input 1
2 1 6 4                    // Single input integer array (Integers separated by space)

Sample Output 1
1                          // Integer denoting count of special elements
Sample Input 2
5 5 2 5 8                  // Single input integer array (Integers separated by space)
Sample Output 2
2
Sample test case Explanation
In the first test case, there are 4 elements in the array and if I remove the element at index 1 i.e., 1 then the remaining 3 elements are 2 6 4 (sum of elements at odd index and the sum of element at even index is equal) so special element count is 1 as after removing any other element the sum is not equal.
In the second test case, there are 5 elements in the array. Taking each one by one each element and checking the sum of elements of odd and even indexes, if the sum is equal then consider that element as a special element otherwise not. After removing element at index zero i.e., 5 check the sum is equal (5+5 = 2+8) so 5 is special element. Similarly for element at array index 1 check the sum is equal (5+5 = 2+8) so 5 is special element. Repeat the above process for all the elements and at last count all the special elements and print in this test case the total number of special elements are 2.

*/
