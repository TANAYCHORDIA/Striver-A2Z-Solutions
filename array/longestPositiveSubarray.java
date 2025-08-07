package array;
import java.util.*;
public class longestPositiveSubarray {
    public static void main(String[] args) {
        int[] a = {2, 3, 5, 1, 9};
        long k = 10;
        int len = getLongestSubarrayOptimal(a, k);
        System.out.println("The length of the longest subarray is: " + len);
    }
    static int getLongestSubarrayBrute(int[] a,long k){
        int maxLen=0;
        int n=a.length;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                long sum=0;
                for(int m=i;m<=j;m++){
                    sum+=a[m];
                }
                if(sum==k){
                    maxLen = Math.max(maxLen,j-i+1);
                }
            }
        }
        return maxLen;
    }
    static int getLongestSubarrayBrutebetter(int[] a,long k){
        int maxLen=0;
        int n=a.length;
        for(int i=0;i<n;i++){
            long sum=0;
            for(int j=i;j<n;j++){
                sum+=a[j];
                if(sum==k){
                    maxLen = Math.max(maxLen,j-i+1);
                }
            }
        }
        return maxLen;
    }
    static int getLongestSubarraybetter(int a[],long k){
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
    static int getLongestSubarrayOptimal(int a[],long k){
        int maxLen=0;
        int right=0,left=0,sum=a[0];
        int n = a.length;
        while(right<n){
            while(left<=right && sum>k){
                sum-=a[left];
                left++;
            }

            if(sum==k){
                maxLen = Math.max(maxLen,right-left+1);
            }
            right++;
            if(right<n)sum+=a[right];
        }
        return maxLen;
    }
}
