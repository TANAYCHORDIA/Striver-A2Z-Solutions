package StackAndQueue;

public class validParenthesis {
    public static void main(String[] args) {
        String s = "{[()]";
        System.out.println(isValid(s));
    }
    public static void push(char c,char arr[],int index){
        arr[index] = c;
        return;
    }
    public static char pop(char arr[],int index){
        if(index<0)return 'i';
        char c = arr[index];
        return c;
    }
    public static boolean isMatching(char op,char cl){
        if(op=='('&&cl==')' || op=='['&&cl==']' || op=='{'&&cl=='}')return  true;
        return false;
    }
    public static boolean isValid(String s) {
        int len = s.length();
        char arr[] = new char[len];
        int index = -1;
        for(int i=0;i<len;i++){
            char c = s.charAt(i);
            if(c=='(' || c=='{' || c=='['){
                index++;
                push(c,arr,index);
            }
            else{
                char popped = pop(arr,index);
                index--;
                if(!isMatching(popped,c))return false;
            }
        }
        if(index==-1)return true;
        return false;
    }
}
