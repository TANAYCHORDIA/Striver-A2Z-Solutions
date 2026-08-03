package BinaryTrees;

import java.util.ArrayDeque;
import java.util.Deque;

import javax.swing.tree.TreeNode;

class pair{
    Node node;
    int val;
    pair(Node node,int val){
        this.node = node;
        this.val = val;
    }
}
public class widthOfBinaryTree{
    public static int WidthOfBinaryTree(Node root) {
        if(root==null)return 0;
        Deque<pair> q = new ArrayDeque<>();
        int ans = 1;
        q.offer(new pair(root,0));
        while(!q.isEmpty()){
            ans = Math.max(ans,q.peekLast().val-q.peekFirst().val+1);
            int levelNum = q.size();
            for(int i=0;i<levelNum;i++){
                pair p = q.poll();
                Node temp = p.node;
                int idx = p.val;
                if(temp.left!=null)q.offer(new pair(temp.left,2*idx+1));
                if(temp.right!=null)q.offer(new pair(temp.right,2*idx+2));
                
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(3);
        root.right = new Node(2);
        root.left.left = new Node(5);
        root.left.right = new Node(3);
        root.right.right = new Node(9);
        System.out.println(WidthOfBinaryTree(root));
    }
}