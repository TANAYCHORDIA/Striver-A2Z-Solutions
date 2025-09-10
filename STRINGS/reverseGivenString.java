package STRINGS;

public class reverseGivenString {
    public static void main(String[] args) {
        System.out.println(reverseWords("a good   example"));
    }
    public static String reverseWords(String s) {
        int n =s.length();
        int i=n-1;
        int j=0;
        StringBuilder sb = new StringBuilder();
    while(i>=0){
        while(i>=0 && s.charAt(i)==' '){
            i--;
        }
        if(i<0)break;
        j=i;
        while(i>=0 && s.charAt(i)!=' ')i--;
        sb.append(s.substring(i+1,j+1));
        sb.append(" ");
    }
    if(sb.length()>0)sb.deleteCharAt(sb.length()-1);
    return sb.toString();
    }
}
