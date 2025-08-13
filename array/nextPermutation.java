package array;

import java.util.Arrays;

public class nextPermutation{
    public static void main(String[] args) {
        int nums[] = {1,3,2};
        nextpermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void nextpermutation(int[] nums) {
        int n=nums.length;
        int ind = -1;
        for(int i =n-2;i>-1;i--){
            if(nums[i]<nums[i+1]){
                ind = i;
                break;
            }
        }
        if(ind == -1){
            reverse(nums,0,n-1);
            return;
        }
        for(int i=n-1;i>ind;i--){
            if(nums[ind]<nums[i]){
                int temp = nums[i];
                nums[i]= nums[ind];
                nums[ind] = temp;
                break;
            }
        }
        reverse(nums,ind+1,n-1);
        return;
    }
    static void reverse(int[] nums,int first,int last){
        while(first<last){
            int temp = nums[first];
            nums[first]= nums[last];
            nums[last] = temp;
            first++;
            last--;
        }
    }
}