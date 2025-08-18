package array;

import java.util.HashMap;

public class freqSubarraySumK {
    public static void main(String[] args) {
        int arr[] = {1,2,3};
        int k = 3;
        System.out.println(cntSubarrays(arr, k));
    }
    public static int cntSubarrays(int[] arr, int k) {
        int cnt = 0;
        int n = arr.length;
        HashMap<Integer,Integer> mpp = new HashMap<>();
        int preSum = 0;
        mpp.put(0,1);
        for(int i=0;i<n;i++){
            preSum+=arr[i];
            
            int rem = preSum - k;
            cnt+= mpp.getOrDefault(rem,0);
            mpp.put(preSum,mpp.getOrDefault(preSum,0)+1);
        }
        return cnt;
    }
}
