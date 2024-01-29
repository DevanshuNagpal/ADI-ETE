import  java.util.*;

public class PostOrderTraversal {
    class Node {
        int data;
        Node left, right;

        Node(int value) {
            data = value;
            left = right = null;
        }
    }
    Node root;

    PostOrderTraversal() {
        root = null;
    }

    void insert(int value) {
        root = insertRec(root, value);
    }

    Node insertRec(Node root, int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }

        if (value < root.data)
            root.left = insertRec(root.left, value);
        else if (value > root.data)
            root.right = insertRec(root.right, value);

        return root;
    }

    void postorderTraversal(Node node) {
        if (node != null) {
            postorderTraversal(node.left);
            postorderTraversal(node.right);
            System.out.print(node.data + " ");
        }
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        PostOrderTraversal tree = new PostOrderTraversal();
        for (int i = 0; i < n; i++) {
            int value = scanner.nextInt();
            tree.insert(value);
        }

        tree.postorderTraversal(tree.root);

        scanner.close();
    }
}
/*
Question 10: Postorder Traversal of Binary Search Tree
Problem Statement : Given a Binary Search Tree (BST), the task is to perform a postorder traversal of the tree and print the nodes' values. Also implement a method for performing the insertion operation into the BST

Input Format
The input begins with an integer N denoting the number of nodes in the BST. This is followed by N integers representing the values to be inserted into the BST.

Output Format
Print the nodes' values in postorder traversal separated by spaces.

Constraints :
    1 ≤ N ≤ 1000
    Nodes' values are integers

Example
Sample Input 1
7
50 30 70 20 40 60 80

Sample Output 1
20 40 30 60 80 70 50
Sample Input 2
4
8 4 12 6
Sample Output 2
6 4 12 8

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

class PostOrderTraversal {
    Node root;

    PostOrderTraversal() {
        root = null;
    }

    void insert(int value) {
        // Enter Code here
    }



    void postorderTraversal(Node node) {
        // Enter Code here
    }

    public static void PostOrderTraversal(String args[]) {
        Scanner scanner = new Scanner(System.in);


        int n = scanner.nextInt();

        PostOrderTraversal tree = new PostOrderTraversal();
        for (int i = 0; i < n; i++) {
            int value = scanner.nextInt();
            tree.insert(value);
        }



        scanner.close();
    }
}
 */