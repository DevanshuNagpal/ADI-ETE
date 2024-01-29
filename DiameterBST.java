import java.util.Scanner;

class DiameterBST {
    static class Node {
        int data;
        Node left, right;

        Node(int value) {
            data = value;
            left = right = null;
        }
    }

    Node root;

    DiameterBST() {
        root = null;
    }

    void insert(int value) {
        root = insertRec(root, value);
    }

    Node insertRec(Node root, int value) {
        if (root == null)
            return new Node(value);

        if (value < root.data)
            root.left = insertRec(root.left, value);
        else if (value > root.data)
            root.right = insertRec(root.right, value);

        return root;
    }

    int height(Node node) {
        if (node == null)
            return 0;

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }

    int diameter(Node root) {
        if (root == null)
            return 0;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        int leftDiameter = diameter(root.left);
        int rightDiameter = diameter(root.right);

        return Math.max(leftHeight + rightHeight + 1, Math.max(leftDiameter, rightDiameter));
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        DiameterBST tree = new DiameterBST();
        for (int i = 0; i < n; i++) {
            int value = scanner.nextInt();
            tree.insert(value);
        }

        System.out.println(tree.diameter(tree.root));

        scanner.close();
    }
}
/*
Dont make main class make DiameterBST Class and work in it  Find Diameter of a Binary Search Tree

Problem Statement : Given a Binary Search Tree (BST), determine its diameter - the length of the longest path between any two nodes in the tree. The path may or may not pass through the root.

Input Format
The input begins with an integer N denoting the number of nodes in the BST. This is followed by N integers representing the values to be inserted into the BST.

Output Format
Print an integer representing the diameter of the BST.

Constraints
1 ≤ N ≤ 1000
Nodes' values are integers


Example
Sample Input 1
7
50 30 70 20 40 60 80

Sample Output 1
5

Sample Input 2
3
50 40 30

Sample Output 2
3

Explanation:
For the given  sample input 1, nodes 50 30 70 20 40 60 80 are inserted into the BST. The diameter of the BST is 6, representing the longest path between nodes in the tree.

Default Code
import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int value) {
        data = value;
        left = right = null;
    }
}

class Main {
    Node root;

    Main() {
        root = null;
    }

    void insert(int value) {
        root = insertRec(root, value);
    }

    Node insertRec(Node root, int value) {
        if (root == null)
            return new Node(value);

        if (value < root.data)
            root.left = insertRec(root.left, value);
        else if (value > root.data)
            root.right = insertRec(root.right, value);

        return root;
    }

    int height(Node node) {
        // Enter code here
    }

    int diameter(Node root) {
        // Enter code here
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        Main tree = new Main();
        for (int i = 0; i < n; i++) {
            int value = scanner.nextInt();
            tree.insert(value);
        }

        System.out.println(tree.diameter(tree.root));

        scanner.close();
    }
}


 */