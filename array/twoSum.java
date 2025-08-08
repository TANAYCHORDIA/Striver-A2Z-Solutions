package array;

import java.util.Arrays;
import java.util.HashMap;

public class twoSum {
    public static void main(String[] args) {
        int nums[] = {2,6,5,8,11};
        int target = 14;
        System.out.println(Arrays.toString(twoSumSolu(nums, target)));
    }
    static int[] twoSumSolu(int[] nums,int target){
        HashMap<Integer,Integer> mpp = new HashMap<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
           if(mpp.containsKey(target-nums[i])){
                int ind = mpp.get(target-nums[i]);
                return new int[] {ind,i};
           }
           else{
            mpp.put(nums[i],i);
           } 
        }
        return new int[] {-1,-1};
    }
}
