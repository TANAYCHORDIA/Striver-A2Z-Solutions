package BinaryTrees;
import java.util.*;
class Tuple{
    Node node;
    int row;
    int col;
    Tuple(Node node,int row,int col){
        this.node = node;
        this.row = row;
        this.col = col;
    }

 }
public class verticalOrder {
    public  static List<List<Integer>> verticalTraversal(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> mpp = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        if(root==null)return ans;
        q.offer(new Tuple(root,0,0));
        while(!q.isEmpty()){
            Tuple tuple = q.poll();
            Node node  = tuple.node;
            int x = tuple.row;
            int y = tuple.col;

            if(!mpp.containsKey(x))mpp.put(x,new TreeMap<>());
            if(!mpp.get(x).containsKey(y))mpp.get(x).put(y, new PriorityQueue<>());
            mpp.get(x).get(y).offer(node.data);

            if(node.left!=null)q.offer(new Tuple(node.left,x-1,y+1));
            if(node.right!=null)q.offer(new Tuple(node.right,x+1,y+1));
        }
        for(TreeMap<Integer, PriorityQueue<Integer>> ys: mpp.values()){
            List<Integer> ls = new ArrayList<>();
            for(PriorityQueue<Integer> pq: ys.values()){
                while(!pq.isEmpty()){
                    ls.add(pq.poll());
                }
            }
            ans.add(ls);
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
        List<List<Integer>> ans = verticalTraversal(root);
        System.out.println(ans);
    }
}