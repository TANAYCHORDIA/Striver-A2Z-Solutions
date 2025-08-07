package array;

import java.util.HashMap;
import java.util.Map;

public class longestSubarray {
    public static void main(String[] args) {
        int arr[] = {2, 5, -4, 6, -5};
        int k = 3;
        System.out.println(longest(arr,k));
    }
    static int longest(int a[],long k){
        int maxLen=0;
        int n=a.length;
        Map<Long,Integer> ans = new HashMap<>();
        long sum=0;
        for(int i=0;i<n;i++){
            sum+=a[i];
            if(sum==k){
                maxLen = i+1;
            }
            long rem = sum-k;
            if(ans.containsKey(rem)){
                int len = ans.get(rem);
                maxLen = Math.max(maxLen,i-len);
            }

            if(!ans.containsKey(sum)){
                ans.put(sum, i);
            }
        }
        return maxLen;
    }
}
