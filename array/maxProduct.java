package array;
public class maxProduct{
    public static void main(String[] args) {
        int arr[] = {-2, 6, -3, -10, 0, 2};
        System.out.println(maxProductSubArray(arr));
    }
     public static int maxProductSubArray(int[] nums) {
        int n = nums.length;
        long prefix = 1;
        long suffix = 1;
        long max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(prefix==0)prefix=1;
            if(suffix==0)suffix=1;
            prefix *= nums[i];
            suffix*=nums[n-1-i];
            max=Math.max(max,prefix);
            max = Math.max(max,suffix);
        }
        return (int)max;
    }
}