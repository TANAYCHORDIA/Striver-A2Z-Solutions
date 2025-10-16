package LinkedList;

public class reverseKgroup {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        int k = 2;
        Node res = reverseKGroup(head, k);
        Node curr = res;
        while (curr != null) {
            System.out.print(curr.data);
            if (curr.next != null) System.out.print("->");
            curr = curr.next;
        }
        System.out.println();
    }

    public static Node reverseKGroup(Node head, int k) {
        Node temp = head;
        Node prev = null;
        while(temp!=null){
            Node KthNode = findKnode(temp,k);
            if(KthNode==null){
                if(prev!=null)prev.next = temp;
                break;
            }
            Node nextNode = KthNode.next;
            KthNode.next = null;
            reverseList(temp);
            if(temp == head){
                head = KthNode;
            }
            else{
                prev.next = KthNode;
            }
            prev = temp;
            temp = nextNode;
            
        }
        return head;
    }
    public static Node findKnode(Node head,int k){
        Node temp = head;
        int i;
        for(i=1;i<k && temp!=null;i++)temp = temp.next;
        return temp;
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
}
