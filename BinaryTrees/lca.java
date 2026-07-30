package BinaryTrees;
public class lca{
    public static Node lowestCommonAncestor(Node root, Node p, Node q) {
        if(root==null||root==p || root==q)return root;
        Node left = lowestCommonAncestor(root.left,p,q);
        Node right = lowestCommonAncestor(root.right,p,q);
        if(left!=null && right!=null)return root;
        return (left != null) ? left : right;
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

        Node p = root.left; // Node with value 5
        Node q = root.left.right.right; // Node with value 4

        Node lcaNode = lowestCommonAncestor(root, p, q);
        System.out.println("Lowest Common Ancestor of " + p.data + " and " + q.data + " is: " + lcaNode.data);
    }
}