package array;
//number range is 1 to N
public class missingElement {
   public static void main(String[] args) {
        int nums[]={3,2,1,5,6};
        System.out.println(missingElementsum(nums));
        System.out.println(missingElementxor(nums));
   }
   public static int missingElementsum(int[] nums){
        int n =nums.length+1;
        int sum=(n*(n+1))/2;
        for(int i=0;i<n-1;i++)sum-=nums[i];
        return sum; 
   } 
   public static int missingElementxor(int[] nums){
    int n =nums.length;
        int xor1=0;
        int xor2=0;
        for(int i =0;i<n;i++){
            xor1^=(i+1);
            xor2^=nums[i];
        }
        xor1^=n+1;
        return xor1^xor2;
   }
}
