package StackAndQueue.Postfix.prefix.infix;

public class evaluate_postfix {
    public static int evaluate(int op1,int op2, String c){
        switch(c){
            case "+":
                return op1+op2;
            case "-":
                return op1-op2;
            case "*":
                return op1*op2;
            case "/":
                return op1/op2;
        }
        return 0;
    }
    public static boolean isNumeric(String c){
        try{
            Integer.parseInt(c);
            return true;
        }
        catch(NumberFormatException e){
            return false;
        }
    }
    public static int evalRPN(String[] tokens) {
        int n = tokens.length;
        int stack[] = new int[n];
        int top = -1;
        for(int i=0;i<n;i++){
            String c = tokens[i];
            if(isNumeric(c)){
                stack[++top] = Integer.parseInt(c);
            }
            else{
                int op2 = stack[top--];
                int op1 = stack[top--];
                int ans = evaluate(op1,op2,c);
                stack[++top] = ans; 
            }
        }
        return stack[top];
    }

    public static void main(String[] args) {
        String[] tokens = {"2", "1", "+", "3", "*"};
        System.out.println(evalRPN(tokens));
    }
}
//For a better approach first check if the charcter is a operator  if not we know its operand and we can directly push it into the stack