package binarySearch;

public class lowerBound {
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
        int[] arr = {1,2,4,4,5,6,8};
        int x = 4;
        int n = arr.length;
        int result = LowerBound(arr, n, x);
        System.out.println("Lower bound index of " + x + " is: " + result);
    }
}
