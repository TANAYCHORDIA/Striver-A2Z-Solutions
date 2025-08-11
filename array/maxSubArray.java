package array;

public class maxSubArray {
    public static void main(String[] args) {
        int nums[] = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArraySum(nums));
    }
    public static int maxSubArraySum(int[] nums) {
        int maxsum=Integer.MIN_VALUE;
        int currentSum = 0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(currentSum<0)currentSum=0;
            currentSum+=nums[i];
            if(currentSum>maxsum)maxsum=currentSum;
        }
        return maxsum;
    }
}
