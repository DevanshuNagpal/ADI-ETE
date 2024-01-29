import  java.util.*;

public class LeftViewBST {
    class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    Node root;
    int maxLevel = 0;  // Declaration of maxLevel variable

    LeftViewBST() {
        root = null;
    }

    void insert(int key) {
        root = insertRec(root, key);
    }

    Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.data)
            root.left = insertRec(root.left, key);
        else if (key > root.data)
            root.right = insertRec(root.right, key);

        return root;
    }

    void leftView() {
        leftViewUtil(root, 1);
    }

    void leftViewUtil(Node node, int level) {
        if (node == null) {
            return;
        }

        if (level > maxLevel) {
            System.out.print(node.data + " ");
            maxLevel = level;
        }

        leftViewUtil(node.left, level + 1);
        leftViewUtil(node.right, level + 1);
    }

    public static void main(String args[]) {
        LeftViewBST tree = new LeftViewBST();
        Scanner scanner = new Scanner(System.in);

        int numNodes = scanner.nextInt();

        for (int i = 0; i < numNodes; i++) {
            int value = scanner.nextInt();
            tree.insert(value);
        }

        tree.leftView();

        scanner.close();
    }
}
/*
Question 8:  Left View of Binary Search Tree (BST)
Problem Statement : Given a Binary Search Tree (BST), find the left view of the tree, which contains all the nodes visible from the left side. The left view of a BST is the set of nodes visible when the tree is viewed from the left-hand side.
Input Format
The input begins with an integer n representing the number of nodes in the BST. This is followed by n integers denoting the values of the nodes in the BST.

Output Format
Print the values of nodes that are visible from the left side of the BST.

Constraints
 1 ≤ Number of nodes ≤ 10^4
 Values of nodes are unique integers within the range [-10^4, 10^4].

Example
Sample Input 1
7
20 9 25 5 12 22 30
Sample Output 1
20 9 5

Sample Input 2
6
40 20 60 10 30 50

Sample Output 2
40 20 10

Default Code

import java.util.*;

class LeftViewBST {
    class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    Node root;

    LeftViewBST() {
        root = null;
    }

    void insert(int key) {
        root = insertRec(root, key);
    }

    Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.data)
            root.left = insertRec(root.left, key);
        else if (key > root.data)
            root.right = insertRec(root.right, key);

        return root;
    }

    void leftView() {
        leftViewUtil(root, 1);
    }

    void leftViewUtil(Node node, int level) {
       // Write code here
    }

    int maxLevel = 0;

    public static void LeftViewBST(String args[]) {
        LeftViewBST tree = new LeftViewBST();
        Scanner scanner = new Scanner(System.in);

        int numNodes = scanner.nextInt();

        for (int i = 0; i < numNodes; i++) {
            int value = scanner.nextInt();
            tree.insert(value);
        }

        tree.leftView();

        scanner.close();
    }
}
 */