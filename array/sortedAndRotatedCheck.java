package array;

public class sortedAndRotatedCheck {
    public static void main(String[] args){
        int nums[] = {3,4,5,1,2};
        System.out.println("The array is sorted and rotated:"+check(nums));
    }
    public static boolean check(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i+1] < nums[i])  count++;
        }
        if(nums[0]<nums[nums.length-1])count++;
        if (count <= 1) return true;
        else return false;
    }
    /*Revision-27/07/26-another approach
    public boolean check(int[] nums) {
        int peak = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>nums[(i+1)%nums.length])peak++;
        }
        if(peak<=1)return true;
        return false;
    } */
    
}
