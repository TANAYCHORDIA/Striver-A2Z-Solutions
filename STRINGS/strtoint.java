package STRINGS;

public class strtoint {
    public static void main(String[] args) {
        System.out.println(myAtoi("-23562hello3e32"));
    }
    public static int myAtoi(String s) {
        long res = 0;
        int n = s.length();
        if(n==0 || s==null)return 0;
        int i=0;
        int sign = 1;
        while(i<n && s.charAt(i)==' ')i++;
        if(i<n &&(s.charAt(i)=='+' || s.charAt(i)=='-')){
            sign = s.charAt(i)=='+'?1:-1;
            i++;
        }
        while(i<n && s.charAt(i)>='0' && s.charAt(i)<='9'){
            int digit =s.charAt(i)-'0';
            res = res*10+digit;
            i++;
            if(sign*res<Integer.MIN_VALUE)return Integer.MIN_VALUE;
            else if(sign*res>Integer.MAX_VALUE)return Integer.MAX_VALUE;
        }
        return (int)(sign*res);
    }
}
