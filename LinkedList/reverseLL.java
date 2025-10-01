package LinkedList;
public class reverseLL {
   public static void main(String[] args) {
        Node head = new Node(1);
        insertionAndDeletion.insertAtEnd(head, 2);
        insertionAndDeletion.insertAtEnd(head, 3);
        insertionAndDeletion.insertAtEnd(head, 4);
        head = reverseListRecursive(head);
        traverseAndSearch.traverse(head);
   }
   public static Node reverseList(Node head) {
        if(head==null || head.next==null)return head;
        Node curr = head;
        Node prev = null;
        while(curr!=null){
            Node front = curr.next;
            curr.next = prev;
            prev = curr;
            curr = front;
        }
        head= prev;
        return head;
    } 
    public static Node reverseListRecursive(Node head) {
        if(head == null ||head.next == null)return head;
        Node front = head.next;
        Node newHead = reverseList(front);
        front.next = head;
        head.next = null;
        return newHead;
    }
}
