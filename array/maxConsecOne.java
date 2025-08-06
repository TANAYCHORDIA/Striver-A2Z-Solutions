package array;

public class maxConsecOne {
    public static void main(String[] args) {
        int nums[] = {1,1,0,0,1,1,1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }
    public static int findMaxConsecutiveOnes(int[] nums) {
        int max=0;
        int count=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]==1)count++;
            else{
                count=0;
            }
            if(count>max)max=count;
        }
        return max;
    }
}
