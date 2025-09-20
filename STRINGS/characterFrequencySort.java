package STRINGS;

import java.util.*;

public class characterFrequencySort {
    public static void main(String[] args) {
        System.out.println(frequencySort("Tree"));
    }
    public static String frequencySort(String s) {
        StringBuilder sb = new StringBuilder();
        HashMap<Character,Integer> mpp = new HashMap<>();
        for(int i=0;i<s.length();i++){
            int cnt = mpp.getOrDefault(s.charAt(i),0)+1;
            mpp.put(s.charAt(i),cnt);
        }
        List<Character> chars = new ArrayList<>(mpp.keySet());
        Collections.sort(chars,(a,b)->mpp.get(b)-mpp.get(a));
        for(Character c:chars){
            int count = mpp.get(c);
            for(int i=0;i<count;i++){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
