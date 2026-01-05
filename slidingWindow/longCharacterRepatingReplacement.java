package slidingWindow;

public class longCharacterRepatingReplacement {
    public static int characterReplacement(String s, int k) {
        int arr[] = new int[26];
        int l = 0;
        int n = s.length();
        int size = 0;
        int maxCount = 0;
        int ans = 0;
        for(int r = 0;r<n;r++){
            arr[s.charAt(r)-'A']++;
            size++;
            maxCount = maxCount>arr[s.charAt(r)-'A']?maxCount:arr[s.charAt(r)-'A'];
            while(size-maxCount>k){
                arr[s.charAt(l)-'A']--;
                l++;
                size--;
            }
            ans = ans>size?ans:size;
        }
        return ans;
    }
    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;
        System.out.println(characterReplacement(s, k));
    }
}
