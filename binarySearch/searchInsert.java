package binarySearch;

public class searchInsert {
    public static int SearchInsert(int[] nums, int target) {
        int n = nums.length;
        int ans = n;
        int high = n-1;
        int low = 0;
        while(high>=low){
            int mid = low + (high-low)/2;
            if(nums[mid]>=target){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid +1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 5;
        System.out.println(SearchInsert(nums, target));
    }
}
