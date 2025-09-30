package LinkedList;

public class insertionAndDeletion {
    public static void main(String[] args) {
        Node head = null;
        head = insertAtBeginning(head, 10);
        head = insertAtEnd(head, 20);
        head = insertAtEnd(head, 30);
        head = insertAtK(2, head, 15);
        head = insertBeforeValue(20, head, 18);
        head = deleteAtBeginning(head);
        head = deleteTail(head);
        head = deleteKnode(2, head);
        head = deleteValue(head, 18);
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    public static Node insertAtBeginning(Node head, int data){
        Node newNode = new Node(data);
        newNode.next = head;
        return newNode;
    }
    public static Node insertAtEnd(Node head,int val){
        if(head==null){
            Node newNode = new Node(val);
            head = newNode;
            return head;
        }
        Node temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        Node newNode = new Node(val);
        temp.next = newNode;
        return head;
    }

    public static Node insertAtK(int k, Node head, int val){
        if(head==null){
            if (k==1){
                Node newNode = new Node(val);
                head = newNode;
                return head;
            }
            else return head;
        }
        if(k==1){
            Node newNode = new Node(val);
            newNode.next = head;
            head = newNode;
            return head;
        }
        int cnt = 0;
        Node temp = head;
        while(temp!=null){
            cnt++;
            if(cnt==k-1){
                Node newNode = new Node(val);
                newNode.next = temp.next;
                temp.next = newNode;
                return head;
            }
            temp = temp.next;
        }
        return head;
    }
    public static Node insertBeforeValue(int val, Node head, int data){
        if(head==null)return head;
        if(head.data==val){
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
            return head;
        }
        Node temp = head;
        while(temp.next!=null){
            if(temp.next.data==val){
                Node newNode = new Node(data);
                newNode.next = temp.next;
                temp.next = newNode;
                return head;
            }
            temp = temp.next;
        }
        return head;
    }

    public static Node deleteAtBeginning(Node head){
        if(head==null)return head;
        head = head.next;
        return head;
    }
    public static Node deleteTail(Node head){
        if(head==null || head.next==null)return null;
        Node temp = head;
        Node prev = null;
        while(temp.next!=null){
            prev = temp;
            temp = temp.next;
        }
        prev.next = null;
        return head;
    }

    public static Node deleteKnode(int k,Node head){
        if(head==null)return head;
        if(k==1){
            head = head.next;
            return head;
        }
        int cnt = 0;
        Node temp = head;
        while(temp!=null){
            cnt++;
            if(cnt==k-1){
                temp.next=temp.next.next;
                return head;
            }
            temp = temp.next;
        }
        return head;
    }

    public static Node deleteValue(Node head,int val){
        if(head == null){
            return head;
        }
        if(head.data == val){
            head = head.next;
            return head;
        }
        Node temp = head;
        Node prev = null;
        while(temp!=null){
            if(temp.data==val){
                prev.next=prev.next.next;
                return head;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }

}
