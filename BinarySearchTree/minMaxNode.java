package BinarySearchTree;

public class minMaxNode {
    public static int minValue(Node root) {
        Node prev = null;
        while(root!=null){
            prev = root;
            root = root.left;
        }
        return prev.data;
    }
    public static int maxValue(Node root) {
        Node prev = null;
        while(root!=null){
            prev = root;
            root = root.right;
        }
        return prev.data;
    }
    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(7);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right.right = new Node(8);
        System.out.println("Minimum value in the BST: " + minValue(root));
        System.out.println("Maximum value in the BST: " + maxValue(root));
    }
}
