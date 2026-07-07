package BinaryTrees;

import java.util.ArrayList;
import java.util.Stack;

public class boundryTraversal {
    public static ArrayList<Integer> boundaryTraversal(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(root==null)return ans;
        ans.add(root.data);
        if(isLeaf(root)==true)return ans;
        LeftBoundry(root,ans);
        Leaf(root,ans);
        RightBoundary(root,ans);
        return ans;
        
    }
    public static void LeftBoundry(Node root, ArrayList<Integer> ans){
        Node curr= root.left;
        while(curr!=null){
            if(isLeaf(curr)==false)ans.add(curr.data);
            if(curr.left!=null)curr = curr.left;
            else curr = curr.right;
        }
    }
    public static void Leaf(Node root, ArrayList<Integer> ans){
        if(root==null)return;
        Leaf(root.left,ans);
        if(isLeaf(root))ans.add(root.data);
        Leaf(root.right,ans);
    }
    public static  void RightBoundary(Node root,ArrayList<Integer> ans){
        Stack<Node> st = new Stack<>();
        Node curr = root.right;
        while(curr!=null){
            if(isLeaf(curr)==false)st.add(curr);
            if(curr.right!=null)curr=curr.right;
            else curr=curr.left;
        }
        while(!st.isEmpty()) ans.add(st.pop().data);
    }
    public static boolean isLeaf(Node root){
        if(root.left == null && root.right==null)return true;
        return false;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        ArrayList<Integer> ans = boundaryTraversal(root);
        System.out.println(ans);
    }
}
