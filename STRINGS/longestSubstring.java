package STRINGS;

import java.util.Arrays;

class longestSubstring{
    public static void main(String[] args) {
        String arr[] = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(arr));
    }
    public static String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        int i=0;
        String first = strs[0];
        String last = strs[strs.length-1];
        while(i<first.length() && i<last.length() && first.charAt(i)==last.charAt(i))i++;
        StringBuilder sb = new StringBuilder();
        for(int j=0;j<i;j++){
            sb.append(first.charAt(j));
        }
        return sb.toString();
    }
}