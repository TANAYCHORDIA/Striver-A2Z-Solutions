package array;

public class maxSubArrayPrint {
    public static void main(String[] args) {
        int nums[] = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArraySum(nums));
    }
    public static int maxSubArraySum(int[] nums) {
        int maxsum=Integer.MIN_VALUE;
        int currentSum = 0;
        int n=nums.length;
        int start=0;
        int endIndex=0,startIndex=0;
        for(int i=0;i<n;i++){
            if(currentSum<0){
                currentSum=0;
                start=i;
            }
            currentSum+=nums[i];
            if(currentSum>maxsum){
                maxsum=currentSum;
                endIndex=i;
                startIndex=start;
            }
        }
        System.out.print("[");
        for(int i=startIndex;i<=endIndex;i++){
            System.out.print(nums[i]+",");
        }
        System.out.print("]\n");
        return maxsum;
    }
}
