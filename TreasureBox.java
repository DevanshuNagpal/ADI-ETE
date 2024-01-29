import java.util.*;
class Node {
    int val;
    int height;
    Node left,right;
    Node(int value){
        val = value;
        height = 1;
        left = right = null;
    }
}

class AVLTree{
    Node root;

    int height(Node node){
        if(node == null) return 0;
        return node.height;
    }

    int getBalance(Node node){
        if(node == null) return 0;
        return height(node.left) - height(node.right);
    }
    Node rightRotate(Node p){
        Node c = p.left;
        Node t = c.right;

        c.right = p;
        p.left = t;

        p.height = Math.max(height(p.left) , height(p.right) +1);
        c.height = Math.max(height(c.left),height(c.right) +1);

        return c;
    }

    Node leftRotate(Node c){
        Node p = c.right;
        Node t = p.left;

        p.left = c;
        c.right = t;

        c.height = Math.max(height(c.left) , height(c.right) + 1);
        p.height = Math.max(height(p.left),height(p.right) +1);

        return p;
    }

    Node insert(Node node,int val){
        if(node == null){
            return new Node(val);
        }
        if(val < node.val){
            node.left = insert(node.left,val);
        }
        else if(val > node.val){
            node.right = insert(node.right,val);

        }
        else return node;
        node.height = 1 + Math.max(height(node.left),height(node.right));


        int balance = getBalance(node);
        //left left case
        if(balance > 1 && val < node.left.val){
            return rightRotate(node);

        }
        //right right case
        if(balance < -1 && val > node.right.val){
            return leftRotate(node);
        }
//        left right case
        if(balance > 1 && val > node.left.val){
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
//        right left case
        if(balance < -1 && val < node.right.val){
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    void preOrder(Node root){
        if(root != null){
            System.out.print(root.val + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }
}

public class TreasureBox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] values = new int[n];

        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
        }

        AVLTree avlTree = new AVLTree();

        for (int value : values) {
            avlTree.root = avlTree.insert(avlTree.root, value);
        }

        avlTree.preOrder(avlTree.root);
    }
}




/*
Question 2: Password of the treasure box

Problem Statement

In a whimsical forest, a special tree called the AVL Tree was home to magical creatures like a wise owl, a swift squirrel, a graceful deer, a playful rabbit, and a majestic unicorn. Picture yourself strolling through this enchanted place and observing these creatures joining the tree. Now, I'd like you to share the order in which you encounter them, mentioning their unique energies, just like the magic they bring. Let me know the sequence you witness as you explore the forest – specifically, I'm interested in the output of the AVL Tree in preorder traversal after all the magical creatures have become a part of it.
Input Format
The input begins with an integer N denoting the number of nodes to be inserted into the AVL tree. This is followed by N integers representing the values of the nodes to be inserted.
Output Format
Print the preorder traversal of the created AVL Tree.
Constraints :
1 ≤ N ≤ 1000
Nodes' values are integers

Example
Input:
5                                  // number of nodes
30 20 40 10 50          // values of nodes to be inserted

Output:
30 20 10 40 50

Explanation:
For the given input, nodes 30 20 40 10 50 are inserted into the AVL tree, and the preorder traversal of the created AVL tree is 30 20 10 40 50.

 */