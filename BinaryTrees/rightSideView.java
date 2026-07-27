package BinaryTrees;

import java.util.ArrayList;
import java.util.List;


public class rightSideView {
    public static List<Integer> RightSideView(Node root) {
        List<Integer> ans = new ArrayList<>();
        rightview(root,0,ans);
        return ans;
    }
    public static void rightview(Node root,int lvl,List<Integer> ans){
        if(root==null)return;
        if(ans.size()==lvl)ans.add(root.data);
        rightview(root.right,lvl+1,ans);
        rightview(root.left,lvl+1,ans);
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(5);
        root.right.right = new Node(4);
        List<Integer> ans = RightSideView(root);
        System.out.println(ans);
    }   
}
