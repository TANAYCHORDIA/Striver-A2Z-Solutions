package BinaryTrees;

public class noOfNodes {
     public static int countNodes(Node root) {
        int leftHeight = Level(root,0);
        int rightHeight = Level(root,1);
        if(leftHeight==rightHeight)return (int)Math.pow(2,leftHeight)-1;
        else{
            return 1+countNodes(root.left)+countNodes(root.right);
        }

    }
    public static int Level(Node root,int n){
        if(root==null)return 0;
        if(n==0)return 1+Level(root.left,n);
        else return 1+Level(root.right,n);
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println(countNodes(root));
    }
}
