package binarySearch;

public class minRotatedArray {
    public static int findMin(int[] nums) {
        int n = nums.length;
        int low =0;
        int high = n-1;
        int min = Integer.MAX_VALUE;
        while(high>=low){
            int mid = low+(high-low)/2;
            if(nums[mid]<min)min = nums[mid];
            if(nums[mid]>nums[high])low = mid+1;
            else{
                high = mid-1;
            }
        }
        return min;
    }
    public static void main(String[] args) {
        int[] nums = {3,4,5,1,2};
        System.out.println(findMin(nums));
    }
}
