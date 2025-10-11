package LinkedList;
class sort0_1_2{
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(0);
        head.next.next.next = new Node(1);
        head.next.next.next.next = new Node(2);

        System.out.println("Original List:");
        traverseAndSearch.traverse(head);

        head = sortList(head);

        System.out.println("Sorted List:");
        traverseAndSearch.traverse(head);
    }
    public static Node sortList(Node head) {
        Node zeroHead = new Node(-1);
        Node firstHead = new Node(-1);
        Node secondHead = new Node(-1);
        Node zeroTail = zeroHead;
        Node firstTail = firstHead;
        Node secondTail = secondHead;
        Node curr = head;
        while(curr!=null){
            if(curr.data == 0){
                zeroTail.next = curr;
                zeroTail = zeroTail.next;
            }
            else if(curr.data == 1){
                firstTail.next = curr;
                firstTail = firstTail.next;
            }
            else if(curr.data == 2){
                secondTail.next = curr;
                secondTail = secondTail.next;
            }
            curr = curr.next;
        }
        zeroTail.next = (firstHead.next!=null)?firstHead.next:secondHead.next;
        firstTail.next = secondHead.next;
        secondTail.next = null;
        return zeroHead.next;
    }
}