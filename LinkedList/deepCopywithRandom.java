package LinkedList;
class Node{
    int data;
    Node next;
    Node random;
    Node(int data){
        this.data = data;
        this.next = null;
        this.random = null;
    }
}
public class deepCopywithRandom {
    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        a.next = b;
        b.next = c;
        a.random = c;
        b.random = a;
        c.random = b;
        Node copied = copyRandomList(a);
        Node cur = copied;
        while (cur != null) {
            System.out.print(cur.data + "(" + (cur.random != null ? cur.random.data : "null") + ")");
            if (cur.next != null) System.out.print(" -> ");
            cur = cur.next;
        }
        System.out.println();
    }
     public static Node copyRandomList(Node head) {
        Node dummyNode = new Node(-1);
        Node temp = dummyNode;
        Node curr = head;
        while(curr!=null){
            Node dummy = new Node(curr.data);
            dummy.next = curr.next;
            curr.next = dummy;
            curr = curr.next.next;
        }
        curr = head;
        while(curr!=null){
            if(curr.random!=null)curr.next.random = curr.random.next;
            else curr.next.random = null;
            curr = curr.next.next;
        }
        curr = head;
        while(curr!=null){
            temp.next = curr.next;
            temp = temp.next;
            curr.next = curr.next.next;
            curr = curr.next;
        }
        return dummyNode.next;
    }
}
