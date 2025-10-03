package LinkedList;

import java.util.HashMap;

public class cycleNode {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = head.next;
        System.out.println(detectCycleOptimal(head));
    }
    public static Node detectCycleBrute(Node head) {
        HashMap<Node,Integer> mpp = new HashMap<>();
        Node temp = head;
        while(temp!=null){
            if(mpp.containsKey(temp))return temp;
            mpp.put(temp,1);
            temp = temp.next;
        }
        return null;
    }
    public static Node  detectCycleOptimal(Node head) {
        Node fast = head;
        Node slow = head;
        while(fast!=null && fast.next!= null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow){
                slow = head;
                while(slow!=fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}
