package STRINGS;

public class subStringPali {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }
    public static String longestPalindrome(String s) {
        int maxCount=0;
        int maxLeft = 0;
        int maxRight = 0;
        int n=s.length();
        for(int i=0;i<n;i++){
            int count1 = expand(s,i,i);
            int count2 = expand(s,i,i+1);
            maxCount = Math.max(count1,count2);
            if(maxCount>maxRight-maxLeft){
                maxLeft = i-(maxCount-1)/2;
                maxRight = i+maxCount/2;
            }
        }
        
        return s.substring(maxLeft,maxRight+1);
    }
    public static int expand(String s,int left,int right){
        while(left>=0 && right<s.length()){
            if(s.charAt(left)==s.charAt(right)){
                left--;
                right++;
            }
            else break;
        }
        return right-left-1;
    }
}
