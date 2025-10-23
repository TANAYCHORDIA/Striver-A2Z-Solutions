
package DoublyLinkedList;

public class insertionAnddeletion {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.prev = head;
        head = insertBeforeHead(head, new Node(0));
        head = insertBeforeTail(head, new Node(3));
        head = insertBeforeKth(head, new Node(9), 3);
        head = deleteKele(head, 2);
        head = deleteTail(head);
        head = deleteHead(head);
    }

    public static Node deleteHead(Node head) {
        if (head == null)
            return null;
        if (head.next == null) {
            head.prev = null;
            return null;
        }
        Node newHead = head.next;
        newHead.prev = null;
        head.next = null;
        return newHead;
    }

    public static Node deleteTail(Node head) {
        if (head == null)
            return null;
        if (head.next == null) {
            head.prev = null;
            return null;
        }
        Node tail = head;
        while (tail.next != null)
            tail = tail.next;
        Node newTail = tail.prev;
        newTail.next = null;
        tail.prev = null;
        return head;
    }

    public static Node deleteKele(Node head, int k) {
        if (head == null || k <= 0)
            return head;
        if (k == 1)
            return deleteHead(head);
        Node curr = head;
        int i = 1;
        while (i < k && curr != null) {
            curr = curr.next;
            i++;
        }
        if (curr == null)
            return head;
        if (curr.next == null)
            return deleteTail(head);
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
        curr.next = null;
        curr.prev = null;
        return head;
    }

    public static Node deleteNode(Node head, Node node) {
        if (head == null || node == null)
            return head;
        if (node == head)
            return deleteHead(head);
        if (node.next == null)
            return deleteTail(head);
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
        node.prev = null;
        return head;
    }
    public static Node insertBeforeHead(Node head, Node node) {
        if (node == null)
            return head;
        node.prev = null;
        node.next = null;
        if (head == null)
            return node;
        node.next = head;
        head.prev = node;
        return node;
    }

    public static Node insertBeforeTail(Node head, Node node) {
        if (node == null)
            return head;
        node.prev = null;
        node.next = null;
        if (head == null)
            return node;
        if (head.next == null) {
            node.next = head;
            head.prev = node;
            return node;
        }
        Node tail = head;
        while (tail.next != null)
            tail = tail.next;
        Node beforeTail = tail.prev;
        beforeTail.next = node;
        node.prev = beforeTail;
        node.next = tail;
        tail.prev = node;
        return head;
    }

    public static Node insertBeforeKth(Node head, Node node, int k) {
        if (node == null || k <= 0)
            return head;
        node.prev = null;
        node.next = null;
        if (head == null) {
            if (k == 1)
                return node;
            return head;
        }
        if (k == 1)
            return insertBeforeHead(head, node);
        Node curr = head;
        int i = 1;
        while (i < k && curr != null) {
            curr = curr.next;
            i++;
        }
        if (curr == null)
            return head; 
        Node prev = curr.prev;
        prev.next = node;
        node.prev = prev;
        node.next = curr;
        curr.prev = node;
        return head;
    }

    public static Node insertBeforeNode(Node head, Node target, Node node) {
        if (node == null || target == null)
            return head;
        node.prev = null;
        node.next = null;
        if (target == head)
            return insertBeforeHead(head, node);
        Node prev = target.prev;
        if (prev == null)
            return insertBeforeHead(head, node);
        prev.next = node;
        node.prev = prev;
        node.next = target;
        target.prev = node;
        return head;
    }
}
