package StackAndQueue;
import java.util.*;

class remvoveKDigits{
    public static String removeKDigits(String num, int k) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> st = new Stack<>();
        int n = num.length();
        for(int i =0;i<n;i++){
            char c = num.charAt(i);
            while(!st.isEmpty() && st.peek()-'0'>c-'0' && k>0){
                st.pop();
                k--;
            }
            st.push(c);
        }
        while(k>0){
            st.pop();
            k--;
        }
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        while(sb.length()>0 && sb.charAt(sb.length()-1)=='0')sb.deleteCharAt(sb.length()-1);
        sb.reverse();
        return sb.length()>0?sb.toString():"0";
    }
    public static void main(String[] args) {
        String num = "1432219";
        int k = 3;
        System.out.println(removeKDigits(num, k)); 
    }
}