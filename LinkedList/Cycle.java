package LinkedList;

public class Cycle {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        //head.next.next.next.next = head.next;
        System.out.println(hasCycle(head));
    }
    public static boolean hasCycle(Node head) {
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) return true;
        }
        return false;
    }
}
