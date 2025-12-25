package StackAndQueue;
import java.util.HashMap;
public class LRU {
    class Node{
    int key;
    int value;
    Node next;
    Node prev;
    Node(int key,int value){
        this.key = key;
        this.value = value;
        }
    }
    Node head = new Node(0,0);
    Node tail = new Node(0,0);
    HashMap<Integer,Node> mpp;
    int capacity;
    public LRU(int capacity) {
        mpp = new HashMap<>(capacity);
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
    }
    public void insert(Node node){
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }
    public void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    public int get(int key) {
        if(mpp.containsKey(key)){
            Node node = mpp.get(key);
            remove(node);
            insert(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(mpp.size() == capacity && !mpp.containsKey(key)){
            mpp.remove(tail.prev.key);
            remove(tail.prev);
        }
        if(mpp.containsKey(key))remove(mpp.get(key));
        Node node = new Node(key,value);
        mpp.put(key,node);
       insert(node);
    }

    public static void main(String[] args) {
        LRU lru = new LRU(2);
        lru.put(1,1);
        lru.put(2,2);
        System.out.println(lru.get(1));
        lru.put(3,3); 
        System.out.println(lru.get(2)); 
        lru.put(4,4); 
        System.out.println(lru.get(1)); 
        System.out.println(lru.get(3)); 
        System.out.println(lru.get(4)); 
    }
}
