package BinaryTrees;
import java.util.*;
public class iterativePreOrder{
    public static List<Integer> iterativePreorder(Node root){
        List<Integer> ans = new ArrayList<>();
        if(root==null)return ans;
        Stack<Node> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            root = st.pop();
            ans.add(root.data);
            if(root.right!=null){
                st.push(root.right);
            }
            if(root.left!=null){
                st.push(root.left);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        List<Integer> result = iterativePreorder(root);
        System.out.println(result);
    }
}