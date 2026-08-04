package BinaryTrees;
public class isSumPropCheck{
    public static boolean isSumProperty(Node root) {
        return postOrder(root);
    }
    public static boolean postOrder(Node node){
        if(node.left==null && node.right==null)return true;
        boolean leftAns=true;
        boolean rightAns =true;
        if(node.left!=null)leftAns = postOrder(node.left);
        if(node.right!=null)rightAns = postOrder(node.right);
        if(node.left==null){
            if(node.right.data == node.data)return (leftAns&&rightAns&&true);
            return (leftAns&&rightAns&&false);
        }
        if(node.right==null){
            if(node.left.data == node.data)return (leftAns&&rightAns&&true);
            return (leftAns&&rightAns&&false);
        }
        return ((node.left.data+node.right.data==node.data) && leftAns && rightAns);
    }
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(5);
        root.right.right = new Node(2);
        System.out.println(isSumPropCheck.isSumProperty(root));
    }
}