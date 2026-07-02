package BinaryTrees;

public class maxSum {
    static int val = Integer.MIN_VALUE;
    public  static int maxPathSum(Node root) {
        SumOfTreeOptimal(root);
        return val;
    }
    public static int SumOfTree(Node root){
        if(root==null)return 0;
        int l = SumOfTree(root.left);
        int r = SumOfTree(root.right);
        val = Math.max(val,root.data);
        val = Math.max(val,l+root.data);
        val = Math.max(val,r+root.data);
        val = Math.max(val,l+r+root.data);
        return Math.max(root.data,root.data+Math.max(l,r));
    }
    public static int SumOfTreeOptimal(Node root){
        if(root==null)return 0;
        int l = Math.max(SumOfTreeOptimal(root.left),0);
        int r = Math.max(SumOfTreeOptimal(root.right),0);
        val = Math.max(val,l+r+root.data);
        return root.data+Math.max(l,r);
    }
    public static void main(String[] args) {
        Node root = new Node(-10);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);
        int ans = maxSum.maxPathSum(root);
        System.out.println(ans);
    }
}

