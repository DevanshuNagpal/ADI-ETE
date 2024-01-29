import java.util.*;

public class InorderSuccesor {
    class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    Node root;

    InorderSuccesor() {
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

    Node inorderSuccessor(Node root, Node x) {
        if (x.right != null) {
            return findMin(x.right);
        }

        Node successor = null;
        while (root != null) {
            if (x.data < root.data) {
                successor = root;
                root = root.left;
            } else if (x.data > root.data) {
                root = root.right;
            } else {
                break;
            }
        }

        return successor;
    }

    Node findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public static void main(String args[]) {
        InorderSuccesor tree = new InorderSuccesor();
        Scanner scanner = new Scanner(System.in);

        int numNodes = scanner.nextInt();

        for (int i = 0; i < numNodes; i++) {
            int value = scanner.nextInt();
            tree.insert(value);
        }

        int referenceValue = scanner.nextInt();
        Node x = tree.findNode(tree.root, referenceValue);

        Node result = tree.inorderSuccessor(tree.root, x);
        if (result != null)
            System.out.println(result.data);
        else
            System.out.println("No inorder successor found");

        scanner.close();
    }

    Node findNode(Node root, int value) {
        if (root == null || root.data == value)
            return root;

        if (value < root.data)
            return findNode(root.left, value);
        else
            return findNode(root.right, value);
    }
}
/*
Question 14: Inorder Successor in a BST

Problem Statement : Given a Binary Search Tree (BST) and a reference to a Node x in the BST, write a Java program to find the Inorder Successor of the given node in the BST.

Input Format
The input begins with an integer n representing the number of nodes in the BST. This is followed by n integers denoting the values of the nodes in the BST. Then, an integer ref is provided as the value of the reference node x.

Output Format
Print the value of the Inorder Successor node's data or "No inorder successor found" if there's no successor.

Constraints
1 ≤ Number of nodes ≤ 10^5
Values of nodes are unique integers within the range [-10^5, 10^5].

Example
Sample Input 1
5
50 30 70 20 40
30

Sample Output 1
40

Sample Input 2
6
40 20 60 10 30 50
30

Sample Output 2
40



Default Code

import java.util.*;

class Main {

    class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    Node root;

    Main() {
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

    Node inorderSuccessor(Node root, Node x) {
      // Enter your Code here
    }

    public static void main(String args[]) {
        Main tree = new Main();
        Scanner scanner = new Scanner(System.in);

        int numNodes = scanner.nextInt();

        for (int i = 0; i < numNodes; i++) {
            int value = scanner.nextInt();
            tree.insert(value);
        }

        int referenceValue = scanner.nextInt();
        Node x = tree.findNode(tree.root, referenceValue);

        Node result = tree.inorderSuccessor(tree.root, x);
        if (result != null)
            System.out.println(result.data);
        else
            System.out.println("No inorder successor found");

        scanner.close();
    }

    Node findNode(Node root, int value) {
        if (root == null || root.data == value)
            return root;

        if (value < root.data)
            return findNode(root.left, value);
        else
            return findNode(root.right, value);
    }
}
 */