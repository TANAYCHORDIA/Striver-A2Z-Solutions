package BinaryTrees;
import java.util.*;
public class postOrderTraversal{
    static List<Integer> ans = new ArrayList<>();
    public static List<Integer> postordertraversal(Node root) {
        postOrder(root);
        return ans;
    }
    public static void postOrder(Node root){
        if(root==null)return;
        postOrder(root.left);
        postOrder(root.right);
        ans.add(root.data);
    }
    public static void main(String[] args) {
         Node root = new Node(1);
        root.right = new Node(2);
        root.right.left = new Node(3);
        List<Integer> result = postordertraversal(root);
        System.out.println(result);
    }
}