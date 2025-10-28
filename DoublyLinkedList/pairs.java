package DoublyLinkedList;

import java.util.ArrayList;

public class pairs {
    public static void main(String[] args) {
        int[] vals = {1, 2, 3, 4, 5, 6, 7};
        Node head = new Node(vals[0]);
        Node curr = head;
        for (int i = 1; i < vals.length; i++) {
            Node node = new Node(vals[i]);
            curr.next = node;
            node.prev = curr;
            curr = node;
        }
        int target = 8;
        ArrayList<ArrayList<Integer>> result = findPairsWithGivenSum(target, head);
        for (ArrayList<Integer> pair : result) {
            System.out.println(pair.get(0) + " " + pair.get(1));
        }
    }
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, Node head) {
        Node tail = head;
        Node temp = head;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>(); 
        while(tail.next!=null)tail = tail.next;
        while(temp!=null && tail!=null && temp!=tail && temp.prev!=tail){
            if(temp.data+tail.data == target){
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(temp.data);
                pair.add(tail.data);
                ans.add(pair);
                temp = temp.next;
                tail = tail.prev;
            }
            else if(temp.data+tail.data<target)temp = temp.next;
            else{
                tail = tail.prev;
            }
        }
        return ans;
    }
}
