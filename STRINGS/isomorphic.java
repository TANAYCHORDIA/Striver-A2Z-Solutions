package STRINGS;

import java.util.HashMap;

class isomorphic {
    public static void main(String[] args) {
        String s = "paper";
        String t = "title";
        System.out.println(isIsomorphic(s, t));
    }

    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length())
            return false;
        HashMap<Character, Character> mppst = new HashMap<>();
        HashMap<Character, Character> mppts = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char x1 = s.charAt(i);
            char x2 = t.charAt(i);
            if (mppst.containsKey(x1)) {
                if (x2 != mppst.get(x1))
                    return false;
            } else if (mppts.containsKey(x2)) {
                if (x1 != mppts.get(x2))
                    return false;
            } else {
                mppst.put(x1, x2);
                mppts.put(x2, x1);
            }
        }
        return true;
    }
}
