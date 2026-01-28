package binarySearch;

public class searchRotatedArray2 {
    public static boolean search(int[] nums, int target) {
        int low = 0;
        int n = nums.length;
        int high = n-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid]==target)return true;
            else if(nums[low]==nums[mid] && nums[high]==nums[mid]){
                low++;
                high--;
            }
            else if(nums[mid]<=nums[high]){
                if(nums[mid]<=target && nums[high]>=target){
                    low = mid+1;
                }
                else high = mid-1;
                
            }
            else{
                if(target<=nums[mid] && target>=nums[low])high = mid-1;
                else low = mid+1;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] nums = {2,5,6,0,0,1,2};
        int target = 0;
        System.out.println(search(nums,target));
    }
}
