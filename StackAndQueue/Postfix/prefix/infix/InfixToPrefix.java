package StackAndQueue.Postfix.prefix.infix;

import java.util.Stack;

public class InfixToPrefix {
    public static int prec(char a){
        if(a=='^')return 3;
        else if(a=='*' || a=='/')return 2;
        else if(a== '+' || a== '-')return 1;
        return 0;
    }
    public static StringBuilder infixtopostfix(StringBuilder infix){
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
                if(c=='^'){
                    while(!st.isEmpty() && (prec(st.peek())>=prec(c)))postfix+=st.pop();
                }
                else{
                    while(!st.isEmpty() && (prec(st.peek())>prec(c))){
                        postfix+=st.pop();
                    }
                }
                st.push(c);
            }
        }
        while(!st.isEmpty())postfix+=st.pop();
        return new StringBuilder(postfix);
    }
    public static void infixtoprefix(String infix){
        StringBuilder revInfix = new StringBuilder(infix);
        revInfix.reverse();
        int n = revInfix.length();
        for(int i=0;i<n;i++){
            if(revInfix.charAt(i)=='(')revInfix.setCharAt(i, ')');
            else if(revInfix.charAt(i) == ')')revInfix.setCharAt(i, '(');
        }
        revInfix = infixtopostfix(revInfix);
        revInfix.reverse();
        System.out.println("Prefix is:"+revInfix);
    }
    public static void main(String[] args) {
        String infix = "a+b*(c^d-e)";
        infixtoprefix(infix);
        return;
    }
}
