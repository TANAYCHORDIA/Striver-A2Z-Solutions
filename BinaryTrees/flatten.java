package BinaryTrees;
public class flatten{
    static Node prev = null;
    public static void flattenBT(Node root) {
        if(root==null)return;
        flattenBT(root.right);
        flattenBT(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
    public static void main(String[] args){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.right = new Node(6);
        flattenBT(root);
        while(root!=null){
            System.out.print(root.data+" ");
            root = root.right;
        }
    }
}