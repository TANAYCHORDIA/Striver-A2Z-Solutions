package slidingWindow;

public class maxConsecutiveOnes3 {
    public static int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int maxCount = 0;
        int zero = 0;
        int l = 0;
        int r =  0;
        while(r<n){
            if(nums[r]==0)zero++;
            while(zero>k){
                if(nums[l] == 0)zero--;
                l++;
            }
            maxCount = (r-l+1)>maxCount?(r-l+1):maxCount; 
            r++;
        }
        return maxCount;
    }
    public static void main(String[] args) {
        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;
        System.out.println(longestOnes(nums,k));
    }
}
