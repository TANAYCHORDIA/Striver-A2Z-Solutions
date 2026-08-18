package BinaryTrees;

import java.util.ArrayList;

public class morrisPreOrder {
    public ArrayList<Integer> MorrisPreOrder(Node root){
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
                    ans.add(cur.data);
                    cur = cur.left;
                }
                else{
                    prev.right = null;
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
        morrisPreOrder obj = new morrisPreOrder();
        ArrayList<Integer> ans = obj.MorrisPreOrder(root);
        System.out.println(ans);
    }
}
