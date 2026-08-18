package BinaryTrees;
import java.util.*;
public class morrisInorder {
    public ArrayList<Integer> MorrisInorder(Node root){
        ArrayList<Integer> ans = new ArrayList<>();
        Node cur = root;
        while(cur!=null){
            if(cur.left==null){
                ans.add(cur.data);
                cur = cur.right;
            }
            else{
                Node prev = cur.left;
                while(prev.right!=null && prev.right!=cur){
                    prev  = prev.right;
                }
                if(prev.right==null){
                    prev.right = cur;
                    cur = cur.left;
                }
                else{
                    prev.right = null;
                    ans.add(cur.data);
                    cur = cur.right;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(5);
        morrisInorder obj = new morrisInorder();
        ArrayList<Integer> ans = obj.MorrisInorder(root);
        System.out.println(ans);
    }
}
