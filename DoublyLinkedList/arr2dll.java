package DoublyLinkedList;
class Node{
    int data;
    Node next;
    Node prev;
    Node(int data){
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
public class arr2dll {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        Node head = arr2DLL(arr, arr.length);
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
        Node tail = head;
        while (tail != null && tail.next != null) tail = tail.next;
        while (tail != null) {
            System.out.print(tail.data + " ");
            tail = tail.prev;
        }
        System.out.println();
    }

    public static Node arr2DLL(int arr[],int n){
        Node head = new Node(arr[0]);
        Node temp = head;
        for(int i=1;i<=n-1;i++){
            Node newNode = new Node(arr[i]);
            newNode.prev = temp;
            temp.next = newNode;
            temp = newNode;
        }
        return head;
    }
    
}
