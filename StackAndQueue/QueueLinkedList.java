package StackAndQueue;
class QueueNode{
    int data;
    QueueNode next;
    QueueNode(int x){
        this.data = x;
        this.next = null;
    }
}
public class QueueLinkedList {
    QueueNode front = null , rear = null;
    int size = 0;
    
    public boolean isEmpty(){
        return rear == null ;
    }

    public void enqueue(int data){
        QueueNode ele = new QueueNode(data);
        if(isEmpty()){
            front = rear = ele;
        }
        else{
            rear.next = ele;
            rear = ele;
        }
        size++;
        return;
    }
    public int dequeue(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            System.exit(1);
        }
        else if(front == rear){
            int x = front.data;
            front = rear = null;
            size = 0;
            return x;
        }
        int x = front.data;
        front = front.next;
        size--;
        return x;
    }
    public int peek(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            System.exit(1);
        }
        return front.data;
    }
    public int size(){
        return size;
    }
    public static void main(String[] args) {
        QueueLinkedList queue = new QueueLinkedList();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        System.out.println(queue.dequeue());
        System.out.println(queue.peek());
        System.out.println(queue.size());
    }
}
