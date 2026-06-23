package BinaryTrees;

import java.util.ArrayList;
import java.util.List;
public class preorderTraversal{
    static List<Integer> ans = new ArrayList<>();
    public static List<Integer> preordertraversal(Node root) {
        preorder(root);
        return ans;
    }
    public  static void preorder(Node root){
        if(root == null)return;
        ans.add(root.data);
        preorder(root.left);
        preorder(root.right);
    }
public static void main(String[] args) {
        Node root = new Node(1);
        root.right = new Node(2);
        root.right.left = new Node(3);
        List<Integer> result = preordertraversal(root);
        System.out.println(result);
    }
}