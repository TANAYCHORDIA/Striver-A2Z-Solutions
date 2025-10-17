package LinkedList;
public class rotateKLL {
    public static void main(String[] args) {
        int[] vals = {1, 2, 3, 4, 5};
        Node head = new Node(vals[0]);
        Node curr = head;
        for (int i = 1; i < vals.length; i++) {
            curr.next = new Node(vals[i]);
            curr = curr.next;
        }
        head = rotateRight(head, 2);
        for (Node p = head; p != null; p = p.next) {
            System.out.print(p.data);
            if (p.next != null) System.out.print(" -> ");
        }
        System.out.println();
    }
    public static Node rotateRight(Node head, int k) {
        if(head == null || head.next == null)return head;
        int len=1;
        Node tail = head;
        while(tail.next!=null){
            len++;
            tail = tail.next;
        }
        k = k%len;
        tail.next = head;
        Node curr = head;
        for(int i=0;i<len-1-k;i++)curr = curr.next;
        head = curr.next;
        curr.next = null;
        return head;
    }
}
