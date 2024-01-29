import com.sun.source.tree.Tree;

import java.sql.SQLOutput;
import java.util.Scanner;

public class LowestCommonAncestor {
    static class TreeNode{
        int val;
        TreeNode left,right;
        public TreeNode(int val){
            this.val = val;
            this.left = this.right = null;
        }
    }
    public static TreeNode findLowestCommonAncestor(TreeNode root,TreeNode p, TreeNode q){
        if(root == null){
            return null;

        }
        if(p.val < root.val && q.val < root.val){
            return findLowestCommonAncestor(root.left,p,q);
        }
        else if(p.val > root.val && q.val > root.val){
            return findLowestCommonAncestor(root.right , p,q);

        }else{
            //current root is the lowest common ancestor
            return root;
        }
    }
    //method to buil a bst from an array of values
    public static TreeNode buildBST(){
        Scanner scanner = new Scanner(System.in);
        TreeNode root = null;
        System.out.println("Enter the values for the bst separated by space:");
        String[] valuesInput = scanner.nextLine().split(" ");
        int[] values = new int[valuesInput.length];

        for(int i =0;i< valuesInput.length ; i++){
            values[i] = Integer.parseInt(valuesInput[i]);
        }
        for(int value : values){
            root = insert(root,value);
        }

        for(int value :  values){
            root = insert(root,value);
        }
        return root;
    }
    //Helper method to insert a value into a BST
    private static TreeNode insert(TreeNode root , int value){
        if(root == null){
            return new TreeNode(value);
        }
        if(value < root.val){
            root.left  = insert(root.left,value);
        } else if (value > root.val) {
            root.right = insert(root.right,value);
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = buildBST();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the value of node P:");
        int pValue = scanner.nextInt();
        System.out.println("Enter the value of node Q:");
        int qValue = scanner.nextInt();
//        int[] values = {6,2,8,0,4,7,9,3,5};
//        int pValue = 2;
//        int qValue = 8;

        TreeNode p = new TreeNode(pValue);
        TreeNode q = new TreeNode(qValue);

        TreeNode result = findLowestCommonAncestor(root,p,q);
        System.out.println(result.val);
    }
}
/*
Problem Statement

Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.
According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

Constraints:
    • The number of nodes in the tree is in the range [2, 105].
    • -109 <= Node.val <= 109
    • All Node.val are unique.
    • p != q
    • p and q will exist in the BST.

Input Format
First Line: An integer array separated by space
Second Line: An integer (value of P)
Third line: An integer (value of q)
Output Format
An Integer.
Example
Sample Input 1
6 2 8 0 4 7 9 3 5     // (Integer Array)
2                               //  (Value of P)
8                 // value of q
Sample Output 1
6
 */