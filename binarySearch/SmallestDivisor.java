package binarySearch;

public class SmallestDivisor {
    public static int smallestDivisor(int[] nums, int threshold) {
        int ans = Integer.MAX_VALUE;
        int low = 1;
        int high = max(nums);
        while(low<=high){
            int mid = low+(high-low)/2;
            int check = sumdiv(nums,mid);
            if(check>threshold)low = mid+1;
            else{
                high = mid-1;
                ans = mid;
            }
        }
        return ans;
    }
    public static int max(int[] nums){
        int maxNo = nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]>maxNo)maxNo = nums[i];
        }
        return maxNo;
    }
    public static int sumdiv(int nums[],int mid){
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum+=(nums[i]+mid-1)/mid;
        }
        return sum;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,5,9};
        int threshold = 6;
        System.out.println(smallestDivisor(nums,threshold));
    }
}
