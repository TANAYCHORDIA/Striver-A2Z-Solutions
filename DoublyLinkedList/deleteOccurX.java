package DoublyLinkedList;

public class deleteOccurX {
    public static void main(String[] args) {
        Node head = new Node(1);
        Node n2 = new Node(3);
        Node n3 = new Node(2);
        Node n4 = new Node(3);
        Node n5 = new Node(4);

        head.next = n2; n2.prev = head;
        n2.next = n3; n3.prev = n2;
        n3.next = n4; n4.prev = n3;
        n4.next = n5; n5.prev = n4;

        for (Node cur = head; cur != null; cur = cur.next) {
            System.out.print(cur.data + (cur.next != null ? " " : ""));
        }
        System.out.println();

        head = deleteAllOccurOfX(head, 3);

        for (Node cur = head; cur != null; cur = cur.next) {
            System.out.print(cur.data + (cur.next != null ? " " : ""));
        }
        System.out.println();
    }
    public static Node deleteAllOccurOfX(Node head, int x) {
        Node temp = head;
        while(temp!=null){
            if(temp.data == x){
                if(temp.next == null && temp.prev==null){
                    head = null;
                    break;
                }
                else if(temp.next == null && temp.prev!=null){
                    temp.prev.next = null;
                    temp = temp.prev;
                }
                else if(temp.prev == null && temp.next!=null){
                    temp.next.prev = null;
                    head = temp.next;
                    temp = temp.next;
                }
                else{
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                    temp = temp.next;
                }
            }
            else{
                temp = temp.next;
            }
        }
        return head;
    }
}
