package BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;

public class maxDepth {
    public static int MaxDepth(Node root) {
        int count = 0;
        if(root==null)return count;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int length = q.size();
            for(int i=0;i<length;i++){
                if(q.peek().left!=null)q.offer(q.peek().left);
                if(q.peek().right!=null)q.offer(q.peek().right);
                q.poll();
            }
            count++;
        }
        return count;
    }
    public static int maxDepthOptimal(Node root) {
        if(root==null)return 0;
        int r = maxDepthOptimal(root.right);
        int l = maxDepthOptimal(root.left);
        return 1+ Math.max(l,r); 
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        int ans = MaxDepth(root);
        int ans1 = maxDepthOptimal(root);
        System.out.println(ans);
        System.out.println(ans1);
    }
}
