package STRINGS;

class parenthesesDepth{
    public static void main(String[] args) {
        System.out.println(maxDepth("(1)+((2))+(((3)))"));
    }
    public static int maxDepth(String s) {
        int count = 0;
        int maxCount = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(')count++;
            else if(s.charAt(i)==')'){
                maxCount = Math.max(maxCount,count);
                count--;
            }
        }
        return maxCount;
    }
}