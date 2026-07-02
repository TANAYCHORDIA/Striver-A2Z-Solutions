package BinaryTrees;

import java.util.*;

import javax.swing.tree.TreeNode;

public class sameTree{
    static List<Integer> ans1 = new ArrayList<>();
    static List<Integer> ans2 = new ArrayList<>();
    static int cnt = 0;
    public static boolean isSameTreeBrute(Node p, Node q) {
        ans1.clear();
        ans2.clear();
        preOrder(p);
        cnt++;
        preOrder(q);
        cnt = 0;
        return ans1.equals(ans2);
    }
    public static void preOrder(Node root){
        if(cnt==0){
            if(root==null){
                ans1.add(Integer.MIN_VALUE);
                return;
            }
            ans1.add(root.data);
            preOrder(root.left);
            preOrder(root.right);
        }
        else{
            if(root==null){
                ans2.add(Integer.MIN_VALUE);
                return;
            }
            ans2.add(root.data);
            preOrder(root.left);
            preOrder(root.right);
        }
        return;
    }
    public static boolean isSameTreeOptimal(Node p, Node q) {
        if(p==null && q==null)return true;
        if(p==null || q==null)return false;
        if(p.data!=q.data)return false;
        return isSameTreeOptimal(p.left,q.left) && isSameTreeOptimal(p.right,q.right);
    }
    public static void main(String[] args) {
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);
        System.out.println(sameTree.isSameTreeBrute(root1, root2));
        System.out.println(sameTree.isSameTreeOptimal(root1, root2));
    }
}