package BinaryTrees;

import java.util.ArrayList;

import javax.swing.tree.TreeNode;

public class symmetric{
    public boolean isSymmetricBrute(Node root) {
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();
        if(root==null)return true;
        preOrderLeft(root.left,left);
        preOrderRight(root.right,right);
        return left.equals(right);
    }
    void preOrderLeft(Node node,ArrayList<Integer>left){
        if(node==null){
            left.add(null);
            return;
        }
        left.add(node.data);
        preOrderLeft(node.left,left);
        preOrderLeft(node.right,left);
    }
    void preOrderRight(Node node,ArrayList<Integer>right){
        if(node==null){
            right.add(null);
            return;
        }
        right.add(node.data);
        preOrderRight(node.right,right);
        preOrderRight(node.left,right);
    }
    public static boolean isSymmetric(Node root) {
        return root==null|| Symmetric(root.left,root.right);
    }
    public static boolean Symmetric(Node left,Node right){
        if(left==null || right == null)return left==right;
        if(left.data!=right.data)return false;
        return Symmetric(left.left,right.right) && Symmetric(left.right,right.left);
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(4);
        root.right.right = new Node(3);
        System.out.println(isSymmetric(root));
    }
}