package StackAndQueue;

class Stack_Array{
    private int maxSize;
    private int[] stackArray;
    private int top;
    public Stack_Array(int maxSize){
        this.maxSize = maxSize;
        this.stackArray = new int[maxSize];
        this.top = -1;
    }
    public void push(int x){
        if(top == maxSize-1){
            System.out.println("Stack is full");
            return;
        }
        top++;
        stackArray[top] = x;
    }
    public int pop(){
        if(top == -1){
            System.out.println("Stack is already empty");
            System.exit(1);
        }
        int temp = stackArray[top];
        top--;
        return temp;
    }
    public int peek(){
        if(top==-1){
            System.out.println("Stack is empty");
            System.exit(1);
        }
        return stackArray[top];
    }

    public int size(){
        return top+1;
    }

    public static void main(String[] args) {
        Stack_Array stack = new Stack_Array(5);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Top element is: " + stack.peek()); // 30
        System.out.println("Stack size is: " + stack.size()); // 3
        System.out.println("Popped element is: " + stack.pop()); // 30
        System.out.println("Top element is: " + stack.peek()); // 20
    }
}