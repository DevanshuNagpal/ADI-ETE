import java.util.Scanner;

class TreeNode{
    int data;
    TreeNode left,right;
    public TreeNode(int data){
        this.data = data;
        this.left = this.right = null;
    }
}

class BST{
    private TreeNode root;
    public BST(){
        this.root = null;
    }

    public TreeNode insert(TreeNode root, int data){
        if(root == null){
            return new TreeNode(data);

        }
        if(data < root.data){
            root.left = insert(root.left,data);
        }
        else if( data > root.data){
            root.right = insert(root.right,data);
        }
        return root;
    }

    TreeNode deleteLeafNodes(TreeNode root){
        if(root == null){
            return null;
        }
        if(root.left == null && root.right == null){
//            This is leaf node
            return null;
        }
//        recursively delete leaf nodes in left and right subtree
        root.left = deleteLeafNodes(root.left);
        root.right = deleteLeafNodes(root.right);

        return root;
    }

    public void postOrderTraversal(TreeNode root){
        if(root != null){
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.print(root.data + " ");
        }
    }
    public TreeNode getRoot(){
        return root;
    }
    public void insert(int data){
        root = insert(root,data);
    }
}
class DeleteLeaf{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] values = new int[n];
        for(int i =0;i<n;i++){
            values[i] = in.nextInt();
        }

//        Create a BST and insert values
        BST bst = new BST();
        for(int value: values){
            bst.insert(value);
        }
//        delete leaf nodes
        bst.deleteLeafNodes(bst.getRoot());

//        Print post order
        bst.postOrderTraversal(bst.getRoot());
    }
}


/*
Problem Statement
Write a Java code to perform the TreeNode Deletion of the Leaf Nodes form the BST. User enters the value of the nodes.
Your task is to find the Left-Most Leaf Child & Right-Most Leaf child in the BST, delete them, and then print the POST Order traversal of that given Tree.

Input Format
An array of integers (7 values)
Output Format
Post-order traversal of tree after applying deletion operation
Note: Integer array length must be equal to 7.
Example
Sample Input 1
10 5 3 7 20 18 25
Sample Output 1
5 20 10

 */