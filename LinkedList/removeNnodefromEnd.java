package LinkedList;
class removeNnodefromEnd{
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        int n = 2;
        head = removeNthFromEndOptimal(head, n);

        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }
    public static Node removeNthFromEnd(Node head, int n) {
        int len = 0;
        Node temp = head;
        while(temp!=null){
            len++;
            temp = temp.next;
        }
        int pos = len-n;
        temp = head;
        Node prevHead = new Node(-1);
        Node prev = prevHead;
        prevHead.next = head;
        for(int i=1;i<=pos;i++){
            prev = temp;
            temp = temp.next;
        }
        if(temp.next!=null){
            prev.next = temp.next;
            temp.next = null;
        }
        else if(prev!=null) prev.next = null;
        else head = null;
        
        return prevHead.next;
    }
    public static Node removeNthFromEndOptimal(Node head, int n) {
        Node fast = head;
        Node slow = head;
        for(int i=0;i<n;i++){
            fast = fast.next;
        }
        if(fast == null)return slow.next;
        while(fast.next!=null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next =  slow.next.next;
        return head;
    }
}