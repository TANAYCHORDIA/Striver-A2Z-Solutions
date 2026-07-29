package BinaryTrees;
import java.util.*;


public class rootToLeaf{
    public static List<String> binaryTreePathsBrute(Node root) {
        List<String> ans = new ArrayList<>();
        if(root==null)return ans;
        ArrayList<Integer> track = new ArrayList<>();
        inOrder(root,track,ans);
        return ans;
    }
    public static boolean inOrder(Node node,ArrayList<Integer> track,List<String> ans){
        if(node==null)return false;
        track.add(node.data);
        boolean left = inOrder(node.left,track,ans);
        boolean right = inOrder(node.right,track,ans);
        if(left == false && right == false){
            String temp = "";
            for(int i=0;i<track.size();i++){
                if(i==0)temp+=track.get(i);
                else{
                    temp+="->";
                    temp+=track.get(i);
                }
            }
            ans.add(temp);
        }
        track.remove(track.size()-1);
        return true;
    }
    public static List<String> binaryTreePathsOptimal(Node root) {
        List<String> ans = new ArrayList<>();
        if(root==null)return ans;
        StringBuilder path = new StringBuilder();
        inOrder(root,path,ans);
        return ans;
    }
    public static void inOrder(Node node,StringBuilder path,List<String> ans){
        if (node == null) return;
        int len = path.length();
        if (len != 0)path.append("->");
        path.append(node.data);
        if (node.left == null && node.right == null) {
            ans.add(path.toString());
        } else {
            inOrder(node.left, path, ans);
            inOrder(node.right, path, ans);
        }
        path.setLength(len); 
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(5);
        System.out.println(binaryTreePathsOptimal(root));
    }
}