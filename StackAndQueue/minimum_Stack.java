package StackAndQueue;
class minimum_Stack {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // Returns -3.
        minStack.pop();
        System.out.println(minStack.top());    // Returns 0.
        System.out.println(minStack.getMin()); // Returns -2.
    }
}
class MinStack {
    class stack{
        int data;
        int min;
        stack next;
        stack(int data){
            this.data = data;
            this.next = null;
        }
    }
    stack top;
    public MinStack() {
        top = null;
    }
    
    public void push(int val) {
        stack temp = new stack(val);
        if(top == null){
            top = temp;
            temp.min = top.data;
        }
        else{
            temp.next = top;
            if(temp.data<top.min)temp.min = temp.data;
            else temp.min = top.min;
            top = temp;
        }
    }
    
    public void pop() {
        top = top.next;
    }
    
    public int top() {
        return top.data;
    }
    
    public int getMin() {
        return top.min;
    }
}
