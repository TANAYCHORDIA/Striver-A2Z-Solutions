package BinaryTrees;

public class changeTreeSumProp {
    public static void changeTree(Node root) {
        if(root==null)return;
        int child = 0;
        if(root.left!=null)child+=root.left.data;
        if(root.right!=null)child+=root.right.data;
        if(child>=root.data)root.data=child;
        else{
            if(root.left!=null)root.left.data = root.data;
            if(root.right!=null)root.right.data = root.data;
        }
        changeTree(root.left);
        changeTree(root.right);
        int tot = 0;
        if(root.left!=null)tot+=root.left.data;
        if(root.right!=null)tot+=root.right.data;
        if(root.right!=null || root.left!=null)root.data = tot;
    }
    public static void main(String[] args) {
        Node root = new Node(50);
        root.left = new Node(7);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(5);
        root.right.right = new Node(1);
        changeTree(root);
        System.out.println(isSumPropCheck.isSumProperty(root));
    }
}
