//In this question we arent given access to the head element and given a garuntee that the node to be deleted is not last
package LinkedList;

public class deleteAnode {
    public static void main(String[] args) {
        Node head = new Node(1);
        insertionAndDeletion.insertAtEnd(head, 2);
        insertionAndDeletion.insertAtEnd(head, 3);
        insertionAndDeletion.insertAtEnd(head, 4);
        deleteNode(head.next.next);

    }
    public static void deleteNode(Node node) {
        Node temp = node;
        temp.data = temp.next.data;
        temp.next = temp.next.next;
    }
}
