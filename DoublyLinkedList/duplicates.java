package DoublyLinkedList;

public class duplicates {
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(1);
        Node n3 = new Node(2);
        Node n4 = new Node(3);
        Node n5 = new Node(3);
        Node n6 = new Node(4);
        n1.next = n2; n2.prev = n1;
        n2.next = n3; n3.prev = n2;
        n3.next = n4; n4.prev = n3;
        n4.next = n5; n5.prev = n4;
        n5.next = n6; n6.prev = n5;
        Node head = n1;
        duplicates inst = new duplicates();
        head = inst.removeDuplicates(head);
        for (Node cur = head; cur != null; cur = cur.next) {
            System.out.print(cur.data + (cur.next != null ? " " : ""));
        }
        System.out.println();
    }
    Node removeDuplicates(Node head) {
        Node temp = head;
        while(temp!=null && temp.next!=null){
            if(temp.data == temp.next.data){
                Node afterDelete = temp.next.next;
                if(afterDelete!=null) temp.next.next.prev = temp;
                temp.next = temp.next.next;
            }
            else temp = temp.next;
        }
        return head;
    }
}
