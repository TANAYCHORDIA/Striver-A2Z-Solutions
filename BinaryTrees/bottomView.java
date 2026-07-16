package BinaryTrees;
import java.util.*;
class Tuple{
    Node node;
    int row;
    Tuple(Node node,int row){
        this.node=node;
        this.row = row;
    }
}

public class bottomView {
    public static ArrayList<Integer> BottomView(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        TreeMap<Integer,Node> mpp = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        if(root==null)return ans;
        q.offer(new Tuple(root,0));
        while(!q.isEmpty()){
            Tuple temp = q.poll();
            Node node = temp.node;
            int x = temp.row;
            mpp.put(x,node);
            if(node.left!=null)q.offer(new Tuple(node.left,x-1));
            if(node.right!=null)q.offer(new Tuple(node.right,x+1));
        }
        for(Node node:mpp.values()){
            ans.add(node.data);
        }
        return ans;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        ArrayList<Integer> ans = bottomView.BottomView(root);
        System.out.println(ans);
    }

}