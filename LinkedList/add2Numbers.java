package LinkedList;

public class add2Numbers {
    public static void main(String[] args) {
        Node l1 = new Node(2);
        l1.next = new Node(4);
        l1.next.next = new Node(3);

        Node l2 = new Node(5);
        l2.next = new Node(6);
        l2.next.next = new Node(4);

        Node result = addTwoNumbers(l1, l2);
        while (result != null) {
            System.out.print(result.data + " ");
            result = result.next;
        }
        System.out.println();
    }
    public static Node addTwoNumbers(Node l1, Node l2) {
        Node temp1 = l1;
        Node temp2 = l2;
        int carry = 0;
        Node dummy = new Node(-1);
        Node curr = dummy;
        while(temp1!=null || temp2!=null){
            int sum = carry;
            if(temp1!=null)sum+=temp1.data;
            if(temp2!=null)sum+=temp2.data;
            Node newNode = new Node(sum%10);
            curr.next = newNode;
            curr = newNode;
            if(temp1!=null)temp1 = temp1.next;
            if(temp2!=null) temp2 = temp2.next;
            carry = sum/10;
        }
        if(carry==1){
            Node newNode = new Node(1);
            curr.next = newNode;
        }
        return dummy.next;
    }
}
