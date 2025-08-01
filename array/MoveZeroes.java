package array;

import java.util.Arrays;

public class MoveZeroes {
    public static void main(String[] args){
        int[] nums = {1,0,2,3,2,0,0,4,5,1};
        moveZeroes(nums);
        System.out.println("Modified array:"+Arrays.toString(nums));
    }
    public static void moveZeroes(int[] nums) {
        int i=0;
        int n= nums.length;
        for(int j=0;j<n;j++){
            if(nums[j]!=0){
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
                i++;
            }
        }
    }
}
