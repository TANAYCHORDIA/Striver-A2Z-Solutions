package LinkedList;

public class addOne {
    public static void main(String[] args) {
        Node head = new Node(9);
        head.next = new Node(9);
        head.next.next = new Node(9);

        head = addOneOptimal(head);

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            temp = temp.next;
        }
        System.out.println();
    }
     public static Node addOneBrute(Node head) {
        head = reverseList(head);
        Node temp = head;
        int carry = 1;
        while(temp!=null){
            temp.data = (temp.data+carry)%10;
            if(temp.data!=0){
                carry = 0;
                break;
            }
            else{
                temp = temp.next;
            }
        }
        head = reverseList(head);
        if(carry == 1){
            Node dummy = new Node(1);
            dummy.next = head;
            head = dummy;
        }
        return head;
        
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

    public static Node addOneOptimal(Node head) {
		int carry = helper(head);
		if(carry == 1){
			Node newNode = new Node(1);
			newNode.next = head;
			head = newNode;
		}
		return head;
	}
	public static int helper(Node head){
		if(head == null)return 1;
		int carry = helper(head.next);
		head.data = (head.data+carry)%10;
		if(head.data == 0 && carry == 1)return 1;
		return 0;

	}
}
