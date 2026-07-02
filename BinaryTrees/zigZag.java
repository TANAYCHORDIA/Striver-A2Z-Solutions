package BinaryTrees;

import java.util.*;
public class zigZag {
    public static List<List<Integer>> zigzagLevelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        int cnt = 0;
        if(root==null)return ans;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        cnt++;
        while(!q.isEmpty()){
            List<Integer> SubList = new ArrayList<>();
            int length = q.size();
            for(int i=0;i<length;i++){
                if(q.peek().left!=null)q.offer(q.peek().left);
                if(q.peek().right!=null)q.offer(q.peek().right);
                SubList.add(q.poll().data);
            }
            if(cnt%2==0)ans.add(SubList.reversed());
            else ans.add(SubList);
            cnt++;
        }
        return ans;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        List<List<Integer>> ans = zigzagLevelOrder(root);
        System.out.println(ans);
    }
}
