package BinaryTrees;

import java.util.*;

public class levelOrder {
    public static List<List<Integer>> levelOrderTraversal(Node root) {
        List<List<Integer>> ans  = new ArrayList<>();
        if(root==null)return ans;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            List<Integer> subList = new ArrayList<>();
            int length = q.size();
            for(int i=0;i<length;i++){
                if(q.peek().left!=null)q.offer(q.peek().left);
                if(q.peek().right!=null)q.offer(q.peek().right);
                subList.add(q.poll().data);
            }
            ans.add(subList);
        }
        return ans;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        List<List<Integer>> ans = levelOrder.levelOrderTraversal(root);
        System.out.println(ans);
    }
}
