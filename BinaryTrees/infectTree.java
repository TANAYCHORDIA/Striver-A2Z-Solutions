package BinaryTrees;

import java.util.Stack;

public class infectTree {
    public int amountOfTime(Node root, int start) {
        Stack<Node> track = new Stack<>();
        if(root==null)return 0;
        Node node = Find(root,start,track);
        int ans = KDist(node,0);
        int distance = 1;
        Node temp = node;
        while(!track.isEmpty()){
            Node ancestor = track.pop();
            int can  = distance;
            if(ancestor.left==temp){
               can =  Math.max(can,KDist(ancestor.right,distance+1));
            }
            if(ancestor.right==temp){
               can =  Math.max(can,KDist(ancestor.left,distance+1));
            }
            temp = ancestor;
            ans = Math.max(ans,can);
            distance++;
        }
        return ans;
    }
    public Node Find(Node root, int target, Stack<Node> track){
        if(root==null)return null;
        if(root.data==target)return root;
        track.add(root);
        Node left =  Find(root.left,target,track);
        if(left!=null)return left;
        Node right = Find(root.right,target,track);
        if(right!=null)return right;
        track.pop();
        return null;
    }
    public int KDist(Node node,int cnt){
        if(node==null)return cnt-1;
        int left = KDist(node.left,cnt+1);
        int right = KDist(node.right,cnt+1);
        return Math.max(left,right);
    }
}
