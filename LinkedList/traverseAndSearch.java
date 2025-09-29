package LinkedList;

class traverseAndSearch{
    public static void main(String args[]){
        Node head = arr2LL(new int[]{1,2,3,4,5});
        traverse(head);
        System.out.println(search(head,6));

    }
    static Node arr2LL(int arr[]){
        Node head = new Node(arr[0]);
        Node temp = head;
        for(int i=1;i<arr.length;i++){
            temp.next = new Node(arr[i]);
            temp = temp.next;
        }
        return head;
    }

    static void traverse(Node head){
        Node temp = head;
        while(temp.next!=null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.println(temp.data);
        return;
    }

    static int search(Node head,int k){
        Node temp = head;
        while(temp!=null){
            if(temp.data==k)return 1;
            temp = temp.next;
        }
        return 0;
    }
}
class Node{
    int data;
    Node next;

    Node(int data){
        this.data = data;
        this.next = null;
    }
}

