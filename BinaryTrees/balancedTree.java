package BinaryTrees;

public class balancedTree {
    public static boolean isBalanced(Node root) {
      if(root==null)return true;
        int val = maxDepthOptimal(root);
        if(val==-1)return false;
        return true;

    }
    public static int maxDepthOptimal(Node root) {
        if(root==null)return 0;
        int r = maxDepthOptimal(root.right);
        int l = maxDepthOptimal(root.left);
        if(l==-1 || r == -1)return -1;
        if(Math.abs(r-l)>1)return -1;
        return 1+ Math.max(l,r); 
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        boolean ans = isBalanced(root);
        System.out.println(ans);
    }
}
