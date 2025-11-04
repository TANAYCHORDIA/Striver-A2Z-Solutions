package StackAndQueue;
class StackNode{
    int data;
    StackNode next;
    StackNode(int data){
        this.data = data;
        this.next = null;
    }
}
public class StackLinkedList {
    StackNode top = null;
    int size = 0;
    public void push(int x){
        StackNode ele = new StackNode(x);
        ele.next = top;
        top = ele;
        size++;
        return;
    }
    public int pop(){
        if(top == null){
            System.out.println("Stack is empty");
            System.exit(1);
        }
        int x = top.data;
        top = top.next;
        size--;
        return x;
    }
    public int peek(){
        if(top == null){
            System.out.println("Stack is empty");
            System.exit(1);
        }
        return top.data;
    }
    public int size(){
        return size;
    }

    public static void main(String[] args) {
        StackLinkedList stack = new StackLinkedList();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.size());
    }

}
