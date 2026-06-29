package BinaryTrees;
public class diameterTree {
    static int val = 0;
    public static int diameterOfBinaryTree(Node root) {
        Height(root);
        return val;
    }
    public static int Height(Node root){
        if(root==null)return 0;
        int l = Height(root.left);
        int r = Height(root.right);
        val = Math.max(val,l+r);
        return 1+Math.max(l,r);
    }
    public static void main(String[] arg){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        int ans = diameterOfBinaryTree(root);
        System.out.println(ans);
    }
}
