package LinkedList;

public class palindrome {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);
        System.out.println(isPalindrome(head));
    }
    public static boolean isPalindrome(Node head) {
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        Node newHead = reverse(slow);
        Node temp = head;
        while(newHead!=null){
            if(temp.data!=newHead.data) return false;
            newHead=newHead.next;
            temp = temp.next;
        }
        return true;
    }
    public static Node reverse(Node slow){
        Node prev =null;
        Node curr = slow;
        while(curr!=null){
            Node front = curr.next;
            curr.next = prev;
            prev = curr;
            curr = front;
        }
        return prev;
    }
}
