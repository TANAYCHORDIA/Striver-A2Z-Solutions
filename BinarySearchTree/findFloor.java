package BinarySearchTree;

public class findFloor {
    public static int floor(Node root, int x) {
        Node prev = null;
        while(root!=null && root.data!=x){
            if(root.data>x)root = root.left;
            else{
                prev = root;
                root = root.right;
            } 
        }
        if(root!=null)return root.data;
        if(prev!=null)return prev.data;
        return -1;
    }
    public static void main(String args[]){
        
        Node root = new Node(8);
        root.left = new Node(4);
        root.right = new Node(12);
        root.left.left = new Node(2);
        root.left.right = new Node(6);
        root.right.left = new Node(10);
        root.right.right = new Node(14);

        int x = 5;
        int floorValue = floor(root, x);
        if(floorValue != -1){
            System.out.println("Floor value for " + x + " is: " + floorValue);
        } else {
            System.out.println("Floor value not found.");
        }
    }
}
