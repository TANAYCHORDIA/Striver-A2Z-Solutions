package LinkedList;

public class sortLL {
    public static void main(String[] args) {
        Node head = new Node(4);
        head.next = new Node(2);
        head.next.next = new Node(1);
        head.next.next.next = new Node(3);

        head = sort(head);

        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }
    public static Node sort(Node head) {
        if(head == null || head.next==null)return head;
        Node middle = findmiddle(head);
        Node leftHead = head;
        Node rightHead = middle.next;
        middle.next = null;
        leftHead = sort(leftHead);
        rightHead = sort(rightHead);
        
        return mergeTwoLists(leftHead,rightHead);
    }
    public static Node findmiddle(Node head){
        Node slow = head;
        Node fast = head.next;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public static Node mergeTwoLists(Node list1, Node list2) {
        Node dummy = new Node(-1);
        Node temp1 = dummy;
        while(list1!=null && list2!=null){
            if(list1.data<=list2.data){
                temp1.next = list1;
                list1 = list1.next;
                temp1=temp1.next;
            }
            else{
                temp1.next = list2;
                list2 = list2.next;
                temp1=temp1.next;
            }
        }
        if(list1!=null)temp1.next = list1;
        else temp1.next = list2;
        return dummy.next;
    }
}
