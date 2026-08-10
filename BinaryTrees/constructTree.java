package BinaryTrees;
import java.util.HashMap;
public class constructTree {
    public static Node buildTree(int inorder[], int preorder[]) {
        HashMap<Integer,Integer> mpp = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            mpp.put(inorder[i],i);
        }
        
        Node root = treeBuilt(preorder,0,preorder.length-1,inorder,0,inorder.length-1,mpp);
        return root;
        
    }
    public static Node treeBuilt(int preorder[],int preStart,int preEnd,int inorder[],int inStart,int inEnd,HashMap<Integer,Integer> mpp){
        if(preStart>preEnd || inStart>inEnd)return null;
        Node root = new Node(preorder[preStart]);
        int inRoot = mpp.get(root.data);
        int size = inRoot-inStart;
        root.left = treeBuilt(preorder,preStart+1,preStart+size,inorder,inStart,inRoot-1,mpp);
        root.right = treeBuilt(preorder,preStart+size+1,preEnd,inorder,inRoot+1,inEnd,mpp);
        return root;
    }
    public static void main(String[] args) {
        int inorder[] = {4,2,5,1,6,3,7};
        int preorder[] = {1,2,4,5,3,6,7};
        Node root = buildTree(inorder,preorder);
        System.out.println(root.data);
    }
}