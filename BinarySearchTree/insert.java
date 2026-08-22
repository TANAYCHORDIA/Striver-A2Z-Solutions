package BinarySearchTree;

public class insert{
    public static Node insertIntoBST(Node root, int val) {
        if(root==null)return new Node(val);
        Node start = root;
        while(true){
            if(root.data>val){
                if(root.left!=null)root=root.left;
                else{
                    root.left = new Node(val);
                    break;
                }
            }
            else{
                if(root.right!=null)root=root.right;
                else{
                    root.right = new Node(val);
                    break;
                }
            }
        }
        return start;
    }
    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(7);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        int val = 5;
        Node ans = insertIntoBST(root,val);
        System.out.println(ans.data);
    }
}