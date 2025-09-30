package LinkedList;

class middle{
    public static void main(String[] args) {
        Node head = new Node(1);
        insertionAndDeletion.insertAtEnd(head, 2);
        insertionAndDeletion.insertAtEnd(head, 3);
        insertionAndDeletion.insertAtEnd(head, 4);
        System.out.println(middleNodeOptimal(head).data);
    }
    public static Node middleNodeBrute(Node head) {
        int n = count( head);
        int mid = (n)/2+1;
        Node temp = head;
        for(int i=1;i<mid;i++){
            temp=temp.next;
        }
        return temp;
    }
    public static int count(Node head){
        int cnt = 0;
        Node temp = head;
        while(temp!=null){
            cnt++;
            temp=temp.next;
        }
        return cnt;
    }

    public static Node middleNodeOptimal(Node head) {
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}