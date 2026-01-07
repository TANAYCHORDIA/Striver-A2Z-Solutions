package slidingWindow;

public class niceSubarrays {
    public static int numberOfSubarrays(int[] nums, int k) {//1 method
       int n = nums.length;
       int le =0;
       int re = 0;
       int odd = 0;
       int cnt = 0;
       int l = 0;
       for(int r=0;r<n;r++){
            if(nums[r]%2==0 && odd ==0){
                le++;
            }
            else if(nums[r]%2==0 && odd ==k){
                re++;
            }
            else if(nums[r]%2!=0)odd++;
            if(odd>k){
                cnt+=(re+1)*(le+1);
                re=0;
                le=0;
                while(l<n && odd!=k){
                    if(nums[l]%2==0);
                    else odd--;
                    l++;
                }
                while(l<n && nums[l]%2==0){
                    if(nums[l]%2==0)le++;
                    l++;
                }
            }
        }
        if(odd==k)cnt+=(re+1)*(le+1); 
        return cnt;
    }

    public static int countSubarrays(int[] arr, int k) {//method 2
        return atMost(arr,k)-atMost(arr,k-1);
    }
    public  static int atMost(int[] nums,int k){
        int count = 0;
        int l = 0;
        int odds = 0;
        int n = nums.length;
        for(int r=0;r<n;r++){
            if (nums[r] % 2 != 0) {
                odds++;
            }
            while (odds > k) {
                if (nums[l] % 2 != 0) {
                    odds--;
                }
                l++;
            }
            count += (r - l + 1);
        }
        return count;
    }
    public static void main(String[] args) {
        int[] nums = {2,2,2,1,2,2,1,2,2,2};
        int k = 2;
        System.out.println(numberOfSubarrays(nums,k));
        System.out.println(countSubarrays(nums,k));
    }
}
