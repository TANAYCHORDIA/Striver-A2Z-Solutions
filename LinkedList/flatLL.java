package LinkedList;
class Node{
    int data;
    Node next;
    Node bottom;
    Node(int data){
        this.data = data;
        this.bottom = null;
        this.next = null;
    }
}
class flatLL{
    public static void main(String[] args) {
        Node n1 = new Node(5);
        n1.bottom = new Node(7);
        n1.bottom.bottom = new Node(8);
        n1.bottom.bottom.bottom = new Node(30);

        Node n2 = new Node(10);
        n2.bottom = new Node(20);

        Node n3 = new Node(19);
        n3.bottom = new Node(22);
        n3.bottom.bottom = new Node(50);

        Node n4 = new Node(28);
        n4.bottom = new Node(35);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        Node flat = flatten(n1);
        for(Node cur = flat; cur != null; cur = cur.bottom) System.out.print(cur.data + " ");
        System.out.println();
    }
    public static Node flatten(Node root) {
        if(root == null || root.next == null)return root;
        Node mergeHead = flatten(root.next);
        return merge(root,mergeHead);
    }
    public static Node merge(Node root1,Node root2){
        Node dummy = new Node(-1);
        Node curr = dummy;
        while(root1!=null && root2!=null){
            if(root1.data<root2.data){
                curr.bottom = root1;
                curr = root1;
                root1 = root1.bottom;
            }
            else{
                curr.bottom = root2;
                curr = root2;
                root2 = root2.bottom; 
            }
            curr.next = null;
        }
        if(root1 == null) curr.bottom = root2;
        else curr.bottom = root1;
        return dummy.bottom;
    }
}