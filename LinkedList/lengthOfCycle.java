package LinkedList;

public class lengthOfCycle {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = head.next.next; 

        int len = lengthOfLoop(head);
        System.out.println(len);
    }
    public static int lengthOfLoop(Node head) {
        Node fast = head;
        Node slow = head;
        int cnt = 1;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow){
                slow = slow.next;
                while(slow!=fast){
                    slow=slow.next;
                    cnt++;
                }
                return cnt;
            }
            
        }
        return 0;
    }
}
