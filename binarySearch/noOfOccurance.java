package binarySearch;

public class noOfOccurance {
    public static int  countFreq(int[] arr, int target) {
        int lb = LowerBound(arr,arr.length,target);
        if(lb==arr.length || arr[lb]!=target)return 0;
        return UpperBound(arr,target,arr.length)-lb;
    }
    public static int UpperBound(int []arr, int x, int n){
        int low = 0;
        int high = n-1;
        int ans = n;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid]>x){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }
    public static int LowerBound(int []arr, int n, int x) {
        int low = 0;
        int high = n-1;
        int ans = n;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid]>=x){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,2,2,3,4,5};
        int target = 2;
        int result = countFreq(arr, target);
        System.out.println("Number of occurrences of " + target + " is: " + result);
    }
}
