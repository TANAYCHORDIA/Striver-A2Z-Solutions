package slidingWindow;

import java.util.HashMap;

public class kDistinctNo {
    public static int subarraysWithKDistinct(int[] nums, int k) {
        return atmost(nums,k)-atmost(nums,k-1);
    }
    public static int atmost(int[] nums,int k){
        HashMap<Integer,Integer> mpp = new HashMap<>();
        int n = nums.length;
        int l = 0;
        int cnt = 0;
        for(int r =0;r<n;r++){
            mpp.put(nums[r],mpp.getOrDefault(nums[r],0)+1);
            if(mpp.get(nums[r])==1){
                k--;
            }
            while(k<0){
                mpp.put(nums[l], mpp.get(nums[l]) - 1);
                if (mpp.get(nums[l]) == 0) {
                    k++;
                    mpp.remove(nums[l]);
                }
                l++;

            }
            cnt+=(r-l+1);
        }
        return cnt;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,1,2,3};
        int k = 2;
        System.out.println(subarraysWithKDistinct(nums, k));
    }
}
