package STRINGS;

public class removeParenthesis {
    public static void main(String[] args) {
        System.out.println(removeOuterParentheses("(()())(())"));
    }
    public static String removeOuterParentheses(String s) {
        StringBuilder ans = new StringBuilder();
        int count=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                count++;
                if(count>1)ans.append("(");
            }
            else if(s.charAt(i)==')'){
                count--;
                if(count>0)ans.append(")");
            }
            
        }
        return ans.toString();
    }
}
