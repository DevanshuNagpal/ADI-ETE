import java.util.*;

public class TopViewBST {
    static class Node {
        int data;
        int depth;
        Node left, right;

        Node(int value, int d) {
            data = value;
            depth = d;
            left = right = null;
        }
    }

    Node root;

    TopViewBST() {
        root = null;
    }

    void insert(int value, int depth) {
        root = insertRec(root, value, depth);
    }

    Node insertRec(Node root, int value, int depth) {
        if (root == null)
            return new Node(value, depth);

        if (value < root.data)
            root.left = insertRec(root.left, value, depth + 1);
        else if (value > root.data)
            root.right = insertRec(root.right, value, depth + 1);

        return root;
    }

    void topView() {
        TreeMap<Integer, Node> map = new TreeMap<>();

        topViewUtil(root, 0, 0, map);

        for (Node node : map.values()) {
            System.out.print(node.data + " ");
        }
    }

    void topViewUtil(Node node, int horizontalDistance, int depth, TreeMap<Integer, Node> map) {
        if (node == null)
            return;

        if (!map.containsKey(horizontalDistance) || depth < map.get(horizontalDistance).depth) {
            map.put(horizontalDistance, new Node(node.data, depth));
        }

        topViewUtil(node.left, horizontalDistance - 1, depth + 1, map);
        topViewUtil(node.right, horizontalDistance + 1, depth + 1, map);
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        TopViewBST tree = new TopViewBST();
        for (int i = 0; i < n; i++) {
            int value = scanner.nextInt();
            int depth = scanner.nextInt();
            tree.insert(value, depth);
        }

        tree.topView();

        scanner.close();
    }
}

/*
Question 17: Top View of BST

Problem Statement : Given a Binary Search Tree (BST), find and print the top view(Left to right) of the BST.

Input Format
The input begins with an integer N denoting the number of nodes in the BST. This is followed by N pairs of integers representing the values and their respective depths of the nodes in the BST.

Output Format
Print the values of the nodes in the top view of the BST in a space-separated manner.

Constraints
1 ≤ N ≤ 1000
-10^3 ≤ Node values ≤ 10^3

Example
Sample Input 1
7
50 0
30 1
70 1
20 2
40 2
60 2
80 2

Sample Output 1
20 30 50 70 80

Sample Input 2
3
50 0
30 1
70 1
Sample Output 2
30 50 70

Default Code

import java.util.*;

class Node {
    int data;
    int depth;
    Node left, right;


    Node(int value, int d) {
        data = value;
        depth = d;
        left = right = null;
    }
}

class Main {
    Node root;


    Main() {
        root = null;
    }


    void insert(int value, int depth) {
        root = insertRec(root, value, depth);
    }


    Node insertRec(Node root, int value, int depth) {
        if (root == null)
            return new Node(value, depth);

        if (value < root.data)
            root.left = insertRec(root.left, value, depth + 1);
        else if (value > root.data)
            root.right = insertRec(root.right, value, depth + 1);

        return root;
    }


    void topView() {
        // Enter your code here
    }


    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);


        int n = scanner.nextInt();

        Main tree = new Main();
        for (int i = 0; i < n; i++) {
            int value = scanner.nextInt();
            int depth = scanner.nextInt();
            tree.insert(value, depth);
        }


        tree.topView();

        scanner.close();
    }
}


 */