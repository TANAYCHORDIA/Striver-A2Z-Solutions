package LinkedList;

public class oddEvenNode {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        Node result = oddEvenList(head);

        while(result != null) {
            System.out.print(result.data + " ");
            result = result.next;
        }
    }
    public static Node oddEvenList(Node head) {
        if(head==null || head.next==null)return head;
        Node evenHead = head.next;
        Node even = evenHead;
        Node odd = head;
        while(even!=null && even.next!=null){
            odd.next = odd.next.next;
            odd = odd.next;
            even.next = even.next.next;
            even = even.next;
        } 
        odd.next = evenHead;
        if(even!=null)even.next=null;
        return head;
    }
}
