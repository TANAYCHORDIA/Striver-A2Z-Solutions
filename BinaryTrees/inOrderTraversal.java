package BinaryTrees;

import java.util.ArrayList;

public class inOrderTraversal {
   static ArrayList<Integer> ans = new ArrayList<>();
    public static ArrayList<Integer> inOrder(Node root) {
        ans.clear();
        inorder(root);
        return ans;
    }
    public static void inorder(Node root){
        if(root==null)return;
        inorder(root.left);
        ans.add(root.data);
        inorder(root.right);
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.right = new Node(2);
        root.right.left = new Node(3);
        ArrayList<Integer> result = inOrder(root);
        System.out.println(result);
    }
}
