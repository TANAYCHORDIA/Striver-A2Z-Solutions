package slidingWindow;

public class minWindowSubstr {
    public static String minWindow(String s, String t) {
        int mpp[] = new int[128];
        int cnt = 0;
        for (int i = 0; i < t.length(); i++) {
            mpp[t.charAt(i)]++;
        }
        int l = 0;
        int minLen = Integer.MAX_VALUE;
        int start = -1;
        for (int r = 0; r < s.length(); r++) {
            if (mpp[s.charAt(r)] > 0)cnt++;
            mpp[s.charAt(r)]--;
            while (l < s.length() && cnt == t.length()) {
                if (minLen > (r - l + 1)) {
                    minLen = r - l + 1;
                    start = l;
                }
                mpp[s.charAt(l)]++;
                if (mpp[s.charAt(l)] > 0)cnt--;
                l++;
            }
        }
        if (start == -1)return "";
        return s.substring(start, start + minLen);
    }
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
    }
}
