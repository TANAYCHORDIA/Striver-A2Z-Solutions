package LinkedList;

public class deleteMiddleNode {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        head = deleteMiddle(head);

        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
    public static Node deleteMiddle(Node head) {
        if(head == null || head.next == null)return null;
        Node fast = head;
        Node slow = head;
        while(fast.next.next!=null && fast.next.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
