package BinaryTrees;
import java.util.HashMap;
public class constructTreePostOrder {
     public static Node buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer> mpp = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            mpp.put(inorder[i],i);
        }
        Node root = treeBuilt(postorder,0,postorder.length-1,inorder,0,inorder.length-1,mpp);
        return root;
    }
    public static Node treeBuilt(int postorder[],int poStart,int poEnd,int inorder[],int inStart,int inEnd,HashMap<Integer,Integer> mpp){
        if(poStart>poEnd || inStart>inEnd)return null;
        Node root = new Node(postorder[poEnd]);
        int inRoot = mpp.get(root.data);
        int size = inRoot-inStart;
        root.left = treeBuilt(postorder,poStart,poStart+size-1,inorder,inStart,inRoot-1,mpp);
        root.right = treeBuilt(postorder,poStart+size,poEnd-1,inorder,inRoot+1,inEnd,mpp);
        return root;
    }
    public static void main(String[] args){
        int inorder[] = {4,2,5,1,6,3,7};
        int postorder[] = {4,5,2,6,7,3,1};
        Node root = buildTree(inorder,postorder);   
        System.out.println(root.data);
    }
}

