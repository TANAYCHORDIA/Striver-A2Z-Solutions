package BinarySearchTree;
public class searchBST {
    public static Node SearchBST(Node root, int val) {
        while(root!=null && root.data!=val){
            root = root.data>val?root.left:root.right;
        }
        return root;
    }
    public static void main(String args[]){
        
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(7);
        root.left.left = new Node(1);
        root.left.right = new Node(3);

        int val = 2;
        Node result = SearchBST(root, val);
        if(result!=null){
            System.out.println("Node found with value: " + result.data);
        } else {
            System.out.println("Node not found.");
        }
    }
}
