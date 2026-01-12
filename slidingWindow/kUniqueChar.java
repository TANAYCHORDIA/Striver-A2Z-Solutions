package slidingWindow;
public class kUniqueChar {
    public static int longestKSubstr(String s, int k) {
        int arr[] = new int[26];
        int n = s.length();
        int l = 0;
        int cnt = 0;
        for(int r =0;r<n;r++){
            if(k==0 && arr[s.charAt(r)-'a']==0){
                while(l<n && k==0){
                    arr[s.charAt(l)-'a']--;
                    if(arr[s.charAt(l)-'a']==0)k++;
                    l++;
                }            
            }
            if(arr[s.charAt(r)-'a']==0 && k>0){
                arr[s.charAt(r)-'a']++;
                k--;
            }
            else if(arr[s.charAt(r)-'a']>0)arr[s.charAt(r)-'a']++;
            if(k==0)cnt = cnt>(r-l+1)?cnt:(r-l+1);
        }
        if(k!=0 && cnt==0)return -1;
        if(cnt==0)return n;
        return cnt;
    }
    public static void main(String[] args) {
        String s = "aabacbebebe";
        int k = 3;
        System.out.println(longestKSubstr(s, k));
    }
}
