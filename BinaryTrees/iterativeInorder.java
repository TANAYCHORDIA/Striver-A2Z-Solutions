package BinaryTrees;
import java.util.*;
public class iterativeInorder {
    public static List<Integer> inorderTraversal(Node root){
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Stack<Node> st = new Stack<>();
        Node temp = root;
        while(true){
            if(temp!=null){
                st.push(temp);
                temp = temp.left;
            }
            else{
                if(st.isEmpty()){
                    break;
                }
                temp = st.pop();
                ans.add(temp.data);
                temp = temp.right;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.right = new Node(2);
        root.right.left = new Node(3);
        List<Integer> ans = inorderTraversal(root);
        System.out.println(ans);
    }
}
