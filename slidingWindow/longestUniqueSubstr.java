package slidingWindow;

import java.util.HashMap;

public class longestUniqueSubstr {
    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> mpp = new HashMap<>();
        int maxCount = 0;
        int j = 0;
        for(int i=0;i<s.length();i++){
            if(mpp.containsKey(s.charAt(i)) && mpp.get(s.charAt(i))>=j){
                j = mpp.get(s.charAt(i))+1;
            }
            mpp.put(s.charAt(i),i);
            maxCount = (i-j+1)>maxCount?(i-j+1):maxCount;
        }
        
        return maxCount;
    }
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
