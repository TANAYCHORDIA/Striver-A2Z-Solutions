package array;

import java.util.*;


public class threeSum {
    public static void main(String args[]){
        int nums[] = {-1,0,1,2,-1,-4};
        System.out.println(ThreeSum(nums, 0));
        
    }
    public static List<List<Integer>> ThreeSum(int[] nums, int x) {
        List<List<Integer>> ans = new ArrayList<>(); 
        int n = nums.length;
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            if(i>0 && nums[i]==nums[i-1])continue;
            int k = n-1;
            int j = i+1;
            while(k>j){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum>x){
                    k--;
                }
                else if(sum<x){
                    j++;
                }
                else{
                    List<Integer> temp = Arrays.asList(nums[i],nums[j],nums[k]);
                    ans.add(temp);
                    k--;
                    j++;
                    while(j<k && nums[j]==nums[j-1]) j++;
                    while(j<k && nums[k]==nums[k+1])k--;
                }
            }
        
        }
            return ans;
    }
}
