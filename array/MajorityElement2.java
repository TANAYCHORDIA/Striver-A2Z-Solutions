package array;

import java.util.ArrayList;
import java.util.List;

public class MajorityElement2 {
    public static void main(String[] args){
        int[] nums = {1, 2, 2, 3, 2, 1, 1, 3};
        System.out.println(majorityElement(nums));
    }
    public static List<Integer> majorityElement(int[] nums) {
        int count1=0,count2=0;
        int num1= Integer.MIN_VALUE,num2 = Integer.MIN_VALUE;
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(num1==nums[i])count1++;
            else if(num2==nums[i])count2++;
            else if(count1==0){
                num1=nums[i];
                count1++;
            }
            else if(count2==0){
                num2=nums[i];
                count2++;
            }
            else{
                count1--;
                count2--;
            }
        }
        count1=0;
        count2=0;
        for(int i=0;i<n;i++){
            if(nums[i]==num1)count1++;
            else if(nums[i]==num2)count2++;
        }
        if(count1>n/3)ans.add(num1);
        if(count2>n/3)ans.add(num2);
        return ans;
    }
}
