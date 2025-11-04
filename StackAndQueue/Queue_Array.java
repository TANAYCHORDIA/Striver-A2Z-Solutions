package StackAndQueue;

public class Queue_Array {
    private int maxSize;
    private int start,end,curSize;
    private int[] queueArray;
    public Queue_Array(int maxSize){
        this.maxSize = maxSize;
        this.queueArray = new int[maxSize];
        this.start = -1;
        this.end = -1;
        this.curSize = 0;
    }
    public void push(int x){
        if(curSize == maxSize){
            System.out.println("Queue is full cant push");
            System.exit(1);
        }
        if(curSize ==0){
            start = 0;
            end = 0;
        }
        else{
            end = (end+1)%maxSize;
        }
        queueArray[end] = x;
        curSize++;
    }
    public int pop(){
        if(curSize == 0){
            System.out.println("Stack is empty");
            System.exit(1);
        }
        int temp = queueArray[start];
        if(curSize == 1){
            start = -1;
            end = -1;
        }
        else{
            start = (start+1)%maxSize;
        }
        curSize--;
        return temp; 
    }
    public int top(){
        if(curSize == 0){
            System.out.println("Queue is empty");
            System.exit(1);
        }
        return queueArray[start];
    }

    public int size(){
        return curSize;
    }
    public static void main(String[] args) {
        Queue_Array queue = new Queue_Array(5);
        queue.push(10);
        queue.push(20);
        queue.push(30);
        System.out.println("Front element is: " + queue.top()); // 10
        System.out.println("Queue size is: " + queue.size()); // 3
        System.out.println("Popped element is: " + queue.pop()); // 10
        System.out.println("Front element is: " + queue.top()); // 20
    }
}
