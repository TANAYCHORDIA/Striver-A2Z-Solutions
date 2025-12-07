package StackAndQueue.Postfix.prefix.infix;

import java.util.Stack;

public class InfixToPostfix {
    public static int prec(char a){
        if(a=='^')return 3;
        else if(a=='*' || a=='/')return 2;
        else if(a== '+' || a== '-')return 1;
        return 0;
    }
    public static void infixtopostfix(String infix){
        int n = infix.length();
        String postfix = "";
        Stack<Character> st = new Stack<>();
        for(int i=0;i<n;i++){
            char c = infix.charAt(i);
            if(Character.isLetterOrDigit(c)){
                postfix+=c;
            }
            else if(c=='(')st.push(c);
            else if(c==')'){
                while(st.peek()!='('){
                    postfix+=st.pop();
                }
                st.pop();
            }
            else{
                while(!st.isEmpty() && (prec(st.peek())>=prec(c)) && c!='^'){
                    postfix+=st.pop();
                }
                st.push(c);
            }
        }
        while(!st.isEmpty())postfix+=st.pop();
        System.out.println("Postfix statment is:"+postfix);
        return;
    }
    public static void main(String[] args) {
        String infix = "a+b*(c^d-e)";
        infixtopostfix(infix);
        return;
    }
}
