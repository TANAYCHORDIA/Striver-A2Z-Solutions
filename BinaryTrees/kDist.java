package BinaryTrees;
import java.util.*;
public class kDist{
     public List<Integer> distanceK(Node root, Node target, int k) {
        List<Integer> ans = new ArrayList<>();
        Stack<Node> track = new Stack<>();
        if(root==null)return ans;
        Node node = Find(root,target,track);
        int cnt = 0;
        KDist(node,cnt,k,ans);
        Node curr = target;
        while(!track.isEmpty()){
            Node ancestor = track.pop();
            cnt++;
            if(ancestor.left==curr){
                if(cnt==k)ans.add(ancestor.data);
                KDist(ancestor.right,cnt+1,k,ans);
            }
            else{
                if(cnt==k)ans.add(ancestor.data);
                KDist(ancestor.left,cnt+1,k,ans);
            }
            curr = ancestor;
        }
        return ans;
    }
    public Node Find(Node root, Node target, Stack<Node> track){
        if(root==null)return null;
        if(root==target)return root;
        track.add(root);
        Node left =  Find(root.left,target,track);
        if(left!=null)return left;
        Node right = Find(root.right,target,track);
        if(right!=null)return right;
        track.pop();
        return null;
    }
    public void KDist(Node node,int cnt, int k, List<Integer> ans){
        if(node==null)return;
        if(k==cnt){
            ans.add(node.data);
            return;
        }
        KDist(node.left,cnt+1,k,ans);
        KDist(node.right,cnt+1,k,ans);
    }
    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(5);
        root.right = new Node(1);
        root.left.left = new Node(6);
        root.left.right = new Node(2);
        root.right.left = new Node(0);
        root.right.right = new Node(8);
        root.left.right.left = new Node(7);
        root.left.right.right = new Node(4);
        kDist obj = new kDist();
        List<Integer> ans = obj.distanceK(root,root.left,2);
        System.out.println(ans);
    }

}
