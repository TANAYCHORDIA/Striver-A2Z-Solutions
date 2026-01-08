package slidingWindow;

public class substringsThreeChar {
    public static int numberOfSubstrings(String s) {
        int n = s.length();
        int arr[] = new int[3];
        int l = 0;
        int cnt = 0;
        for(int r=0;r<n;r++){
            arr[s.charAt(r)-'a']++;
            while(l<n && (arr[0]>0 && arr[1]>0 && arr[2]>0)){
                cnt+=n-r;
                arr[s.charAt(l)-'a']--;
                l++;
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        String s = "abcabc";
        System.out.println(numberOfSubstrings(s));
    }
}
