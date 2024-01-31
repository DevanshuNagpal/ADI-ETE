import java.util.*;

public class MaximizingJewelryValue {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: Weight limit
        int weightLimit = scanner.nextInt();

        // Output: Maximum value of jewelry that Arjun can carry
        double result = maximizeJewelryValue(weightLimit);
        System.out.println(result);

        scanner.close();
    }

    static double maximizeJewelryValue(int weightLimit) {
        // Jewelry collections
        int[] weights = {10, 20, 30};
        int[] values = {60, 100, 120};

        int n = weights.length;

        // Initialize a 2D array to store the computed values
        double[][] dp = new double[n + 1][weightLimit + 1];

        // Fill the dp array using bottom-up approach
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= weightLimit; w++) {
                if (i == 0 || w == 0) {
                    dp[i][w] = 0;
                } else if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(dp[i - 1][w], values[i - 1] + dp[i - 1][w - weights[i - 1]]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        return dp[n][weightLimit];
    }
}

/* Fractional Knapsack
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

// Class to represent each jewelry item
class Jewelry implements Comparable<Jewelry> {
    int value;
    int weight;
    double valueToWeight;

    // Constructor to initialize the jewelry item
    public Jewelry(int value, int weight) {
        this.value = value;
        this.weight = weight;
        // Calculate the value-to-weight ratio for sorting
        this.valueToWeight = (double) value / weight;
    }

    // Compare method to sort in descending order of value-to-weight ratio
    @Override
    public int compareTo(Jewelry other) {
        return Double.compare(other.valueToWeight, this.valueToWeight);
    }
}

public class FractionalKnapsack {

    // Method to maximize the total value of jewelry within weight limit
    public static double maximizeValue(Jewelry[] jewelry, int weightLimit) {
        // Sort the jewelry items based on value-to-weight ratio
        Arrays.sort(jewelry);

        double totalValue = 0.0;
        int remainingWeight = weightLimit;

        // Iterate through sorted items and fill the knapsack
        for (Jewelry item : jewelry) {
            if (remainingWeight >= item.weight) {
                // Take the whole item
                totalValue += item.value;
                remainingWeight -= item.weight;
            } else {
                // Take a fraction of the item to fill the remaining space
                totalValue += (item.valueToWeight * remainingWeight);
                break; // The knapsack is full
            }
        }

        return totalValue;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the weight limit
        int weightLimit = scanner.nextInt();

        // Define the jewelry items
        Jewelry[] jewelry = {
                new Jewelry(60, 10),
                new Jewelry(100, 20),
                new Jewelry(120, 30)
        };

        // Output the maximum value of jewelry Arjun can carry
        System.out.println(maximizeValue(jewelry, weightLimit));

        scanner.close();
    }
}

*/
/*
Question 12: Maximizing Jewelry Value

Problem Statement: In a small village renowned for its skilled artisans, Arjun stands out as a master jeweler. His exquisite collections of necklaces, bracelets, and earrings have always been the talk of the town. As the village fair approaches, Arjun plans to exhibit his three most prized collections: a collection of elegant necklaces valued at 60 gold coins and weighing 10 kilograms in total, a set of exquisite bracelets worth 100 gold coins with a collective weight of 20 kilograms, and a range of delicate earrings priced at 120 gold coins, weighing a total of 30 kilograms.

However, Arjun faces a unique challenge. His carriage, pulled by his trusty horse, has a variable weight limit, which  is equal to input weight. Arjun knew he had to choose wisely to maximize the value of the jewelry he could transport. He pondered over how he could maximize the profit while adhering to the weight constraint.
Your task is to help Arjun decide how to carry the jewelry. You can suggest taking a full item or a fraction of it, keeping in mind the weight limit. The objective is to maximize the total value of the jewelry that Arjun can carry to the fair.

Input format
Integer: Only integer. DO NOT INPUT string, floating point numbers or any other data type.

Output format
Double: Print the required answer

Example
Sample Input 1
50

Sample Output 2
240.0

Sample Input 2
75

Sample Output 2
280.0

 */
