import java.util.Scanner;

class PathSumBST {
    static class Node {
        int key;
        Node left, right;
    }

    static Node newNode(int item) {
        Node temp = new Node();
        temp.key = item;
        temp.left = temp.right = null;
        return temp;
    }

    static Node insert(Node node, int key) {
        if (node == null)
            return newNode(key);

        if (key < node.key) {
            node.left = insert(node.left, key);
        } else if (key > node.key) {
            node.right = insert(node.right, key);
        }

        return node;
    }

    static boolean hasPathSum(Node root, int targetSum) {
        if (root == null)
            return false;

        if (root.left == null && root.right == null) {
            // Leaf node
            return targetSum == root.key;
        }

        boolean leftPath = hasPathSum(root.left, targetSum - root.key);
        boolean rightPath = hasPathSum(root.right, targetSum - root.key);

        return leftPath || rightPath;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Node root = null;
        while (N != 0) {
            root = insert(root, sc.nextInt());
            N--;
        }
        int targetSum = sc.nextInt();
        System.out.println(hasPathSum(root, targetSum));
    }
}


/*
Question 13: Path Sum of Binary Search Tree

Problem Statement : Given a pre-constructed BST and a target sum, determine if there exists a path from the root to any leaf whose values sum up to the target. You need to only implement the hasPathSum(node, int) method.

Input Format
Integer: Array size, array elements, target sum.  Only the hasPathSum() method is to be implemented

Output Format
Boolean: Return a boolean value:
true, if there exists a path with the given sum
false, otherwise

Constraints
Values of nodes are integers.
The array is not sorted.
Tree nodes are not null.

Example

Sample Input 1
5
1 2 3 4 5
15

Sample Output 1
true

Sample Input 2
7
3 6 1 4 7 2 9
11

Sample Output 2
false


Default Code

import java.io.*;
import java.util.*;

class PathSumBST {

    static class node {
        int key;
        node left, right;
    };

    static node newNode(int item) {
        node temp = new node();
        temp.key = item;
        temp.left = temp.right = null;
        return temp;
    }

    static node insert(node node, int key) {

        if (node == null)
            return newNode(key);

        if (key < node.key) {
            node.left = insert(node.left, key);
        } else if (key > node.key) {
            node.right = insert(node.right, key);
        }

        return node;
    }

    static boolean hasPathSum(node root, int targetSum) {
        // Enter your code here
    }

    public static void PathSumBST(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        node root = null;
        while (N != 0) {
            root = insert(root, sc.nextInt());
            N--;
        }
        int targetSum = sc.nextInt();
        System.out.println(hasPathSum(root, targetSum));
    }
}
 */