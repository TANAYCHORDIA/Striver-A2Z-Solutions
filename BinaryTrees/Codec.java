package BinaryTrees;
import java.util.LinkedList;
import java.util.Queue;
public class Codec {
    public static String serialize(Node root) {
        if(root==null)return "";
        Queue<Node> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        q.add(root);
        while(!q.isEmpty()){
            Node node = q.poll();
            if(node==null){
                sb.append("n ");
                continue;
            }
            sb.append(node.data+" ");
            q.add(node.left);
            q.add(node.right);
        }
        return sb.toString();
    }
    public static Node deserialize(String data) {
        if(data.equals(""))return null;
        Queue<Node> q = new LinkedList<>();
        String[] res = data.split(" ");
        Node root = new Node(Integer.parseInt(res[0]));
        q.add(root);
        for(int i=1;i<res.length;i++){
            Node parent = q.poll();
            if(!res[i].equals("n")){
                Node left = new Node(Integer.parseInt(res[i]));
                parent.left = left;
                q.add(left);
            }
            if(!res[++i].equals("n")){
                Node right = new Node(Integer.parseInt(res[i]));
                parent.right = right;
                q.add(right);
            }
        }
        return root;
    }
    public static void main(String[] args){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(5);
        String data = serialize(root);
        System.out.println(data);
        Node ans = deserialize(data);
        System.out.println(ans.data);
    }
}