package STRINGS;
import java.util.*;
public class beautyStringSum {
    public static void main(String[] args) {
        System.out.println(sumOfBeauty("aabcbaa"));
    }   
    public static int sumOfBeauty(String s) {
        int ans = 0;
        for(int i=0;i<s.length();i++){
            HashMap<Character,Integer> mpp = new HashMap<>();
            for(int j=i;j<s.length();j++){
                mpp.put(s.charAt(j),mpp.getOrDefault(s.charAt(j),0)+1);
                ans+=(Collections.max(mpp.values())-Collections.min(mpp.values()));
            }
            
        }
        return ans;
    }
}   