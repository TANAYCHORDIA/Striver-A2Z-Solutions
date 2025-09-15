package STRINGS;

import java.util.HashMap;

public class anagram {
    public static void main(String[] args) {
        System.out.println(isAnagramBetter("rat", "car"));
        System.out.println(isAnagramOptimal("anagram", "nagaram"));
    }
    public static boolean isAnagramBetter(String s, String t) {
        if(s.length()!=t.length())return false;
        HashMap<Character,Integer> mpp = new HashMap<>();
        int n = s.length();
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            mpp.put(ch, mpp.getOrDefault(ch, 0) + 1);
        }
        for(int i=0;i<n;i++){
            char ch = t.charAt(i);
            if(!mpp.containsKey(ch) || mpp.get(ch)==0) return false;
            mpp.put(t.charAt(i),mpp.get(t.charAt(i))-1);
        }
        return true;
    }
    public static boolean isAnagramOptimal(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] charCounts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            charCounts[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            charCounts[t.charAt(i) - 'a']--;
        }
        for (int count : charCounts) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }
}
